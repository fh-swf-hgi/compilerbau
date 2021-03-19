%option noyywrap

%option yylineno

%%

Ihre Loesung hier!

%%
int main(int argc, char* argv[]) {
	if(argc < 2) {
		while(yylex()) printf("Nächste Runde\n");
		return 0;
	}
	yyin = fopen(argv[1], "r");
	if(!yyin) {
		perror(argv[1]);
		return (-1);
	}
	yylex();
	fclose(yyin);
	return(0);
}
