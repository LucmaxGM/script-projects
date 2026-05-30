#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char dataFile[50]="notes.dat";
char auxFile[50]="auxiliar.dat";
char buffer[100]="";
char input[10];
typedef struct{
char text[200];
} Note;
void saveNote(){
Note note;
FILE *f = fopen(dataFile, "ab");
if (f==NULL) {
printf("Error al abrir el archivo\n");
return;}
printf("Por favor escriba su nota:\n");
fgets(note.text,sizeof(note.text),stdin);
note.text[strcspn(note.text, "\n")] = '\0';
fwrite(&note, sizeof(Note),1,f);
fclose(f);
}
void readNotes(){
FILE *f=fopen(dataFile, "rb");
if (f==NULL){
printf("No hay notas para leer\n");
return;
}
short i=0;
Note note;
printf("Notas:\n");
printf("--------------------\n");
while (fread(&note,sizeof(Note),1,f)==1){
printf("%hd - %s\n",i, note.text);
i++;
}
printf("-----Fin------------\n");
fclose(f);
}
void changeFile() {
printf("Escriba el nombre y la extension del nuevo archivo:\n");
fgets(dataFile, sizeof(dataFile), stdin);
dataFile[strcspn(dataFile,"\n")]='\0';
printf("Se ha cambiado a archivo %s correctamente.\n", dataFile);
}
void deleteNote() {
int removeIndex, current=0;
char buffer[10];
printf("Seleccione la nota que desea borrar segun su indice\n");
printf("Si desea cancelar la operacion escriba -1\n");
fgets(buffer,sizeof(buffer),stdin);
removeIndex=atoi(buffer);
if(removeIndex==-1){
printf("Operacion cancelada");
return;
}
FILE *f = fopen(dataFile, "rb");
if(f==NULL) {
printf("Archivo %s no pudo ser abierto\n", dataFile);
return;
}
FILE *newF = fopen(auxFile, "wb");
if(newF==NULL) {
printf("Error abriendo archivo auxiliar %s.\n",auxFile);
fclose(f);
return;
}
Note note;
while(fread(&note,sizeof(Note),1,f)==1){
if(current!=removeIndex){
fwrite(&note,sizeof(Note),1,newF);
}
current++;
}
fclose(f);
fclose(newF);

remove(dataFile);
rename(auxFile, dataFile);
printf("Nota eliminada correctamente\n");
}
void deleteAllNotes() {
char decision[10]="";
printf("Escriba si para confirmar la eliminacion de TODAS las notas\n");
fgets(decision,sizeof(decision),stdin);
decision[strcspn(decision,"\n")]='\0';
if(strcmp(decision, "si")!=0 && strcmp(decision,"Si")!=0 && strcmp(decision,"SI")!=0){
printf("Operacion de borrado cancelada\n");
return;
}
FILE *f = fopen(dataFile, "wb");
if(f==NULL){
printf("Error abriendo el archivo %s.\n",dataFile);
return;
}
fclose(f);
printf("Todas las notas borradas con exito.\n");
}
short decision = 0;
void options() {
printf("-------------------------------\n");
printf("Seleccione lo que desea hacer.\n");
printf("0 - Salir del programa\n");
printf("1 - Guardar una nota\n");
printf("2 - Leer notas\n");
printf("3 - Borrar una nota\n");
printf("4 - Borrar todo\n");
printf("5 - Cambiar archivo\n");
printf("-------------------------------\n");
fgets(input, sizeof(input), stdin);
sscanf(input, "%hd", &decision);
switch(decision){
case 0:
  printf("Closing program...\n");
   exit(0);
case 1: saveNote();
break;
case 2:
  readNotes();
  break;
case 3:
  deleteNote();
  break;
case 4:
  deleteAllNotes();
  break;
case 5:
  changeFile();
  break;
default:
  printf("Input invalido. Por favor intente de nuevo\n"); 
  break;
}

}


int main() {
int i=0;
printf("\n\n\nInicializando programa de notas...\n");
while(1){
printf("\nEjecucion n° %d.\n",i);
options();
i++;
}


}
