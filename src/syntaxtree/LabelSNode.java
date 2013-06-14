package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.Label;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class LabelSNode extends AbsStatementNode {

    public LabelSNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        Value val = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        UserInterface.dw.toDraw.add(new Label(val.getValue().toString(), UserInterface.dw.getCurrentColor(),
                					DrawingZone.turtle.getPosX(), DrawingZone.turtle.getPosY()));
        UserInterface.dw.revalidate();

        return context;
    }

}
