package syntaxtree;

import java.awt.Color;
import java.awt.geom.Arc2D;
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

public class EllipseSNode extends AbsStatementNode {

    public EllipseSNode(AbsValueNode e1, AbsValueNode e2, int line) {
        super(line);
        setChildren(e1, e2);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);
        if (val1.getType() == VariableType.NUMBER && val2.getType() == VariableType.NUMBER) {
            int x = DrawingZone.turtle.getPosX();
            int y = DrawingZone.turtle.getPosY();
            double distx = ((Number) val1.getValue()).doubleValue();
            double disty = ((Number) val2.getValue()).doubleValue();
            Color color;
            if(DrawingZone.turtle.getErase())
                color = UserInterface.dw.getBackground();
            else
                color = UserInterface.dw.getCurrentColor();
            UserInterface.dw.toDraw.add(new Shape(new Ellipse2D.Double(x - distx, y - disty, 2 * distx, 2 * disty),
                    color));
            UserInterface.dw.revalidate();
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

        return context;
    }

}
