package com.techelevator.temart.exception;

import javax.sql.DataSource;

public class DaoException extends RuntimeException{
    public DaoException(String message){
        super(message);
    }
    public DaoException(String message, Throwable cause) {
        super (message,cause);
    }
}
