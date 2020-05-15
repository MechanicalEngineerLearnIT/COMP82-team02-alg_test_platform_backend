package com.example.demo.model;





import java.sql.Timestamp;

public class history {
    private String userEmail;
    private java.sql.Timestamp submissionTime;
    private String possibility;
    private String fileName;


    public history() {
    }

    public history(String userEmail, java.sql.Timestamp submissionTime, String possibility, String fileName) {
        this.userEmail = userEmail;
        this.submissionTime =  submissionTime;
        this.possibility = possibility;
        this.fileName = fileName;

    }



    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public java.sql.Timestamp getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(java.sql.Timestamp submissionTime) {
        this.submissionTime = (Timestamp) submissionTime;
    }

    public String getPossibility() {
        return possibility;
    }

    public void setPossibility(String possibility) {
        this.possibility = possibility;
    }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
