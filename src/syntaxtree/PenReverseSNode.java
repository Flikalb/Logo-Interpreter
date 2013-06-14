package syntaxtree;

import java.awt.Color;

import ui.DrawingZone;
import ui.UserInterface;
import context.ExecutionContext;
import error.InterpretationException;

public class PenReverseSNode extends AbsStatementNode {

    public PenReverseSNode(int line) {
        super(line);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

    	Color color = new Color(UserInterface.dw.getCurrentColor().getRGB());
    	Color nextColor = new Color(255-color.getRed(),255-color.getGreen(),255-color.getBlue());  	
    	UserInterface.dw.setCurrentColor(nextColor);
        DrawingZone.turtle.setPen(true);
        UserInterface.dw.revalidate();
        return context;
    }

}
