%{
	#include <stdlib.h>
	#include <stdio.h>
     	#include "EaAAST.h"
	extern struct Node* RootOfAst;
	void yyerror(char *s);

	struct Node* newIntNode(int i);
	struct Node* newDoubleNode(double i); 
	struct Node* newIdentNode(char *i);
	struct Node* newUnOpNode(NodeType kind, struct Node* left);
	struct Node* newBinOpNode(NodeType kind, struct Node* left, struct Node* right);
%}

%error-verbose

%union {
     int intValue;
     double doubleValue;
     char *ident;
     struct Node *astNode;
}

%left PlusSymbol MinusSymbol
%left Multiplikation Division ModuloOperator
%right Exponentiation
%token <intValue> IntegerLiteral
%token <doubleValue> DoubleLiteral
%token <ident> Bezeichner
%token TypKonverter KlammerAuf KlammerZu ERROR
%type <astNode> Expr Sign Atom

%%

CompilationUnit: Expr { RootOfAst = $1; }
Expr: Expr PlusSymbol Expr  { $$ = newBinOpNode(AddNode, $1, $3); } | Expr MinusSymbol Expr { $$ = newBinOpNode(SubNode, $1, $3); } | Expr Multiplikation Expr { $$ = newBinOpNode(MulNode, $1, $3); } | Expr Division Expr { $$ = newBinOpNode(DivNode, $1, $3); } | Expr ModuloOperator Expr { $$ = newBinOpNode(ModNode, $1, $3); } | Expr Exponentiation Expr { $$ = newBinOpNode(ExpoNode, $1, $3); } | Sign { $$ = $1; } ;  
Sign : TypKonverter Atom { $$ = newUnOpNode(TypeNode, $2); } | PlusSymbol Sign  { $$ = newUnOpNode(PosNode, $2); } | MinusSymbol Sign { $$ = newUnOpNode(NegNode, $2); } | Atom { $$ = $1; } ; 
Atom : IntegerLiteral { $$ = newIntNode($1); } | DoubleLiteral { $$ = newDoubleNode($1); } | Bezeichner { $$ = newIdentNode($1); } | KlammerAuf Expr KlammerZu { $$ = $2; };

%%

struct Node* RootOfAst;
struct Node* newIntNode(int i) {
       	struct Node *erg = (struct Node*) malloc(sizeof(struct Node)); 	erg->content.intValue = i; 	erg->kind = IntNode; 	erg->kidLeft = erg->kidRight = 0; 	return erg;
}
struct Node* newDoubleNode(double i) {
       	struct Node *erg = (struct Node*) malloc(sizeof(struct Node)); 	erg->content.doubleValue = i; 	erg->kind = DoubleNode; 	erg->kidLeft = erg->kidRight = 0; 	return erg;
}
struct Node* newIdentNode(char *i) {
       	struct Node *erg = (struct Node*) malloc(sizeof(struct Node)); 	erg->content.ident = i; 	erg->kind = IdentNode; 	erg->kidLeft = erg->kidRight = 0; 	return erg;
}
struct Node* newBinOpNode(NodeType kind, struct Node* left, struct Node* right) {
       	struct Node *erg = (struct Node*) malloc(sizeof(struct Node)); 	erg->kind = kind; 	erg->kidLeft = left;         erg->kidRight = right; 	return erg;
}
struct Node* newUnOpNode(NodeType kind, struct Node* left) {
   	return newBinOpNode(kind, left, 0);
}
void yyerror(char *s) {
    fprintf(stdout, "%s\n", s);
}
struct Node* parse() {
    if (yyparse()) return 0;     else return RootOfAst;
}
 


