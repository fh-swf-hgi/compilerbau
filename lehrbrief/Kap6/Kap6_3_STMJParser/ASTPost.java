/* Generated By:JJTree: Do not edit this line. ASTPost.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package Kap6.Kap6_3_STMJParser;

public
class ASTPost extends ASTExpression {
  protected String operator;

  public ASTExpression getOperand() { return (ASTExpression) jjtGetChild(0); }
  public String getOperator() { return operator; }
  public void setOperator(String op) { operator = op; }

  public ASTPost(int id) {
    super(id);
  }
  public ASTPost(STMJ p, int id) {
    super(p, id);
  }
}
/* JavaCC - OriginalChecksum=d62549363d37f6b1c8868228a7673d60 (do not edit this line) */
