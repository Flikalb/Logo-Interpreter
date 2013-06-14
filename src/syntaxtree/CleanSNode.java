package syntaxtree;

import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class CleanSNode extends AbsStatementNode {

    public CleanSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        UserInterface.dw.toDraw.clear();
        UserInterface.dw.revalidate();
        return context;
    }

}
