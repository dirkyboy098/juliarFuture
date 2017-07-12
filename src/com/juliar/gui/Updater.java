package com.juliar.gui;

import com.juliar.errors.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by AndreiM on 5/22/2017.
 */
public class Updater {
    public Updater(){
        Scanner scanner = null;
        String version = "";
        try {
            scanner = new Scanner(new URL("https://juliar.org/version.txt").openStream(), "UTF-8");
            scanner.useDelimiter("\\A");
            version = scanner.next();
        } catch (IOException e) {
            Logger.log("Failed to access Juliar Website");
        }
        if(!version.equals(checksum())){
            /*TODO DOWNLOAD NEW VERSION OF JAR FILE*/
        }
    }

    public StringBuilder checksum(){
        File currentJavaJarFile = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        String filepath = currentJavaJarFile.getAbsolutePath();
        StringBuilder sb = new StringBuilder();
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-256");// MD5
            FileInputStream fis = new FileInputStream(filepath);
            byte[] dataBytes = new byte[1024];
            int nread = 0;

            while((nread = fis.read(dataBytes)) != -1)
                md.update(dataBytes, 0, nread);

            byte[] mdbytes = md.digest();

            for(int i=0; i<mdbytes.length; i++)
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100 , 16).substring(1));
        }
        catch(NoSuchAlgorithmException e)
        {
            Logger.log(e);
        }
        catch(IOException e)
        {
            Logger.log(e);
        }

        return sb;
    }

}
