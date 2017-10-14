package com.juliar.jpm;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class JPM {
    private static String downloadUrlContent(){
        try {
            URL url = new URL("https://juliar.org/repo?package=JuliarFuture&download=0");
            HttpURLConnection hConnection = (HttpURLConnection) url.openConnection();
            HttpURLConnection.setFollowRedirects(true);
            if (HttpURLConnection.HTTP_OK == hConnection.getResponseCode()) {
                BufferedReader is = new BufferedReader(new InputStreamReader(hConnection.getInputStream()));
                return is.readLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return "";
    }

    private static boolean downloadPackage(){
        URL url;
        try {
            url = new URL("https://juliar.org/repo?package=JuliarFuture&download=1");
            HttpURLConnection hConnection = (HttpURLConnection) url
                    .openConnection();
            HttpURLConnection.setFollowRedirects(true);
            if (HttpURLConnection.HTTP_OK == hConnection.getResponseCode()) {
                InputStream in = hConnection.getInputStream();
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream("JuliarFuture.jar"));
                int file_size = hConnection.getContentLength();
                byte[] buffer = new byte[4096];
                int numRead;
                long numWritten = 0;
                while ((numRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, numRead);
                    numWritten += numRead;
                    System.out.println((double)numWritten/(double)file_size);
                }
                if(file_size!=numWritten)
                    System.out.println("Wrote "+numWritten+" bytes, should have been "+file_size);
                else
                    System.out.println("Downloaded successfully.");
                out.close();
                in.close();
            }
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException, ParseException {
        String new_v = downloadUrlContent();
        URL old_v = JPM.class.getResource("/com/juliar/JuliarCompiler.class");

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date new_version;
        new_version = df.parse(new_v);
        Date old_version = new Date(old_v.openConnection().getLastModified());

        if (new_version.after(old_version)){
                System.out.println("A new version of Juliar.Future Compiler is available," + old_version + " => " + new_version + " would you like to download? (yes/No)");
                Scanner scan = new Scanner(System.in);
                String choice = scan.nextLine();
                if (choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y")) {
                    downloadPackage();
                }else{
                    System.out.println("Juliar.Future has not been downloaded!");
                }
        }
        else {
            System.out.println("No update available for Juliar.Future. You are using version: " + old_version);
        }
    }
}