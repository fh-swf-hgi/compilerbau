/* Generated By:JJTree: Do not edit this line. ASTCompilationUnit.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package Kap6.Kap6_3_STMJParser;

public
class ASTCompilationUnit extends SimpleNode {
  public int size() { return jjtGetNumChildren(); }
  public ASTUserDefined getUserDefined(int i) {
    return (ASTUserDefined) jjtGetChild(i);
  }

  public ASTCompilationUnit(int id) {
    super(id);
  }
  public ASTCompilationUnit(STMJ p, int id) {
    super(p, id);
  }
}
/* JavaCC - OriginalChecksum=0b04c2a9c90d8f10ea845f8a5597bfa5 (do not edit this line) */
