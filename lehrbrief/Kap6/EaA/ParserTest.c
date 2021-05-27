#include "EaAAST.h"
#include <stdio.h>
#include <stdlib.h>


extern struct Node* parse();

void fprintNode(struct Node* n, FILE* fp) {
  switch (n->kind) {
    case AddNode: fprintf(fp, "Add"); break;
    case SubNode: fprintf(fp, "Sub"); break;
    case MulNode: fprintf(fp, "Mul"); break;
    case DivNode: fprintf(fp, "Div"); break;
    case ModNode: fprintf(fp, "Mod"); break;
    case ExpoNode: fprintf(fp, "Expo"); break;
    case IdentNode: fprintf(fp, "Ident"); break;
    case IntNode: fprintf(fp, "Int"); break;
    case DoubleNode: fprintf(fp, "Double"); break;
    case TypeNode: fprintf(fp, "Type"); break;
    case PosNode: fprintf(fp, "Pos"); break;
    case NegNode: fprintf(fp, "Neg"); break;
  }
}

void _print_node(struct Node* node, FILE* fp){
	fprintf(fp, "    %d [label=\"", node->id);
	if(node->kind==IntNode)
		fprintf(fp, "%d", node->content.intValue);
	else if(node->kind==IdentNode)
		fprintf(fp, "%s", node->content.ident);
	else if(node->kind==DoubleNode)
		fprintf(fp, "%f", node->content.doubleValue);
	else
		fprintNode(node, fp);
	fprintf(fp, "\"]\n");
}

void _print_tree(struct Node* node, FILE* fp)
{

	_print_node(node, fp);
    if (node->left)
    {
        fprintf(fp, "    %d -> %d;\n", node->id, node->left->id);
        _print_tree(node->left, fp);
    } 

    if (node->right)
    {
        fprintf(fp, "    %d -> %d;\n", node->id, node->right->id);
        _print_tree(node->right, fp);
    }
}

void print_tree(struct Node* tree, FILE* fp)
{
    fprintf(fp, "digraph BST {\n");
    fprintf(fp, "    node [fontname=\"Arial\"];\n");

    if (!tree)
        fprintf(fp, "\n");
    else if (!tree->right && !tree->left)
        _print_node(tree, fp);
    else
        _print_tree(tree, fp);

    fprintf(fp, "}\n");
}


int main(int argc, char** argv) {
   struct Node* root = parse();

	FILE *fp;
	fp = fopen("ast.dot", "w+");
	if (root) print_tree(root, fp);
	fclose(fp);
	return 0;
}
