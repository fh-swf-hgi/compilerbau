%option noyywrap
%option yylineno
%%

\/\/.*$	{ printf("Zeilenkommentar bei Zeile %d:\n%s\n", yylineno, yytext); }
(.|\n)

%%
void main() {
	yylex();
}