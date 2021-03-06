package syntaxtree;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import type.NumberUtil;
import type.Value;
import type.VariableType;

public class DivVNode extends AbsValueNode {

    public DivVNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) throws InterpretationException {

        Value valA = ((AbsValueNode) this.getChildAt(0)).evaluate(executionContext);
        Value valB = ((AbsValueNode) this.getChildAt(1)).evaluate(executionContext);

        if (valA.getType() == VariableType.NUMBER && valB.getType() == VariableType.NUMBER) {
            if (((Number) valB.getValue()).doubleValue() != 0) {
                return new Value(NumberUtil.toNumber(((Number) valA.getValue()).doubleValue() / ((Number) valB.getValue()).doubleValue()));
            } else {
                throw new InterpretationException(InterpretationErrorType.DIVIDE_BY_ZERO, line, null);
            }
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    }
}
