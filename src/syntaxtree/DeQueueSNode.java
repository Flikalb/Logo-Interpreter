package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class DeQueueSNode extends AbsStatementNode {

    public DeQueueSNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value val1 = ((AbsValueNode) getChildAt(0)).evaluate(context);

        if (getChildAt(0) instanceof ThingVNode && val1.getType() == VariableType.ARRAYLIST) {
            if (((ArrayList<Value>) val1.getValue()).isEmpty()) {
                throw new InterpretationException(InterpretationErrorType.EMPTY_LIST, line, null);
            } else {
                ArrayList<Value> list = ((ArrayList<Value>) val1.getValue());
                list.remove(list.size() - 1);
                return context;
            }
        } else {
            throw new InterpretationException(InterpretationErrorType.UNDEFINED_VARIABLE, line, null);
        }
    }

}
