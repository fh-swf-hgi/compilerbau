/* Generated By:JJTree: Do not edit this line. ASTNew.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package Kap6.Kap6_3_STMJParser;

public
class ASTNew extends ASTMethodCall {
  @Override
  public String getName() {
    return getASTType().toString();
  }
  @Override
  public int getNumberArguments() {
    return jjtGetNumChildren()-1;
  }
  @Override
  public ASTExpression getArgument(int i) { return (ASTExpression) jjtGetChild(i+1); }

  public ASTType getASTType() {
    return (ASTType) jjtGetChild(0);
  }

  public ASTNew(int id) {
    super(id);
  }
  public ASTNew(STMJ p, int id) {
    super(p, id);
  }
}
/* JavaCC - OriginalChecksum=2d65d440eb2258689b35d4ffc68d3846 (do not edit this line) */
