package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class PickVNode extends AbsValueNode {

    public PickVNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        int rand;
        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);

        if (val1.getType() == VariableType.ARRAYLIST) {

            ArrayList<Value> list = (ArrayList<Value>) val1.getValue();
            rand = (int) (Math.random() * list.size());
            return list.get(rand);

        }
        if (val1.getType() == VariableType.STRING) {

            String string = val1.toString();
            rand = (int) (Math.random() * string.length());
            return new Value(Character.toString(string.charAt(rand)));

        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

    }

}
