/*
 * This file was adapted from the tinyVars repository provided in class.
 * Modifications have been made to implement the FileScript DSL.
 */

package ast;

public class Text extends ExpressionNode {
    private final String val;

    public Text(String val) {
        this.val = val;
    }

    public String getVal() {
        return this.val;
    }

    @Override
    public <C, T> T accept(C context, FileScriptVisitor<C, T> v) {
        return v.visitText(context, this);
    }
}
