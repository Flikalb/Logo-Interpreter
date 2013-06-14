package syntaxtree;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class PenUpSNode extends AbsStatementNode {

    public PenUpSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        DrawingZone.turtle.setPen(false);
        UserInterface.dw.revalidate();
        return context;
    }

}
