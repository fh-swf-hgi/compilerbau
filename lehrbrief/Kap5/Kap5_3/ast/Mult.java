package Kap5.Kap5_3.ast;

public class Mult extends BinaryOperator {
    public Mult() {}
    public Mult(Node left, Node right) {
        super(left,right);
    }
    public String toString() {
        return "     MultNode:\n" + super.toString();
    }
}
