package syntaxtree;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import type.NumberUtil;
import type.Value;
import type.VariableType;

public class SinVNode extends AbsValueNode {

    public SinVNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) throws InterpretationException {

        Value valA = ((AbsValueNode) this.getChildAt(0)).evaluate(executionContext);

        if (valA.getType() == VariableType.NUMBER)
            return new Value(NumberUtil.toNumber(Math.sin(((Number) valA.getValue()).doubleValue())));
        else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    }
}
