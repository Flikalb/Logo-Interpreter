package syntaxtree;

import context.ExecutionContext;
import error.CompilationException;
import type.NumberUtil;
import type.Value;

public class NumberVNode extends AbsValueNode {

    private final Value value;

    public NumberVNode(String number, int line) throws CompilationException {
        super(line);
        Number n = NumberUtil.parse(number, line);
        value = new Value(n);
    }

    @Override
    public Value evaluate(ExecutionContext executionContext) {
        return this.value;
    }
}
