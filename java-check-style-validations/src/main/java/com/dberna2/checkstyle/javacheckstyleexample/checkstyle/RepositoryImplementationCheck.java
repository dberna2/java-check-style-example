package com.dberna2.checkstyle.javacheckstyleexample.checkstyle;

import com.puppycrawl.tools.checkstyle.FileStatefulCheck;
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;

@FileStatefulCheck
public class RepositoryImplementationCheck extends AbstractCheck {

  @Override
  public int[] getDefaultTokens() {
    return new int[]{TokenTypes.CLASS_DEF};
  }

  @Override
  public void visitToken(final DetailAST ast) {
    DetailAST classNameAST = ast.findFirstToken(TokenTypes.IDENT);
    String className = classNameAST.getText();

    // Obtener la lista de interfaces que la clase implementa
    DetailAST implementsClause = ast.findFirstToken(TokenTypes.IMPLEMENTS_CLAUSE);

    if (implementsClause != null && className.endsWith("Impl")) {
      log(ast.getLineNo(), "Class implementing an interface should not end with 'Impl': {0}", className);
    }
  }

  @Override
  public int[] getAcceptableTokens() {
    return getDefaultTokens();
  }

  @Override
  public boolean isCommentNodesRequired() {
    return false;
  }

  @Override
  public int[] getRequiredTokens() {
    return new int[0];
  }
}
