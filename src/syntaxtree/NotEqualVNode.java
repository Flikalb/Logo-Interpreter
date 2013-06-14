package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class NotEqualVNode extends AbsValueNode {

    public NotEqualVNode(AbsValueNode n1, AbsValueNode n2, int line) {
        super(line);
        if (n1 != null && n2 != null)
            setChildren(n1, n2);
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) throws InterpretationException {

        Value valA = ((AbsValueNode) this.getChildAt(0)).evaluate(executionContext);
        Value valB = ((AbsValueNode) this.getChildAt(1)).evaluate(executionContext);

        if (valA.getType() == VariableType.BOOLEAN && valB.getType() == VariableType.BOOLEAN) {
            return new Value(!(valA.getValue().equals(valB.getValue())));
        } else if (valA.getType() == VariableType.NUMBER && valB.getType() == VariableType.NUMBER) {
            return new Value(!(valA.getValue().equals(valB.getValue())));
        } else if (valA.getType() == VariableType.STRING && valB.getType() == VariableType.STRING) {
            return new Value(!(valA.getValue().equals(valB.getValue())));
        } else if (valA.getType() == VariableType.ARRAYLIST && valB.getType() == VariableType.ARRAYLIST) {
            boolean test = false;

            if (((ArrayList<Value>) valA.getValue()).size() == ((ArrayList<Value>) valB.getValue()).size()) {
                for (int i = 0; i < ((ArrayList<Value>) valA.getValue()).size(); i++) {
                    if (!(((ArrayList<Value>) valA.getValue()).get(i)).equals(((ArrayList<Value>) valB.getValue())
                            .get(i))) {
                        test = true;
                        return new Value(test);
                    }
                }

                return new Value(test);
            } else {
                test = true;
                return new Value(test);
            }
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    }

}
