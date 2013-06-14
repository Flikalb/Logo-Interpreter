package syntaxtree;

import java.awt.Color;
import java.awt.geom.Line2D;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.Shape;
import ui.Turtle;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class LeftSNode extends AbsStatementNode {

    public LeftSNode(AbsValueNode e, int line) {
        super(line);
        setChildren(e);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        int x = context.ui.dw.turtle.getPosX();
        int y = context.ui.dw.turtle.getPosY();
        Value value = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (value.getType() == VariableType.NUMBER) {
            Turtle turtle = DrawingZone.turtle;
            turtle.setHeading(turtle.getHeading() + 90);
            Number num = (Number) value.getValue();
            num = num.doubleValue();
            int _X = (int) (num.intValue() * Math.cos((double) Math.toRadians(turtle.getHeading())));
            int _Y = -(int) (num.intValue() * Math.sin((double) Math.toRadians(turtle.getHeading())));
            turtle.setPos(x + _X, y + _Y);
            // context.ui.dw.setCenter(x+_X,y+_Y);
            Color color;
            if(context.ui.dw.turtle.getErase())
                color = context.ui.dw.getBackground();
            else
                color = context.ui.dw.getCurrentColor();
            if (context.ui.dw.turtle.getPen())
                context.ui.dw.toDraw.add(new Shape(new Line2D.Float(x, y, x + _X, y + _Y), context.ui.dw.getCurrentColor()));
            turtle.setHeading(turtle.getHeading() - 90);
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        return context;
    }

}
