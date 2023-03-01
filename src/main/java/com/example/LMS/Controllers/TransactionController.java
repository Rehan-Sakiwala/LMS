package com.example.LMS.Controllers;

import com.example.LMS.DTOs.IssueBookRequestDto;
import com.example.LMS.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public String issueBook(@RequestBody IssueBookRequestDto issueBookRequestDto) throws Exception {

        try{
            return transactionService.issueBook(issueBookRequestDto);
        }
        catch (Exception e){
            return e.getMessage();
        }

    }

    @GetMapping("/get-transaction-info")
    public String getTransactionEntry(@RequestParam("bookId")int bookId, @RequestParam("cardId")int cardId){
        return transactionService.getTransactions(bookId,cardId);
    }
}
