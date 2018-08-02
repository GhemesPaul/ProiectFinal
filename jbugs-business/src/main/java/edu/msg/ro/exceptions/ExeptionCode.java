package edu.msg.ro.exceptions;

public enum ExeptionCode {
    USER_VALIDATION_EXEPTION(1,"Validation exeption"),
    EMAIL_EXISTS_EXEPTION(2,"The Email already exists");

    int id;
    String message;

    ExeptionCode(int id, String message){
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
