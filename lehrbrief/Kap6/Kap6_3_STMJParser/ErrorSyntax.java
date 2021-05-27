package Kap6.Kap6_3_STMJParser;

public class ErrorSyntax extends ErrorCompiler {

    public ErrorSyntax(SimpleNode node, String hint) {
        super(node,hint);
    }
    public ErrorSyntax(SimpleNode node, String hint, boolean isWarning) {
        super(node,hint,isWarning);
    }
    public String toString() {
        return "(syntax) "+ super.toString();
    }
}