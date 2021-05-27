package Kap6.Kap6_3_STMJParser;

public class ASTVariableDecl extends SimpleNode {
    protected String name;

    public ASTType getASTType() { return (ASTType) jjtGetChild(0); }

    // getter and setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ASTVariableDecl(int i) {
        super(i);
    }
    public ASTVariableDecl(STMJ p, int i) {
        super(p, i);
    }
}
