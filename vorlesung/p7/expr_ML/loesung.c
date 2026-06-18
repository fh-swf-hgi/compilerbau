DataType _walk_tree(struct Node* node)
{
	DataType tl=UnknownType, tr=UnknownType;
	switch (node->kind) {
    case IntNode:
		node->type = IntType;
		return IntType;
    case DoubleNode:
		node->type = DoubleType;
		return DoubleType;
    case IdentNode:
		node->type = node->content.ident->type;
		return node->type;
	// AUFGABE 1
    case AsgmtNode:
		if (node->right) tr = _walk_tree(node->right);
		node->type = tr;
		if (node->left && node->left->kind == IdentNode){
			// AUFGABE 2
			if(node->left->content.ident->type > UnknownType &&
				node->left->content.ident->type  != tr){
				printf("ERROR: Falscher Typ für Variable %s!\n", 
					node->left->content.ident->name);
				exit(1);
			}
			node->left->type = tr;
			node->left->content.ident->type	= tr;
		}
		return tr;
	//End AUFGABE 1
    default: 
		if (node->left)  tl = _walk_tree(node->left);
	    if (node->right) tr = _walk_tree(node->right); 
		node->type = (tl>tr) ? tl : tr;
		return node->type;
  }
}