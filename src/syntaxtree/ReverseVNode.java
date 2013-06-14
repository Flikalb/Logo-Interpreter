package syntaxtree;

import java.util.ArrayList;
import java.util.Collections;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class ReverseVNode extends AbsValueNode {

    public ReverseVNode(AbsValueNode n, int line) {
        super(line);
        setChildren(n);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        Value val = ((AbsValueNode) this.getChildAt(0)).evaluate(context);

        if (val.getType() == VariableType.ARRAYLIST) {
            ArrayList<Value> list = (ArrayList<Value>) val.getValue();
            Collections.reverse(list);
            return new Value(list);
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

    }

}
