/* Generated By:JJTree: Do not edit this line. ASTSign.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package Kap6.Kap6_3_STMJParser;

public
class ASTSign extends ASTExpression {
  protected String operator;

  public ASTExpression getOperand() { return (ASTExpression) jjtGetChild(0); }
  public String getOperator() { return operator; }
  public void setOperator(String op) { operator = op; }

  public ASTSign(int id) {
    super(id);
  }

  public ASTSign(STMJ p, int id) {
    super(p, id);
  }

}
/* JavaCC - OriginalChecksum=88277f5e243ad0895ee90d182e015504 (do not edit this line) */