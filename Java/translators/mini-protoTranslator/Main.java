import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Map<String, String> diccionario = new TreeMap<>();
		
		
		diccionario.put("casa", "house");
        diccionario.put("perro", "dog");
        diccionario.put("gato", "cat");
        diccionario.put("libro", "book");
        diccionario.put("hola", "hello");
        diccionario.put("bien","good");
        diccionario.put("bad","bad");
        
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
