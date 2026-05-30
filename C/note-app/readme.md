#Note Script
Translation/traducción: Por el mismo programador (Lucas Blasco)
##Tecnologias/Tecnologies:
- C
- File Administration/Administración de Archivos
- Binary File/Archivo Binario
##Descripción:
Este script te permite guardar, leer y eliminar notas de un archivo binario.
Presenta un buen nivel de abstracción para un uso fácil y una forma de terminar la ejecución del programa.
##Description:
This script allows you to save, read and delete notes from a binary file. 
The script presents a high abstraction level for an easier use to all user and a way to stop the execution of the program.
##Funcionamiento:
Una vez compilado y ejecutado el programa, este te pedirá que elijas entre varias opciones según la acción que quieras ejecutar.
A partir de esa selección el script realizará la acción especifica (caso de que la acción sea leer notas o cerrar el programa) o pedirá al usuario que introduzca parametros para completar la acción (guardar o borrar notas)
El archivo binario se creará con el nombre default o el ingresado por el usuario en caso de no existir y sinó abrirá el archivo ya existe. Permitiendo una permanencia entre diferentes compilaciones.
##ADVERTENCIA:
SI EL NOMBRE DEL ARCHICO COINCIDE CON ALGÚN ARCHIVO: El script podría reescribirlo.
Por favor elija un nombre de archivo que usted no use caso sea que el default coincida con algún otro archivo.
#How it works:
Once compiled and executed, this program will asks you to choose between various options according to the action the user wishes to perform.
Accoding to the action the user chooses, the script will execute it (if the action doesnt require parameters like reading or stopping the program) or will ask for more parameters (like for saving a custom note or to delete the notes as it requires explicit comfirmation)
The binary file will be created with the default name or the name that the user inputs.
##Warning:
IF THE FILE ALREADY EXISTS: the script could rewrite your already existing file
CHOOSE AN UNUSED NAME IF THE DEFAULT NAME IS ALREADY USED
