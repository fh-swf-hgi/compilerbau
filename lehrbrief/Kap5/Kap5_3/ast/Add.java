package Kap5.Kap5_3.ast;

public class Add extends BinaryOperator {
    public Add() {}
    public Add(Node left, Node right) {
        super(left,right);
    }
    public String toString() {
        return "     AddNode:\n" + super.toString();
    }
}
