package com.example.soft_hatch.exception;

public class FileStorageException extends RuntimeException{
    public FileStorageException(String message,Throwable cause){
        super(message,cause);
    }
}
