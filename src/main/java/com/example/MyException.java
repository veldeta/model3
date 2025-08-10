package com.example;

public class MyException extends Exception {

    public MyException(String message)
    {
        super(message);
    }
    
    public MyException(String message, Throwable e)
    {
        super(message, e);
    }

    public static void ex()
    {
        
    }
}
