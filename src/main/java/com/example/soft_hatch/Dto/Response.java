package com.example.soft_hatch.Dto;

public class Response {
    public String status;
    public String message;
    public Object data;

    public static enum STATUS{
        Success,Failed;
    }
    public Response() {
        this.status = STATUS.Success.toString();
    }
}
