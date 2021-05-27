package Kap5.Kap5_3.ast;

public class BinaryOperator extends Node {
    Node left, right;
    public BinaryOperator() {}
    public BinaryOperator(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
    public String toString() {
        return "     "+left.toString() +"     " + right.toString()+"\n";
    }
}
