package syntaxtree;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class HeadingSNode extends AbsStatementNode {

    public HeadingSNode(AbsValueNode e, int line) {
        super(line);
        setChildren(e);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        Value value = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (value.getType() == VariableType.NUMBER) {
            Number num = (Number) value.getValue();
            int head = (int) (num.intValue());
            DrawingZone.turtle.setHeading(head);
            UserInterface.dw.revalidate();
        }
        return context;
    }

}
