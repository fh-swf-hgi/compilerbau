%{
     #include <stdlib.h>
     #include <string.h>
     #include "EaAAST.h"
     #include "y.tab.h"
     extern YYSTYPE yylval;
     void yyerror(char *);
     int yylex(void);
%}
Digit	[0-9]
Alpha	[a-zA-Z]
Expo	[eE](\+|-)?{Digit}+
%%
{Alpha}({Digit}|{Alpha})*	{ 	yylval.ident = strdup(yytext);
                                    	return Bezeichner;
 				}
!				{
					return TypKonverter; 
				}
\(				return KlammerAuf; 
\)				return KlammerZu;
{Digit}+			{ 	yylval.intValue = atoi(yytext);
					return IntegerLiteral; 
				}
{Digit}+[.]{Digit}*(Expo)?	{    yylval.doubleValue = atof(yytext);	
				     return DoubleLiteral;
				}
{Digit}*[.]{Digit}+(Expo)?	{    yylval.doubleValue = atof(yytext);	
				     return DoubleLiteral;
				}
\+				return PlusSymbol;
- 				return MinusSymbol;
\*				return Multiplikation; 
\/				return Division; 
%				return ModuloOperator;
\^				return Exponentiation;
%%
int yywrap() {
     return 1;
}
