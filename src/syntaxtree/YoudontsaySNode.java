package syntaxtree;

import context.ExecutionContext;
import error.InterpretationException;

public class YoudontsaySNode extends AbsStatementNode{

	public YoudontsaySNode(AbsValueNode e, int line) {
        super(line);
        if (e != null)
            setChildren(e);
    }

    @Override
    public ExecutionContext run(ExecutionContext context) throws InterpretationException {

        AbsValueNode expression = (AbsValueNode) getChildAt(0);

        if (expression != null) {
            context.ui.console.setText(context.ui.console.getText() + "You don't say what to do with " + expression.evaluate(context).toString() + "\n");
        }
        return context;
    }

}
