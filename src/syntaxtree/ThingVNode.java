package syntaxtree;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import symbol.SymbolTableEntry;
import type.Value;
import type.VariableName;

public class ThingVNode extends AbsValueNode {

    private final String identifier;

    public ThingVNode(String identifier, int line) {
        super(line);
        assert (identifier != null && !identifier.isEmpty());
        this.identifier = identifier;
    }

    /**
     * {@inheritDoc}
     * 
     * @throws InterpretationException
     */
    @Override
    public Value evaluate(ExecutionContext executionContext) throws InterpretationException {
        SymbolTableEntry entry = executionContext.getSymbolTableEntry(this.identifier);
        if (entry == null)
            throw new InterpretationException(InterpretationErrorType.UNDEFINED_VARIABLE, line, null);
        Value value = entry.getValue();
        assert (value != null);
        return value;
    }

    @Override
    public String toString() {
        return this.identifier;
    }

}
