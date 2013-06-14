package syntaxtree;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import type.Value;
import type.VariableType;
import ui.Shape;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class SetPenColorSNode extends AbsStatementNode {

    public SetPenColorSNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        Value val = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (val.getType() == VariableType.STRING) 
        {
            if(val.toString().toUpperCase().equals("BLACK")) UserInterface.dw.setCurrentColor(Color.BLACK);
            else if(val.toString().toUpperCase().equals("BLUE")) UserInterface.dw.setCurrentColor(Color.BLUE);
            else if(val.toString().toUpperCase().equals("CYAN")) UserInterface.dw.setCurrentColor(Color.CYAN);
            else if(val.toString().toUpperCase().equals("GREEN")) UserInterface.dw.setCurrentColor(Color.GREEN);
            else if(val.toString().toUpperCase().equals("MAGENTA")) UserInterface.dw.setCurrentColor(Color.MAGENTA);
            else if(val.toString().toUpperCase().equals("RED")) UserInterface.dw.setCurrentColor(Color.RED);
            else if(val.toString().toUpperCase().equals("WHITE")) UserInterface.dw.setCurrentColor(Color.WHITE);
            else if(val.toString().toUpperCase().equals("YELLOW")) UserInterface.dw.setCurrentColor(Color.YELLOW);
        } 
    	else
    	{
    		throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
    	}

        return context;
    }

}
