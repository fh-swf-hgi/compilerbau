package Kap5.Kap5_3.ast;

public class Neg extends UnaryOperator {
    public Neg() {}
    public Neg(Node child) {
        super(child);
    }
    public String toString() {
        return "     NegNode:\n" + super.toString();
    }
}
