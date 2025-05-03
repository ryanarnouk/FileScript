/*
 * This file was adapted from the tinyVars repository provided in class.
 * Modifications have been made to implement the FileScript DSL.
 */

package ast;

public class Index extends ExpressionNode {
    private final ExpressionNode idx;

    public Index(ExpressionNode idx) {
        this.idx = idx;
    }

    public ExpressionNode getIdx() {
        return this.idx;
    }

    @Override
    public <C, T> T accept(C context, FileScriptVisitor<C, T> v) {
        return v.visit(context, this);
    }
}
