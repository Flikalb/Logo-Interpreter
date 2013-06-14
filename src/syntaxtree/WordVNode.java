package syntaxtree;

import java.util.ArrayList;

import type.Value;

import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class WordVNode extends AbsValueNode {

    public WordVNode(ArrayList<AbsValueNode> _list, int line) {
        super(line);

        AbsSyntaxNode[] children = new AbsSyntaxNode[_list.size()];
        for (int i = 0; i < _list.size(); i++) {
            children[i] = _list.get(i);
        }

        setChildren(children);

    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        StringBuilder str = new StringBuilder();

        for (int i = 0; i < this.getChildCount(); i++) {
            Value val;

            if (this.getChildAt(i) instanceof WordDataVNode || this.getChildAt(i) instanceof NumberVNode)
                val = ((AbsValueNode) this.getChildAt(i)).evaluate(context);
            else
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

            str.append(val.toString());
        }

        return new Value(str.toString());
    }

}
