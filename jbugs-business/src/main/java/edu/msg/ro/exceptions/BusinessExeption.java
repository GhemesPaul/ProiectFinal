package edu.msg.ro.exceptions;

public class BusinessExeption extends  Exception{

    ExeptionCode exeptionCode;

    public BusinessExeption() {
    }

    public BusinessExeption(ExeptionCode exeptionCode) {
        this.exeptionCode = exeptionCode;
    }

    public BusinessExeption(ExeptionCode exeptionCode,String message, Throwable cause) {
        super(message, cause);
        this.exeptionCode = exeptionCode;
    }

    public BusinessExeption(ExeptionCode exeptionCode,Throwable cause) {
        super(cause);
        this.exeptionCode = exeptionCode;
    }

    public BusinessExeption(ExeptionCode exeptionCode,String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.exeptionCode = exeptionCode;
    }
}
