package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class RepeatSNode extends AbsStatementNode {

    public RepeatSNode(AbsValueNode n, ArrayList<AbsStatementNode> instructions, int line) {
        super(line);

        AbsSyntaxNode[] children = new AbsSyntaxNode[instructions.size() + 1];
        for (int i = 0; i < instructions.size(); i++) {
            children[i] = instructions.get(i);
        }
        children[instructions.size()] = n;

        setChildren(children);

    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        Value val = ((AbsValueNode) getChildAt(this.getChildCount() - 1)).evaluate(context);

        if (val.getType() == VariableType.NUMBER) {
            for (int i = 0; i < ((Number) val.getValue()).intValue(); i++) {
                for (int j = 0; j < this.getChildCount() - 1; j++) {
                    ((AbsStatementNode) this.getChildAt(j)).run(context);
                }
            }
            return context;
        } else
            throw new InterpretationException(InterpretationErrorType.BOOLEAN_EXPECTED, line, null);
    }

}
