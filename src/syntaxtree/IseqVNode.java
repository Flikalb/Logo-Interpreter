package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

//Iseq pour Integer Sequence plutot que Is Equal :)
public class IseqVNode extends AbsValueNode {

    public IseqVNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);

        if (val1.getType() == VariableType.NUMBER && val2.getType() == VariableType.NUMBER) {
            Number opA = val1.getValue(Number.class);
            Number opB = val2.getValue(Number.class);

            ArrayList<Value> list = new ArrayList<Value>();

            if (opA.intValue() < opB.intValue()) {

                for (int i = opA.intValue(); i < opB.intValue() + 1; i++) {
                    list.add(new Value(i));
                }

            } else {
                for (int i = opA.intValue(); i > opB.intValue() - 1; i--) {
                    list.add(new Value(i));
                }
            }

            return new Value(list);
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

    }

}
