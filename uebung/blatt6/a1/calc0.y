%{
#include <stdio.h>
inline void yyerror(const char *s) { printf("%s", s); }
%}

%define api.value.type {double}

%token FLT

%start stmt
%%

stmt: expr { printf(" = %f\n", $1); }
	;

expr: expr '+' term { $$ = $1 + $3; }
	| term { $$ = $1; }
	;

term: '(' expr ')' { $$ = $2; }
	| FLT { $$ = $1; }
	;

%%

int main() { yyparse(); }
