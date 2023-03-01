package com.example.LMS.Services;

import java.util.List;
import com.example.LMS.DTOs.BookRequestDto;
import com.example.LMS.DTOs.IssueBookRequestDto;
import com.example.LMS.Enums.CardStatus;
import com.example.LMS.Enums.TransactionStatus;
import com.example.LMS.Models.Book;
import com.example.LMS.Models.Card;
import com.example.LMS.Models.Transactions;
import com.example.LMS.Repositories.BookRepository;
import com.example.LMS.Repositories.CardRepository;
import com.example.LMS.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBook(IssueBookRequestDto issueBookRequestDto)throws Exception{
        int bookId=issueBookRequestDto.getBookId();
        int cardId=issueBookRequestDto.getCardId();

        //Get Book and Card Entity
        //Because we want to set the transaction entity

        Book book=bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        //Transaction Entity
        Transactions transaction=new Transactions();
        //Setting attributes
        transaction.setBook(book);
        transaction.setCard(card);
              //transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssueOperation(true);
        transaction.setTransactionStatus(TransactionStatus.PENDING);
        //Validations
        if(book == null || book.getIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available!!");
        }

        if(card==null|| !card.getCardStatus().equals(CardStatus.ACTIVATED)){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not valid");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);

        //Book-Transaction
        List <Transactions> listOfTransactionForBook=book.getListOftransactions();
        listOfTransactionForBook.add(transaction);
        book.setListOftransactions(listOfTransactionForBook);

        //Book-Card
        List<Book> issuedBooksForCard=card.getBooksIssued();
        issuedBooksForCard.add(book);
        card.setBooksIssued(issuedBooksForCard);

        //Card-Transaction
        List<Transactions> listOfTransactionForCard=card.getListOfTransaction();
        listOfTransactionForCard.add(transaction);
        card.setListOfTransaction(listOfTransactionForCard);

        //Save the parent
        cardRepository.save(card);
        return transaction.getTransactionId();
    }

    public String getTransactions(int bookId, int cardId){
        List<Transactions> transactionsList=transactionRepository.getTransactionsForBookAndCard(bookId,cardId);
        String transactionId=transactionsList.get(0).getTransactionId();
        return transactionId;
    }
}
