package syntaxtree;

import java.awt.Color;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class PenEraseSNode extends AbsStatementNode {

    public PenEraseSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

    	DrawingZone.turtle.setErase(true);
        DrawingZone.turtle.setPen(true);
        UserInterface.dw.revalidate();
        return context;
    }

}
