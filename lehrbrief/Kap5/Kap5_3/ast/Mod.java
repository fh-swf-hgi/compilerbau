package Kap5.Kap5_3.ast;

public class Mod extends BinaryOperator {
    public Mod() {}
    public Mod(Node left, Node right) {
        super(left,right);
    }
    public String toString() {
        return "     ModNode:\n" + super.toString();
    }
}
