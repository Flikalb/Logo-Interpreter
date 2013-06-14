package syntaxtree;

import context.ExecutionContext;
import error.InterpretationException;
import type.Value;

public abstract class AbsValueNode extends AbsSyntaxNode {

    public AbsValueNode(int line) {
        super(line);
    }

    protected abstract Value evaluate(ExecutionContext executionContext) throws InterpretationException; // throws
                                                                                                      // InterpreterException;
}
