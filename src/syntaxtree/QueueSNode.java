package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class QueueSNode extends AbsStatementNode {

    public QueueSNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value val1 = ((AbsValueNode) getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) getChildAt(1)).evaluate(context);

        if (getChildAt(0) instanceof ThingVNode && val1.getType() == VariableType.ARRAYLIST) {
            if (val2.getType() == VariableType.ARRAYLIST || val2.getType() == VariableType.NUMBER
                    || val2.getType() == VariableType.STRING) {
                ArrayList<Value> list = (ArrayList<Value>) val1.getValue();
                list.add(val2);
                return context;
            } else {
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
            }
        } else {
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        }

    }

}
