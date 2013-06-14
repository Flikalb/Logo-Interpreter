package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class RemoveVNode extends AbsValueNode {

    public RemoveVNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {
        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);

        if (val2.getType() == VariableType.ARRAYLIST) {

            ArrayList<Value> list = (ArrayList<Value>) val2.getValue();
            list.remove(val1);
            return new Value(list);

        }
        if (val2.getType() == VariableType.STRING) {

            return new Value(val2.getValue(String.class).replaceAll(val1.getValue(String.class), ""));

        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

    }

}
