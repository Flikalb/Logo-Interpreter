package syntaxtree;

import java.awt.Color;
import java.awt.geom.Line2D;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.Shape;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class ForwardSNode extends AbsStatementNode {

    public ForwardSNode(AbsValueNode e, int line) {
        super(line);
        setChildren(e);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        int x = DrawingZone.turtle.getPosX();
        int y = DrawingZone.turtle.getPosY();
        Value value = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (value.getType() == VariableType.NUMBER) {
            Number num = (Number) value.getValue();
            int _X = (int) (num.intValue() * Math.cos((double) Math.toRadians(DrawingZone.turtle.getHeading())));
            int _Y = -(int) (num.intValue() * Math.sin((double) Math.toRadians(DrawingZone.turtle.getHeading())));
            DrawingZone.turtle.setPos(x + _X, y + _Y);
            Color color;
            if(DrawingZone.turtle.getErase())
                color = UserInterface.dw.getBackground();
            else
                color = UserInterface.dw.getCurrentColor();
            if (DrawingZone.turtle.getPen())
                UserInterface.dw.toDraw.add(new Shape(new Line2D.Float(x, y, x + _X, y + _Y), color));
            UserInterface.dw.revalidate();
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        return context;
    }

}
