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

public class SetBackgroundSNode extends AbsStatementNode {

    public SetBackgroundSNode(AbsValueNode n, int line) {
        super(line);
        if (n != null)
            setChildren(n);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {
        Value val = ((AbsValueNode) this.getChildAt(0)).evaluate(context);
        if (val.getType() == VariableType.STRING) 
        {
            if(val.toString().toUpperCase().equals("BLACK")) UserInterface.dw.setBackground(Color.BLACK);
            else if(val.toString().toUpperCase().equals("BLUE")) UserInterface.dw.setBackground(Color.BLUE);
            else if(val.toString().toUpperCase().equals("CYAN")) UserInterface.dw.setBackground(Color.CYAN);
            else if(val.toString().toUpperCase().equals("GRAY")) UserInterface.dw.setBackground(Color.GRAY);
            else if(val.toString().toUpperCase().equals("GREEN")) UserInterface.dw.setBackground(Color.GREEN);
            else if(val.toString().toUpperCase().equals("MAGENTA")) UserInterface.dw.setBackground(Color.MAGENTA);
            else if(val.toString().toUpperCase().equals("ORANGE")) UserInterface.dw.setBackground(Color.ORANGE);
            else if(val.toString().toUpperCase().equals("PINK")) UserInterface.dw.setBackground(Color.PINK);
            else if(val.toString().toUpperCase().equals("RED")) UserInterface.dw.setBackground(Color.RED);
            else if(val.toString().toUpperCase().equals("WHITE")) UserInterface.dw.setBackground(Color.WHITE);
            else if(val.toString().toUpperCase().equals("YELLOW")) UserInterface.dw.setBackground(Color.YELLOW);
            else throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        } 
        else
        {
            throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);
        }

        return context;
    }

}
