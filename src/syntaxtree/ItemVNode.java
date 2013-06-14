package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class ItemVNode extends AbsValueNode {

    public ItemVNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);

        if (val1.getType() == VariableType.NUMBER) {
            Number v1 = (Number) val1.getValue();

            if (val2.getType() == VariableType.ARRAYLIST) {

                ArrayList<Value> list = (ArrayList<Value>) val2.getValue();
                if (v1.intValue() < list.size()) {
                    return list.get(v1.intValue());
                } else
                    throw new InterpretationException(InterpretationErrorType.OUT_OF_BOUND, line, null);

            }
            if (val2.getType() == VariableType.STRING) {

                String string = val2.toString();
                if (v1.intValue() < string.length()) {
                    return new Value(Character.toString(string.charAt(v1.intValue())));
                } else
                    throw new InterpretationException(InterpretationErrorType.OUT_OF_BOUND, line, null);

            } else
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    }
}
