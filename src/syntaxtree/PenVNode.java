package syntaxtree;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import type.Value;
import type.VariableType;

public class PenVNode extends AbsValueNode {

    public PenVNode(int line) {
        super(line);
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) throws InterpretationException {
        if(executionContext.ui.dw.turtle.getPen())
            return new Value("down");
        else
            return new Value("up");
    }
}
