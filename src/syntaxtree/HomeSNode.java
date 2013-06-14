package syntaxtree;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class HomeSNode extends AbsStatementNode {

    public HomeSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        DrawingZone.turtle.setPos(0, 0);
        UserInterface.dw.revalidate();
        return context;
    }

}
