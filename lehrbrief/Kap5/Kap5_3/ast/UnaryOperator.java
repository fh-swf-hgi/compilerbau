package Kap5.Kap5_3.ast;

public class UnaryOperator extends Node {
    Node child;
    public  UnaryOperator() { }
    public UnaryOperator(Node child) {
        this.child = child;
    }
    public String toString() {
        return "     "+child.toString() + "\n";
    }
}
