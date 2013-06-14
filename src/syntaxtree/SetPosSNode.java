package syntaxtree;

import java.awt.geom.Line2D;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class SetPosSNode extends AbsStatementNode {

    public SetPosSNode(AbsValueNode e1, AbsValueNode e2, int line) {
        super(line);
        setChildren(e1, e2);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value value1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value value2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);
        if (value1.getType() == VariableType.NUMBER && value2.getType() == VariableType.NUMBER) {
            Number num1 = (Number) value1.getValue();
            Number num2 = (Number) value2.getValue();
            DrawingZone.turtle.setPos(num1.intValue(), num2.intValue());
            UserInterface.dw.revalidate();
        }
        return context;
    }

}
