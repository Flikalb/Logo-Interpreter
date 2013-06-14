package syntaxtree;

import java.util.ArrayList;

import context.ExecutionContext;
import error.InterpretationException;

public class ElseSNode extends AbsStatementNode {

    public ElseSNode(ArrayList<AbsStatementNode> elseInstructions, int line) {
        super(line);
        AbsSyntaxNode[] children = new AbsSyntaxNode[elseInstructions.size()];
        for (int i = 0; i < elseInstructions.size(); i++) {
            children[i] = elseInstructions.get(i);
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
