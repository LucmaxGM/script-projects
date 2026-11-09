
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import com.google.gson.*;

public class Main {

    public static Map<String, String> loadDictionary(String fileName) {

        Map<String, String> dictionary = new HashMap<>();

        try (Reader reader = new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8)) {

            // Step 1: Read the JSON file
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();

            // Step 2: Get the array containing the dictionary entries
            JsonArray list = root.getAsJsonArray("list");

            // Step 3: Go through every entry in the array
            for (JsonElement element : list) {

                JsonObject entry = element.getAsJsonObject();

                // Step 4: Extract the Spanish word
                String word = entry.get("word").getAsString();

                // Step 5: Extract its translations
                JsonArray translations = entry.getAsJsonArray("translation");

                // Step 6: Store the first translation, if one exists
                if (translations != null && !translations.isEmpty()) {

                    String translation = translations.get(0).getAsString();

                    dictionary.put(word, translation);
                }
            }

        } catch (IOException | JsonParseException e) {
            System.out.println("Error loading " + fileName + ": " + e.getMessage());
        }

        // Step 7: Return the completed dictionary
        return dictionary;
    }

    public static void main(String[] args) {

        Map<String, String> diccionario =
                loadDictionary("dictionary1.txt");


        System.out.println("Dictionary entries: " + diccionario.size());
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine().trim();
        String[] arrayOfWords = original.split(" ");
        StringBuilder traduccion = new StringBuilder();
        if(arrayOfWords.length==0){
        	System.out.println("Ingrese un texto valido");
        	return;
        } else {
        		
        	for(int i = 0; i <arrayOfWords.length;i++){
        		if(diccionario.containsKey(arrayOfWords[i])){
        		traduccion.append(diccionario.get(arrayOfWords[i]));
        			} else {
        				traduccion.append(arrayOfWords[i]);
        				}
        				traduccion.append(" ");
        		}
    	}
    	System.out.println(traduccion);       
    }
}

