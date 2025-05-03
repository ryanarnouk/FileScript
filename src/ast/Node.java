/*
 * This file was adapted from the tinyVars repository provided in class.
 * Modifications have been made to implement the FileScript DSL.
 */

package ast;

public abstract class Node {
    abstract public <C, T> T accept(C context, FileScriptVisitor<C, T> v);
}
