package Kap5.Kap5_3.ast;

public class Exp extends BinaryOperator {
    public Exp() {}
    public Exp(Node left, Node right) {
        super(left,right);
    }
    public String toString() {
        return "     ExpNode:\n" + super.toString();

    }
}
