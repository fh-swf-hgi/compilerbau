/* Generated By:JJTree: Do not edit this line. ASTLiteral.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package Kap6.Kap6_3_STMJParser;

public
class ASTLiteral extends ASTExpression {
  protected String content;
  protected ASTType.AstTypes kind;

  public void setContent(String content) { this.content = content; }
  public void setKind(ASTType.AstTypes type) { this.kind = type; }
  public ASTType.AstTypes getKind() { return kind; }


  public ASTLiteral(int id) {
    super(id);
  }

  public ASTLiteral(STMJ p, int id) {
    super(p, id);
  }

}
/* JavaCC - OriginalChecksum=ff2e363753e905c4b0bc8b82dc13ceec (do not edit this line) */
