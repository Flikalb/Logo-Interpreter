package context;

import symbol.SymbolTable;
import symbol.SymbolTableEntry;
import ui.UserInterface;

public class ExecutionContext {

    private SymbolTable symbolTable;
    private ExecutionContext parent;
    public static UserInterface ui;

    public ExecutionContext(SymbolTable sym) {
        symbolTable = sym;
    }

    public ExecutionContext(SymbolTable syms, UserInterface ui) {
        symbolTable = syms;
        this.ui = ui;
    }

    public SymbolTableEntry getSymbolTableEntry(String identifier) {
        return symbolTable.getEntry(identifier);
    }

    public void setParent(ExecutionContext context) {
        this.parent = context;
    }

    public ExecutionContext getParent() {
        return parent;
    }
}
