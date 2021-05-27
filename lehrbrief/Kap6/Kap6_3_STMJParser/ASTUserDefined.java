package Kap6.Kap6_3_STMJParser;

public class ASTUserDefined extends SimpleNode {
    String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public ASTUserDefined(int id) {
        super(id);
    }
    public ASTUserDefined(STMJ p, int id) {
        super(p, id);
    }
}
