/* Generated By:JJTree: Do not edit this line. ASTComp.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package Kap6.Kap6_3_STMJParser;

public
class ASTComp extends ASTExpression {
  protected String operator;

  public int size() { return jjtGetNumChildren(); }
  public ASTExpression getOperand(int i) { return (ASTExpression) jjtGetChild(i); }
  public String getOperator() { return operator; }
  public void setOperator(String op) { operator = op; }

  public ASTComp(int id) {
    super(id);
  }

  public ASTComp(STMJ p, int id) {
    super(p, id);
  }

}
/* JavaCC - OriginalChecksum=0b48fb1f4e905c59c2bdf23d3039b18c (do not edit this line) */