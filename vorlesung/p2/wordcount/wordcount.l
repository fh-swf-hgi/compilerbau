	/*** Definitionen ***/

%{
int chars = 0;
int words = 0;
int lines = 0;
%}

%option noyywrap

%%

	/*** Regeln ***/

[a-zA-Z]+ { words++; chars += strlen(yytext); }
\n { chars++; lines++; }
. { chars++; }

%%

	/*** Code ***/

#include <stdio.h>
int main(int argc, char **argv)
{
	yylex();
	printf("lines : %8d\nwords : %8d\nchars : %8d\n",
		 lines, words, chars);
	return 0;
}
