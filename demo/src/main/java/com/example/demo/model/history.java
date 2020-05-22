package com.example.demo.model;





import java.sql.Timestamp;

public class history {
    private String userEmail;
    private java.sql.Timestamp submissionTime;
    private String result;
    private String threshold;
    private String fileName;
    private String n_gram;
    private String conclusion;



    public history() {
    }

    public history(String userEmail, java.sql.Timestamp submissionTime, String result, String threshold,String fileName,String n_gram, String conclusion) {
        this.userEmail = userEmail;
        this.submissionTime =  submissionTime;
        this.result = result;
        this.threshold = threshold;
        this.fileName = fileName;
        this.n_gram = n_gram;
        this.conclusion = conclusion;

    }



    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getSubmissionTime() {
        return submissionTime.toString();
    }

    public void setSubmissionTime(java.sql.Timestamp submissionTime) {
        this.submissionTime = (Timestamp) submissionTime;
    }

    public String getResult() { return result; }

    public void setResult(String result) {
        this.result = result;
    }

    public String getThreshold() { return threshold; }

    public void setThreshold(String threshold) { this.threshold = threshold; }

    public String getFileName() { return fileName; }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getN_gram() { return n_gram; }

    public void setN_gram(String n_gram) {
        this.n_gram = n_gram;
    }

    public String getConclusion() { return conclusion; }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }
}
