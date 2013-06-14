package symbol;

import type.Value;

public class SymbolTableEntry {

    private String identifier;
    private Value value = new Value();
    private int line;

    public SymbolTableEntry(String identifier, int line) {
        assert (identifier != null);
        assert (line >= 1);
        this.identifier = identifier;
        this.line = line;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value val) {
        value.set(val);
    }

}