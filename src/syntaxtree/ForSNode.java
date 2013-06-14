package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import symbol.SymbolTableEntry;

public class ForSNode extends AbsStatementNode {

    private final String identifier;

    public ForSNode(String _id, AbsValueNode start, AbsValueNode end, AbsValueNode step,
            ArrayList<AbsStatementNode> instructions, int line) {
        super(line);
        this.identifier = _id;

        AbsSyntaxNode[] children = new AbsSyntaxNode[instructions.size() + 3];
        for (int i = 0; i < instructions.size(); i++) {
            children[i] = instructions.get(i);
        }
        children[instructions.size()] = start;
        children[instructions.size() + 1] = end;
        children[instructions.size() + 2] = step;

        setChildren(children);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value startValue = ((AbsValueNode) getChildAt(this.getChildCount() - 3)).evaluate(context);
        Value endValue = ((AbsValueNode) getChildAt(this.getChildCount() - 2)).evaluate(context);
        Value stepValue = null;

        double startNum, endNum, stepNum;

        if (((AbsValueNode) getChildAt(this.getChildCount() - 1)) != null)
            stepValue = ((AbsValueNode) getChildAt(this.getChildCount() - 1)).evaluate(context);

        if (startValue.getType() == VariableType.NUMBER && endValue.getType() == VariableType.NUMBER) {
            startNum = ((Number) startValue.getValue()).doubleValue();
            endNum = ((Number) endValue.getValue()).doubleValue();
        } else
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

        if (stepValue != null) {
            if (stepValue.getType() == VariableType.NUMBER)
                stepNum = ((Number) stepValue.getValue()).doubleValue();
            else
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        } else {
            if (startNum < endNum)
                stepNum = 1;
            else
                stepNum = -1;
        }

        SymbolTableEntry counter = context.getSymbolTableEntry(identifier);
        if (counter == null) {
            throw new InterpretationException(InterpretationErrorType.UNDEFINED_VARIABLE, line, null);
        }

        if (stepNum > 0) {
            for (double i = startNum; i < endNum; i = i + stepNum) {
                counter.setValue(new Value(i));
                for (int j = 0; j < this.getChildCount() - 3; j++) {
                    ((AbsStatementNode) this.getChildAt(j)).run(context);
                }
            }
        } else {
            for (double i = startNum; i > endNum; i = i - stepNum) {
                counter.setValue(new Value(i));
                for (int j = 0; j < this.getChildCount() - 3; j++) {
                    ((AbsStatementNode) this.getChildAt(j)).run(context);
                }
            }
        }

        return context;
    }

}
