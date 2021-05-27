package Kap6.Kap6_3_STMJParser;

public class ASTStatement extends SimpleNode {
    public ASTStatement(int i) {
        super(i);
    }
    public ASTStatement(STMJ p, int i) {
        super(p, i);
    }
}
