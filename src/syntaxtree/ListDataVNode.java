package syntaxtree;

import java.util.ArrayList;

import type.Value;

import context.ExecutionContext;
import error.InterpretationException;

public class ListDataVNode extends AbsValueNode {

    public ListDataVNode(ArrayList<AbsValueNode> _list, int line) {
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
        for (int i = 0; i < this.getChildCount(); i++)
            _list.add(((AbsValueNode) this.getChildAt(i)).evaluate(context));
        return new Value(_list);
    }

}
