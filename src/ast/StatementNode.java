/*
 * This file was adapted from the tinyVars repository provided in class.
 * Modifications have been made to implement the FileScript DSL.
 */

package ast;

// Use this for statements that modify state
// ex. creating an assignment
public class StatementNode extends Node {
    @Override
    public <C, T> T accept(C context, FileScriptVisitor<C, T> v) {
        return null;
    }
}
