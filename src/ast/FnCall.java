/*
 * This file was adapted from the tinyVars repository provided in class.
 * Modifications have been made to implement the FileScript DSL.
 */

package ast;

import exceptions.FileScriptException;
import helpers.ErrorHandler;

import java.util.List;

public class FnCall extends StatementNode {
    private final IdentifierName fnName;
    private final List<ExpressionNode> args;

    public FnCall(IdentifierName fnName, List<ExpressionNode> args) {
        this.fnName = fnName;
        this.args = args;
    }

    public IdentifierName getFnName() {
        return this.fnName;
    }

    public List<ExpressionNode> getArgs() {
        return this.args;
    }

    @Override
    public <C, T> T accept(C context, FileScriptVisitor<C, T> v) {
        try {
            return v.visit(context, this);
        } catch (FileScriptException e) {
            ErrorHandler.handle(e);
        }
        return null;
    }
}
