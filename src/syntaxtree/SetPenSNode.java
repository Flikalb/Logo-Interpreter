package syntaxtree;

import type.Value;
import type.VariableType;
import ui.DrawingZone;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class SetPenSNode extends AbsStatementNode {

    public SetPenSNode(AbsValueNode e, int line) {
        super(line);
        setChildren(e);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value value = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (value.getType() == VariableType.STRING) {
            String str = (String) value.getValue();
            if(str.equalsIgnoreCase("down"))
                context.ui.dw.turtle.setPen(true);
            else if(str.equalsIgnoreCase("up"))
                context.ui.dw.turtle.setPen(false);
            else
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        return context;
    }

}
