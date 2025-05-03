/*
 * This file was adapted from the tinyVars repository provided in class.
 * Modifications have been made to implement the FileScript DSL.
 */

package ast;

public class Number extends ExpressionNode {
    private final int val;

    public Number(int val) {
        this.val = val;
    }

    public int getVal() {
        return this.val;
    }

    @Override
    public <C, T> T accept(C context, FileScriptVisitor<C, T> v) {
        return v.visit(context, this);
    }
}
