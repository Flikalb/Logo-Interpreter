package syntaxtree;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class SetXSNode extends AbsStatementNode {

    public SetXSNode(AbsValueNode e, int line) {
        super(line);
        setChildren(e);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value value = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (value.getType() == VariableType.NUMBER) {
            Number num = (Number) value.getValue();
            DrawingZone.turtle.setPosX(num.intValue());
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        return context;
    }

}
