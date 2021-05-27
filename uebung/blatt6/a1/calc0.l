%{
#include "y.tab.h"
%}

%%

[0-9]*\.[0-9]+ { yylval = atof(yytext); return FLT; }
[ \t] ; /* Ignoriere Leerzeichen und Tabs */
\n return 0; /* NULL beendet das Parsen */
. return yytext[0];


%%
