package Kap6.Kap6_3_STMJParser;

public class ErrorCompiler extends Exception {
    SimpleNode node; // where was it
    String hint;
    boolean isWarning = false;

    public ErrorCompiler(SimpleNode node, String hint) {
        this.node=node;
        this.hint=hint;
    }
    public ErrorCompiler(SimpleNode node, String hint, boolean isWarning) {
        this.node=node;
        this.hint=hint;
        this.isWarning = isWarning;
    }
    public String toString() {
        if (node!=null)
            return "Error at line "+ node.firstToken.beginLine +" column "+ node.firstToken.beginColumn
                + "\n      "+hint;
        else return hint;
    }
}
