package com.juliar.errors;

/**
 * Created by AndreiM on 12/27/2016.
 */
public class Logger {
    private static boolean hasError = false;
    private static int errors = 0;


    public static boolean hasErrors(){
        return hasError;
    }

    public static void log(String msg){
        System.out.println(msg);
    }

    public static void log(String msg,Exception e){
        System.out.println(msg);
    }

    public static void log(Exception e){
        System.out.println(e.getMessage());
    }


    public static void logerr(String msg){
        System.err.println(msg);
    }

    public static void errorFound(){
        hasError = true;
        errors++;
    }

    public static int getNumberOfErrors(){
        return errors;
    }

    public static void exitIfErrors(){
        if(Logger.hasError){
            System.err.println("Found "+errors+" errors!");
            System.exit(1);
        }
    }

    public Logger(String Message){
        System.out.println("Error: " + Message);
    }

    public Logger(String Message, Exception Type){
        System.out.println("Error: " + Message);
    }

    public static void message(String message){
        System.out.println( message );
    }
}
