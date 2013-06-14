package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class LputVNode extends AbsValueNode {

    public LputVNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);

        if (val2.getType() == VariableType.STRING) {
            if (val1.getType() == VariableType.STRING) {
                String v1Val = (String) val1.getValue();

                if (v1Val.length() == 1) {
                    String v2Val = (String) val2.getValue();
                    return new Value(v2Val + v1Val);
                } else
                    throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
            } else
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        } else if (val2.getType() == VariableType.ARRAYLIST) {
            ArrayList<Value> list = (ArrayList<Value>) val2.getValue();

            if (val1.getType() == VariableType.NUMBER || val1.getType() == VariableType.STRING) {
                list.add(val1);
                return new Value(list);
            } else
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        }

        throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    }

}
