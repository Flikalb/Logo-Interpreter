package syntaxtree;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class AndVNode extends AbsValueNode {

    public AndVNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) throws InterpretationException {

        Value valA = ((AbsValueNode) this.getChildAt(0)).evaluate(executionContext);
        Value valB = ((AbsValueNode) this.getChildAt(1)).evaluate(executionContext);

        if (valA.getType() == VariableType.BOOLEAN && valB.getType() == VariableType.BOOLEAN) {
            return new Value(((Boolean) valA.getValue()) && ((Boolean) valB.getValue()));
        } else {
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        }
    }

}
