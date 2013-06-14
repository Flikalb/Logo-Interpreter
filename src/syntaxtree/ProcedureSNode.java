package syntaxtree;

import java.util.ArrayList;

import context.ExecutionContext;
import error.InterpretationException;

public class ProcedureSNode extends AbsStatementNode {

    String name;
    private ArrayList<ThingVNode> args;
    private ArrayList<AbsStatementNode> instructions;
    public ProcedureSNode(int line) {
        super(line);
        // TODO Auto-generated constructor stub
    }

    public ProcedureSNode(String name, ArrayList<ThingVNode> args, ArrayList<AbsStatementNode> instructions, int line) {
        super(line);
        this.name = name;
        this.args = args;
        this.instructions = instructions;
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        for(AbsStatementNode s: instructions)
            s.run(context);
        return null;
    }

}
