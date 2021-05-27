#include "EaAAST.h"
#include <stdio.h>
#include <stdlib.h>

extern struct Node* parse();

void printNode(struct Node* n) {
  switch (n->kind) {
    case AddNode: printf("Add"); break;
    case SubNode: printf("Sub"); break;
    case MulNode: printf("Mul"); break;
    case DivNode: printf("Div"); break;
    case ModNode: printf("Mod"); break;
    case ExpoNode: printf("Expo"); break;
    case IdentNode: printf("Ident"); break;
    case IntNode: printf("Int"); break;
    case DoubleNode: printf("Double"); break;
    case TypeNode: printf("Type"); break;
    case PosNode: printf("Pos"); break;
    case NegNode: printf("Neg"); break;
  }
}

void printTree(struct Node* n, int inl) {
  printf("\n");
  for (int i=0; i<inl; i++) printf(" ");
  printNode(n);
  if (n->kidLeft!=0) printTree(n->kidLeft, inl+2);
  if (n->kidRight!=0) printTree(n->kidRight, inl+2);
}


int main(int argc, char** argv) {
   struct Node* root = parse();
   if (root) printTree(root, 2);
   printf("\n");
}