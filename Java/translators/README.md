## Compile
javac -cp "./gson.jar" Main.java
## Run 
java -cp "gson.jar:." Main

# There are two versions

Both use Maps from Java to store the spanish word as the key and the english translation as the value. The script allows the user to write a full sentence and once they press enter, the script will take the full sentence and split it into words, guiding itself with each space (" "), and iterate over all the words to translate each one, one by one, leaving out the words that it couldn't translate and rebuilding a new string with StringBuilder.

One thing to keep in mind, both versions only support specific words with no commas or dots or any other sign at the end, meaning that for the script to map a word, the user must input it with spaces before the first letter and after the last in this way: 

## Input
"hola ¿ que hace ? yo estoy muy bien ."
Note the separation of the commas, dots and signs from the actual words since the script separates by spaces and won't recognize "¿que" from "que".
## Output (using the second version)
"hello ¿ if I were you ago ? In psychoanalysis estoy very properly ."

## Analysis 
As you can see, it's not perfect, in fact it can't change behavior or translations depending on the surrounding context, it will only read each word individually and if there are many translations to a single word, it will load all of them but end up saving only the latest loaded word since in both cases with the TreeMap and HashMap we can't have more translations and the ome that comes last will be the one to remain

## mini-protoTranslator (version 1)

Has a very limited amount of translation resources already loaded in the script in a TreeMap/dictionary

## proto-translator (version 2)

Has a more robust amount of translations located in a json file in the same folder.
This script will first read the json file and start to load all the elements in there in a HashMap in RAM, making the look up process stay constant with O(1).