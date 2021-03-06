package syntaxtree;

import java.util.ArrayList;
import java.util.Collection;

import type.Value;
import type.VariableType;
import context.ExecutionContext;
import error.InterpretationErrorType;
import error.InterpretationException;

public class SentenceVNode extends AbsValueNode {

    public SentenceVNode(ArrayList<AbsValueNode> _list, int line) {
        super(line);

        AbsSyntaxNode[] children = new AbsSyntaxNode[_list.size()];
        for (int i = 0; i < _list.size(); i++) {
            children[i] = _list.get(i);
        }

        setChildren(children);
    }

    @Override
    protected Value evaluate(ExecutionContext context) throws InterpretationException {

        ArrayList<Value> _list = new ArrayList<Value>();

        for (int i = 0; i < this.getChildCount(); i++) {
            Value val;

            if (this.getChildAt(i) instanceof ListDataVNode || this.getChildAt(i) instanceof WordDataVNode
                    || this.getChildAt(i) instanceof NumberVNode || (this.getChildAt(i) instanceof ThingVNode))
                val = ((AbsValueNode) this.getChildAt(i)).evaluate(context);
            else
                throw new InterpretationException(InterpretationErrorType.INVALID_ARGUMENT, line, null);

            if (val.getType() == VariableType.ARRAYLIST)
                _list.addAll((Collection<? extends Value>) val.getValue());
            else
                _list.add(val);
        }

        return new Value(_list);
    }

}