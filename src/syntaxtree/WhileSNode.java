package syntaxtree;

import java.util.ArrayList;

import type.Value;
import type.VariableType;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import symbol.SymbolTableEntry;

public class WhileSNode extends AbsStatementNode {

    public WhileSNode(AbsValueNode test, ArrayList<AbsStatementNode> instructions, int line) {
        super(line);

        AbsSyntaxNode[] children = new AbsSyntaxNode[instructions.size() + 1];
        for (int i = 0; i < instructions.size(); i++) {
            children[i] = instructions.get(i);
        }
        children[instructions.size()] = test;

        setChildren(children);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        AbsValueNode temp = (AbsValueNode) getChildAt(this.getChildCount() - 1);
        assert(temp!=null);
        Value test = (temp.evaluate(context));
        if (test.getType() != VariableType.BOOLEAN)
            throw new InterpretationException(InterpretationErrorType.BOOLEAN_EXPECTED, line, null);
        while (test.getValue(Boolean.class)) {
            for (int j = 0; j < this.getChildCount() - 1; j++) {
                ((AbsStatementNode) this.getChildAt(j)).run(context);
            }
            test = temp.evaluate(context);
        }
        return context;

    }

}
