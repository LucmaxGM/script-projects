#include <stdio.h>
#include <math.h>
#include <stdlib.h>
int iteration=0;
char hexCode[20]="";
char hexxd(int number){
    if(number>=0 && number<=9){
        return number + '0';
    } switch (number){
        case 10: return 'a';
        case 11: return 'b';
        case 12: return 'c';
        case 13: return 'd';
        case 14: return 'e';
        case 15: return 'f';
    } return '?';
}
void callback(char *color){
    int n = atoi(color);
    int remainder=n%16;
    int amount=n/16;
    hexCode[1+(2*iteration)]=hexxd(amount);
    hexCode[2+(2*iteration)]=hexxd(remainder);
    hexCode[3+(2*iteration)]='\0';
    iteration++;
}
int toHexCode(){
    char input[30];
    char red[10];
    char blue[10];
    char green[10];
    fgets(input, sizeof(input),stdin);
    if(input[0]=='e' || input[0]=='E'){
    exit(0);
    }
    int count=sscanf(input,"%s %s %s",red,green,blue);
    if(count==1){
    printf("Input GREEN rgb value\n");
    fgets(green,sizeof(green),stdin);
    printf("input BLUE rgb value\n");
    fgets(blue,sizeof(blue),stdin);
    } else if(count!=3){
    printf("Invalid Input\n");
    return 1;
    }
    iteration=0;
    hexCode[0]='#';
    callback(red);
    callback(green);
    callback(blue);
    printf("~~~~~~~~~~~~~\n");
    printf("Your hexcode:\n");
    printf("%s\n",hexCode);
    printf("~~~~~~~~~~~~~\n");
    printf("Input 'e' now if you wish to exit!\n");
    return 1;
}
void menu(){
printf("Hexcode program. Enter your rgb code like this example:\n");
printf("'255 255 255' or '255' to start with RED and go one by one!\n");
while(1){
toHexCode();
}}
int main() {
    menu();
    return 0;
}
