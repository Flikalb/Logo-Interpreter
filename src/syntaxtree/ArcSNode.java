package syntaxtree;

import java.awt.Color;
import java.awt.geom.Arc2D;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.Shape;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class ArcSNode extends AbsStatementNode {

    public ArcSNode(AbsValueNode e1, AbsValueNode e2, int line) {
        super(line);
        setChildren(e1, e2);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);
        DrawingZone dw = UserInterface.dw;
        if(val1.getType() == VariableType.NUMBER && val2.getType() == VariableType.NUMBER ) {
            int x = DrawingZone.turtle.getPosX();
            int y = DrawingZone.turtle.getPosY();
            double startAngle = DrawingZone.turtle.getHeading(); 
            double r = ((Number) val1.getValue()).doubleValue();
            double angle = ((Number) val2.getValue()).doubleValue();
            Color color;
            if(DrawingZone.turtle.getErase())
                color = dw.getBackground();
            else
                color = dw.getCurrentColor();
            dw.toDraw.add(new Shape(new Arc2D.Double(x-r, y-r, 2*r, 2*r, startAngle, startAngle+angle, Arc2D.OPEN), color));
            UserInterface.dw.revalidate();
        }
        else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        
        
        return context;
    }

}
