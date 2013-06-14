package syntaxtree;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class PenPaintSNode extends AbsStatementNode {

    public PenPaintSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        DrawingZone.turtle.setErase(false);
        DrawingZone.turtle.setPen(true);
        UserInterface.dw.revalidate();
        return context;
    }

}
