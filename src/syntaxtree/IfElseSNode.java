package syntaxtree;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class IfElseSNode extends AbsStatementNode {

    public IfElseSNode(AbsValueNode n, AbsStatementNode thenInstructions, AbsStatementNode elseInstructions, int line) {
        super(line);
        setChildren(n, thenInstructions, elseInstructions);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value val = ((AbsValueNode) getChildAt(0)).evaluate(context);

        if (val.getType() == VariableType.BOOLEAN) {
            if ((Boolean) val.getValue()) {
                ((AbsStatementNode) this.getChildAt(1)).run(context);
                return context;
            } else {
                ((AbsStatementNode) this.getChildAt(2)).run(context);
                return context;
            }
        } else
            throw new InterpretationException(InterpretationErrorType.BOOLEAN_EXPECTED, line, null);
    }

}
