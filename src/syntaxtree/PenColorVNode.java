package syntaxtree;

import java.awt.Color;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;
import type.Value;
import type.VariableType;

public class PenColorVNode extends AbsValueNode {

    public PenColorVNode(int line) {
        super(line);
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) throws InterpretationException {
    	
    	Color color = executionContext.ui.dw.getCurrentColor();
    	
    	if(color.equals(Color.BLACK)) return new Value("BLACK");
    	if(color.equals(Color.BLUE)) return new Value("BLUE");
    	if(color.equals(Color.YELLOW)) return new Value("YELLOW");
    	if(color.equals(Color.CYAN)) return new Value("CYAN");
    	if(color.equals(Color.RED)) return new Value("RED");
    	if(color.equals(Color.GREEN)) return new Value("GREEN");
    	if(color.equals(Color.MAGENTA)) return new Value("MAGENTA");
    	if(color.equals(Color.WHITE)) return new Value("WHITE");
    	
    	else throw new InterpretationException(InterpretationErrorType.UNDEFINED_VARIABLE,line,null);

    }
}
