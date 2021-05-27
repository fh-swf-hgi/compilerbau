package Kap5.Kap5_3.ast;

public class Pos extends UnaryOperator {
    public Pos() {}
    public Pos(Node child) {
        super(child);
    }
    public String toString() {
        return "     PosNode:\n" + super.toString();
    }
}
