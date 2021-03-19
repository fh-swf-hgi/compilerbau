%{
	#include<stdio.h>
	#include "token.h"
%}
IORL		 [0-9]|[a-zA-Z]
DIGIT 		 [0-9]
LETTER 		 [a-zA-Z]
DOUBLE 		 ({DIGIT}+"."{DIGIT}*)|{DIGIT}*"."{DIGIT}+
OPT 		 (e|E)("+"|"-")?{DIGIT}+
%%
{LETTER}{IORL}*    	return Bezeichner;
{DIGIT}+		return IntegerLiteral;
{DOUBLE}{OPT}?		return DoubleLiteral;
"("			return KlammerAuf;
")"			return KlammerZu;
"*"			return Multiplikation;
"%"			return ModuloOperator;
\/			return Division;
"+"			return PlusSymbol;
"-"			return MinusSymbol;
"^"			return Exponentiation;
"!"			return TypeModifier;
<<EOF>>			return MEOF;
"\n"			return MEOF;
%%

int yywrap() {
	return 1;
}

int main() {
   printf("Starting\n");
   int erg;
   do {
	erg=yylex();
   	printf("%d %s\n",erg,yytext);
   } while(erg!=MEOF);
}
