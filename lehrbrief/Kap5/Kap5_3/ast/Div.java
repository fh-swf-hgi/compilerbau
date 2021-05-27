package Kap5.Kap5_3.ast;

public class Div extends BinaryOperator {
    public Div() {}
    public Div(Node left, Node right) {
        super(left,right);
    }
    public String toString() {
        return "     DivNode:\n" + super.toString();
    }
}
