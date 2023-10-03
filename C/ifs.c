/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>

int main()
{
    char S[50];
    int idade;
    
    printf("Digite seu nome: ");
    scanf("%s",&S);
    printf("Hello %s\n",S);
    printf("Digite sua idade:");
    scanf("%d", &idade);
    if ((0<=idade)&&(idade<=3)){
        printf("BABY\n");
    }
    else if (idade<=12){
        printf("  CRIANÇA\n");

    } 
    else if (idade<=18){
        printf("ADOLESCENTE\n");
    } 
    else 
        printf("ADULTO\n");
        
    for(int i=0; i<10; i++){
        printf("%d ",i);
    }    
        

    return 0;
}

