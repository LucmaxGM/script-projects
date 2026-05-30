#include <stdio.h>
#include <math.h>
#include <stdbool.h>
double logaritmo(double base, double argumento) {
double i=0;
bool finished=false;
while(i<1000){
if(fabs(pow(base,i) - argumento)<0.1) {
finished=true;
return i;}
else {i=i+0.00001;}}
return -1;

}
int main(){
double a, b;
printf("Select your base and your result/argument separated by a space: ");
scanf("%lf %lf", &b, &a);
double result =logaritmo(b, a);
printf("%f\n", result);
}
