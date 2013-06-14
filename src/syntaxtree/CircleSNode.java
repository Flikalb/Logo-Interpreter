package syntaxtree;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.Shape;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class CircleSNode extends AbsStatementNode {

    public CircleSNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        Value val = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (val.getType() == VariableType.NUMBER) {
            int x = DrawingZone.turtle.getPosX();
            int y = DrawingZone.turtle.getPosY();
            double num = ((Number) val.getValue()).doubleValue();
            Color color;
            if(DrawingZone.turtle.getErase())
                color = UserInterface.dw.getBackground();
            else
                color = UserInterface.dw.getCurrentColor();
            UserInterface.dw.toDraw.add(new Shape(new Ellipse2D.Double(x - num, y - num, 2 * num, 2 * num), color));
            UserInterface.dw.revalidate();
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

        return context;
    }

}
