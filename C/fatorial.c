/******************************************************************************

Welcome to GDB Online.
  GDB online is an online compiler and debugger tool for C, C++, Python, PHP, Ruby, 
  C#, OCaml, VB, Perl, Swift, Prolog, Javascript, Pascal, COBOL, HTML, CSS, JS
  Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
#include <stdio.h>

int main()
{
    int N, Fat;
    
    printf("Digite un número:");
    scanf("%d",&N);
    Fat = 1;
    for (int i=N;i>0;i--){
       Fat*=i; 
    }
    printf("o fatorial de %d é %d",N,Fat);
    

    return 0;
}

