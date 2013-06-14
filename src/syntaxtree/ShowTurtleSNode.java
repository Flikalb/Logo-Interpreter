package syntaxtree;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class ShowTurtleSNode extends AbsStatementNode {

    public ShowTurtleSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        DrawingZone.turtle.setShow(true);
        UserInterface.dw.revalidate();
        return context;
    }

}
