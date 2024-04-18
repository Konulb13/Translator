import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{
        Map<String,String> translate = new HashMap<>();
while (!(saveInFile(translate).isEmpty())){
       createWords(translate);}
        }
    public static void createWords(Map<String, String> dictionary){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter eng word");
        String englWord = scanner.nextLine();
        System.out.println("enter translate to ukr");
        String ukrWord = scanner.nextLine();

        dictionary.put(englWord,ukrWord);
        System.out.println(dictionary);

    }
    public static String saveInFile(Map<String, String> m){
        String fileName = "Dictionary.txt";
        File file = new File(fileName);
        try(PrintWriter pw = new PrintWriter(file)) {
            file.createNewFile();

            for(Map.Entry<String ,String> words: m.entrySet()){
                pw.println(words.getKey() + " -> " + words.getValue());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;
    }
    public static Map<String ,String> takeFromFile(File file){
        Map<String ,String> dictionary = new HashMap<>();
        try(Scanner sc = new Scanner(file)) {
            while(sc.hasNext()){
                String strOfDict = sc.nextLine();
                String [] strings = strOfDict.split(" -> ");
                dictionary.put(strings[0], strings[1]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return dictionary;
    }
}


