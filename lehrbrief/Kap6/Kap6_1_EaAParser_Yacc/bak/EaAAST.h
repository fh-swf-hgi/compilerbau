typedef enum { AddNode, SubNode,  MulNode, DivNode, ModNode, ExpoNode, IdentNode, IntNode, DoubleNode, TypeNode, PosNode, NegNode } NodeType;

struct Node {
       NodeType kind;
       int isDouble;
       struct Node *kidLeft, *kidRight;
       union { 
           int intValue;
           double doubleValue;
           char *ident; 
       } content ;
}; 


