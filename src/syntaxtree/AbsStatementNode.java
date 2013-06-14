package syntaxtree;

import context.ExecutionContext;
import error.InterpretationException;

public abstract class AbsStatementNode extends AbsSyntaxNode {

    public AbsStatementNode(int line) {
        super(line);
    }

    public abstract ExecutionContext run(ExecutionContext context) throws InterpretationException;
}
