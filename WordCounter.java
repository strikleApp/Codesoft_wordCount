  
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputText = "";

        System.out.println("Welcome to Word Counter!");

        
        System.out.print("Enter text: ");
        String userInput = scanner.nextLine();

        try {
            
            File file = new File(userInput);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                inputText += fileScanner.nextLine() + " ";
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
           
            inputText = userInput;
        }

        String[] words = inputText.split("\\s+|\\p{Punct}");

        int wordCount = 0;
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
                wordFrequency.put(word.toLowerCase(), wordFrequency.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }

        System.out.println("Total words: " + wordCount);

         System.out.println("Word frequency:");
        for (String word : wordFrequency.keySet()) {
            System.out.println(word + ": " + wordFrequency.get(word));
        }

        scanner.close();
    }
}