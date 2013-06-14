package symbol;

import java.util.Map;
import java.util.TreeMap;

import symbol.SymbolTableEntry;

public class SymbolTable {

    private final Map<String, SymbolTableEntry> symbols = new TreeMap<String, SymbolTableEntry>();

    public SymbolTableEntry declare(String image, int line) {
        SymbolTableEntry entry = this.symbols.get(image);
        if (entry != null)
            return entry;
        entry = new SymbolTableEntry(image, line);
        this.symbols.put(image, entry);
        return entry;

    }

    public SymbolTableEntry getEntry(String identifier) {
        return symbols.get(identifier);
    }

    public void clear() {
        symbols.clear();
    }

}
