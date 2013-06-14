package interpreter;

import java.util.ArrayList;

import syntaxtree.AbsStatementNode;
import syntaxtree.ThingVNode;

public class ProcedureDefinition {
    private ArrayList<ThingVNode> args;
    private ArrayList<AbsStatementNode> instructions;
    
    public ProcedureDefinition(ArrayList<ThingVNode> args, ArrayList<AbsStatementNode> instructions) {
        this.args = args;
        this.instructions = instructions;
    }
    
    public int getArgsNumber() {
        return args.size();
    }
}
