package type;

import symbol.SymbolTable;
import syntaxtree.AbsValueNode;

public class VariableName {

    private final String identifier;
    private AbsValueNode arrayIndex;

    public VariableName(String identifier, AbsValueNode arrayIndex) {
        assert (identifier != null && !identifier.isEmpty());
        this.identifier = identifier;
        this.arrayIndex = arrayIndex;
    }

    public VariableName(String identifier) {
        this.identifier = identifier;
    }

    public String toString() {
        return identifier;
    }

}
