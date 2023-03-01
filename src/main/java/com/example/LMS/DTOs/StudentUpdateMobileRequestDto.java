package com.example.LMS.DTOs;

public class StudentUpdateMobileRequestDto {
    private int id;
    private String mobileNo;

    public StudentUpdateMobileRequestDto(int id, String mobileNo) {
        this.id = id;
        this.mobileNo = mobileNo;
    }

    public StudentUpdateMobileRequestDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
