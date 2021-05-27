package Kap6.Kap6_3_STMJParser;

public class ErrorLex extends ErrorCompiler {

    public ErrorLex(SimpleNode node, String hint) {
        super(node,hint);
    }
    public ErrorLex(SimpleNode node, String hint, boolean isWarning) {
        super(node,hint,isWarning);
    }
    public String toString() {
        return "(lex) "+ super.toString();
    }
}