package com.juliar.errors;

/**
 * Created by AndreiM on 12/27/2016.
 */
public class PrintError {
    private static boolean hasError = false;
    private static int errors = 0;


    public static boolean hasErrors(){
        return hasError;
    }

    public static void errorFound(){
        hasError = true;
        errors++;
    }

    public static int getNumberOfErrors(){
        return errors;
    }

    public static void exitIfErrors(){
        if(PrintError.hasError){
            System.err.println("Found "+errors+" errors!");
            System.exit(1);
        }
    }

    public PrintError(String Message){
        System.out.println("Error: " + Message);
    }

    public PrintError(String Message,Exception Type){
        System.out.println("Error: " + Message);
    }

    public static void message(String message){
        System.out.println( message );
    }
}
