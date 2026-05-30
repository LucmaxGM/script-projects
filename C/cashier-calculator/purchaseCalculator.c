#include <stdio.h>

#include <string.h>
float calculate(){
    float total=0;
    char order[200];
    fgets(order,sizeof(order),stdin);
    char *token = strtok(order," ");
    while(token!=NULL){
        if(strcmp(token,"Pizza")==0){
            total+=6;
            }
        else if(strcmp(token,"Nachos")==0){
            total+=6;
            }
        else if(strcmp(token,"Cheeseburger")==0){
            total+=10;
            }
        else if (strcmp(token,"Water")==0){
            total+=4;
        } else {
            total+=5;
        }
        token=strtok(NULL," ");
    }
    total=total*1.07;
    printf("Your total is: %.2f\n",total);
}

int main() {
 calculate();

	return 0;

}
