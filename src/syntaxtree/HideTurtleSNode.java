package syntaxtree;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class HideTurtleSNode extends AbsStatementNode {

    public HideTurtleSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        DrawingZone.turtle.setShow(false);
        UserInterface.dw.revalidate();
        return context;
    }

}
