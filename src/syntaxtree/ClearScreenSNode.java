package syntaxtree;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class ClearScreenSNode extends AbsStatementNode {

    public ClearScreenSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        UserInterface.dw.toDraw.clear();
        DrawingZone.turtle.setPos(0, 0);
        DrawingZone.turtle.setHeading(0);
        UserInterface.dw.revalidate();

        return context;
    }

}
