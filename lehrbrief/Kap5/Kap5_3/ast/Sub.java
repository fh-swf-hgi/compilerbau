package Kap5.Kap5_3.ast;

public class Sub extends BinaryOperator {
    public Sub() {}
    public Sub(Node left, Node right) {
        super(left,right);
    }
    public String toString() {
        return "     SubNode:\n" + super.toString();
    }
}
