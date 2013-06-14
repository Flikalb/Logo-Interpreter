package syntaxtree;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import type.Value;
import type.VariableType;
import ui.DrawingZone;
import ui.UserInterface;

public class WaitSNode extends AbsStatementNode {

    public WaitSNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    public ExecutionContext run(ExecutionContext executionContext) throws InterpretationException {

        Value valA = ((AbsValueNode) this.getChildAt(0)).evaluate(executionContext);

        if (valA.getType() == VariableType.NUMBER)
            try {
                Thread.sleep(Math.round(((Number)valA.getValue()).doubleValue()*(1000/60)));
                UserInterface.dw.validate();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        return executionContext;
    }
}
