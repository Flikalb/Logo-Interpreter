package syntaxtree;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class NotVNode extends AbsValueNode {

    public NotVNode(AbsValueNode n1, int line) {
        super(line);
        if (n1 != null)
            setChildren(n1);
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) throws InterpretationException {

        Value valA = ((AbsValueNode) this.getChildAt(0)).evaluate(executionContext);

        if (valA.getType() == VariableType.BOOLEAN) {
            return new Value(!((Boolean) valA.getValue()));
        } else {
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        }
    }

}
