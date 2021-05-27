package Kap5.Kap5_3.ast;

public class TypeCast extends UnaryOperator {
    public TypeCast() {}
    public TypeCast(Node child) {
        super(child);
    }
    public String toString() {
        return "     TypeCastNode:\n" + super.toString();
    }
}
