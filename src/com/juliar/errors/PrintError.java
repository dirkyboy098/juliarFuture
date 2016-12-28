package com.juliar.errors;

/**
 * Created by AndreiM on 12/27/2016.
 */
public class PrintError {
    public PrintError(){}
    public PrintError(String Message){
        System.out.println(Message);
    }
    public PrintError(String Message,Exception Type){
        System.out.println(Message);
    }
}
