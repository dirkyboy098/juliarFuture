import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.*;


public class JPM {
    public static boolean saveUrlContent(String url,String filename){
        try {
            URL website = new URL(url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            String routePath = JPM.class.getResource(File.separator).getPath();
            FileOutputStream fos = new FileOutputStream(routePath+File.separator+".."+File.separator+filename);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            return true;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static String getUrlContent(String myurl){
        try {
            URL url = new URL(myurl);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
            BufferedReader bufferedReader = new BufferedReader(new  InputStreamReader(urlConnection.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
            bufferedReader.close();
            return stringBuilder.toString();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static double getUrlVersion(String urlname){
            String content = getUrlContent(urlname);
            int start = content.indexOf("*version ");
            if(start == -1) return 0;
            int end = content.indexOf("*",start+9);
            return Double.parseDouble(content.substring(start+9,end));
    }
    public static List<List<String>> generateModuleList(){
        List<List<String>> listOfListOfStrings = new ArrayList<List<String>>();
        List<String> names_list = new ArrayList<String>();
        List<String> versions_list = new ArrayList<String>();
        String content = "";
        try {
            String path = (new File(".")).getAbsolutePath()+"/packages.jrl";
            content = new String(Files.readAllBytes(Paths.get(path)));
        }
        catch(Exception e) {

            e.printStackTrace();
            return listOfListOfStrings;
        }
        int myindex = 0;
        while((myindex = content.indexOf("*module=",myindex)) != -1){
            int modend = content.indexOf(" ",myindex+8);
            String modname = content.substring(myindex+8,modend);
            names_list.add(modname);
            String version = "0.0";
            int start = content.indexOf("*version",myindex);
            int end = content.indexOf("*",start+9);
            version = content.substring(start+9,end);
            versions_list.add(version);
            myindex = end;

        }

        listOfListOfStrings.add(names_list);
        listOfListOfStrings.add(versions_list);
        return listOfListOfStrings;
    }
    public static String getDownloadUrl(String module){
        try {
            URL url = new URL("https://juliar.org/repo/?getdownloadurl="+module);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.addRequestProperty("User-Agent", "Mozilla/4.76");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            bufferedReader.close();
            return stringBuilder.toString();

        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    public static void main(String[] args){
        List<List<String>> mods = generateModuleList();

        List<String> names_list = mods.get(0);
        List<String> versions_list =  mods.get(1);
        for(int i=0;i<names_list.size();i++) {
            double newversion = getUrlVersion("https://juliar.org/repo/?getpackage="+names_list.get(i));
            if (Double.parseDouble(versions_list.get(i)) < newversion) {
                System.out.println("A new version of " + names_list.get(i) + " is available," + versions_list.get(i) + " => " + newversion + " would you like to download? (yes/No)");
                Scanner scan = new Scanner(System.in);
                String useranswer = scan.nextLine();
                if (useranswer.toLowerCase() == "yes" || useranswer.toLowerCase() == "y") {
                    boolean success = saveUrlContent(getDownloadUrl(names_list.get(i)), names_list.get(i)+".jrl");
                    if(success){
                        versions_list.set(i,Double.toString(newversion));
                    }
                }else{
                    System.out.println(names_list.get(i)+" has not been downloaded!");
                }
            } else {
                System.out.println("No update available for " + names_list.get(i) + ". You are using version: " + versions_list.get(i));
            }
        }
        try {
            String routePath = JPM.class.getResource(File.separator).getPath();
            File file = new File(routePath+File.separator+".."+File.separator+"version.jpm");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("/*Generated by the jpm */"+System.lineSeparator());
            for(int i=0;i<names_list.size();i++){
                fileWriter.write("*module="+names_list.get(i)+" *version "+versions_list.get(i)+"* *"+System.lineSeparator());
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}