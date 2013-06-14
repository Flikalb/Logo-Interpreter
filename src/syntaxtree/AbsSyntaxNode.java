package syntaxtree;

public class AbsSyntaxNode {
    protected final int line;
    private AbsSyntaxNode[] children = new AbsSyntaxNode[0];

    public AbsSyntaxNode(int line) {
        this.line = line;
    }

    protected void setChildren(AbsSyntaxNode... children) {
        this.children = children;
    }

    protected AbsSyntaxNode getChildAt(int index) {
        if (index >= 0 && index < this.children.length) {
            return this.children[index];
        }
        return null;
    }

    protected int getChildCount() {
        return this.children.length;
    }

}
