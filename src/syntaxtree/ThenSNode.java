package syntaxtree;

import java.util.ArrayList;

import context.ExecutionContext;
import error.InterpretationException;

public class ThenSNode extends AbsStatementNode {

    public ThenSNode(ArrayList<AbsStatementNode> thenInstructions, int line) {
        super(line);
        AbsSyntaxNode[] children = new AbsSyntaxNode[thenInstructions.size()];
        for (int i = 0; i < thenInstructions.size(); i++) {
            children[i] = thenInstructions.get(i);
        }

        setChildren(children);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        for (int i = 0; i < this.getChildCount(); i++) {
            ((AbsStatementNode) this.getChildAt(i)).run(context);
        }

        return context;
    }

}
