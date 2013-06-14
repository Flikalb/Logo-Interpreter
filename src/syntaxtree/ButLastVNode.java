package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class ButLastVNode extends AbsValueNode {

    public ButLastVNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {
        Value val = ((AbsValueNode) this.getChildAt(0)).evaluate(context);

        if (val.getType() == VariableType.ARRAYLIST) {
            ArrayList<Value> list = (ArrayList<Value>) val.getValue();
            list.remove(list.size() - 1);
            return new Value(list);
        } else if (val.getType() == VariableType.STRING) {
            String string = val.toString();
            return new Value(string.substring(0, string.length() - 1));
        } else if (val.getType() == VariableType.NUMBER) {
            String string = val.toString();
            return new Value(Double.parseDouble(string.substring(0, string.length() - 1)));
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    }

}
