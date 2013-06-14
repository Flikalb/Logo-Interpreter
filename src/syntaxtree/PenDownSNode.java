package syntaxtree;

import context.ExecutionContext;
import error.InterpretationException;

public class PenDownSNode extends AbsStatementNode {

    public PenDownSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        context.ui.dw.turtle.setPen(true);
        return context;
    }

}
