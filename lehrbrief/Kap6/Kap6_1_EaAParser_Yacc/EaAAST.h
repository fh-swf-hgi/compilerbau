typedef enum { AddNode, SubNode,  MulNode, DivNode, ModNode, ExpoNode, IdentNode, IntNode, DoubleNode, TypeNode, PosNode, NegNode } NodeType;

struct Node {
       NodeType kind;
	   int id;
       int isDouble;
       struct Node *left, *right;
       union { 
           int intValue;
           double doubleValue;
           char *ident; 
       } content ;
}; 


