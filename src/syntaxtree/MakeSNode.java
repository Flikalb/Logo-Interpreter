package syntaxtree;

import context.ExecutionContext;
import error.InterpretationException;
import symbol.SymbolTableEntry;
import type.VariableName;

public class MakeSNode extends AbsStatementNode {

    private final VariableName identifier;

    public MakeSNode(VariableName identifier, AbsValueNode expression, int line) {
        super(line);
        this.identifier = identifier;
        setChildren(expression);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        SymbolTableEntry entry = context.getSymbolTableEntry(identifier.toString());
        AbsValueNode expression = (AbsValueNode) getChildAt(0);
        entry.setValue(expression.evaluate(context));
        return context;

    }

}
