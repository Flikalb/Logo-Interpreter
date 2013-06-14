package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class ButFirstVNode extends AbsValueNode {

    public ButFirstVNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {
        Value val = ((AbsValueNode) this.getChildAt(0)).evaluate(context);

        if (val.getType() == VariableType.ARRAYLIST) {
            ArrayList<Value> list = (ArrayList<Value>) val.getValue();
            list.remove(0);
            return new Value(list);
        } else if (val.getType() == VariableType.STRING) {
            String string = val.toString();
            string.substring(1);
            return new Value(string);
        } else if (val.getType() == VariableType.NUMBER) {
            String string = val.toString();
            string.substring(1);
            return new Value(Double.parseDouble(string));
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    }

}
