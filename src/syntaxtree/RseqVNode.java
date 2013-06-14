package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

//Rseq pour Rational Sequence plutot que Rs Equal :)
public class RseqVNode extends AbsValueNode {

    public RseqVNode(AbsValueNode n1, AbsValueNode n2, AbsValueNode n3, int line) {
        super(line);
        if (n1 != null && n2 != null && n3 != null)
            setChildren(n1, n2, n3);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        Value val1 = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        Value val2 = ((AbsValueNode) this.getChildAt(1)).evaluate(context);
        Value val3 = ((AbsValueNode) this.getChildAt(2)).evaluate(context);

        if (val1.getType() == VariableType.NUMBER && val2.getType() == VariableType.NUMBER
                && val3.getType() == VariableType.NUMBER) {
            Number opA = val1.getValue(Number.class);
            Number opB = val2.getValue(Number.class);
            Number opC = val3.getValue(Number.class);

            ArrayList<Value> list = new ArrayList<Value>();

            if (opA.intValue() < opB.intValue()) {

                for (double i = opA.doubleValue(); i <= opB.doubleValue(); i += opC.doubleValue()) {
                    list.add(new Value(i));
                }

            } else {
                for (double i = opA.doubleValue(); i <= opB.doubleValue(); i -= opC.doubleValue()) {
                    list.add(new Value(i));
                }
            }

            return new Value(list);
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

    }

}
