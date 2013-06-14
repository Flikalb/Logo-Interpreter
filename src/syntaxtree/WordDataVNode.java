package syntaxtree;

import context.ExecutionContext;
import error.CompilationException;
import error.CompilationErrorType;
import type.Value;

public class WordDataVNode extends AbsValueNode {

    private String word;

    public WordDataVNode(String _string, int line) throws CompilationException {
        super(line);
        word = _string;
        if (word == null) {
            throw new CompilationException(CompilationErrorType.STRING_LITERAL_REQUIRED, line);
        }
    }

    @Override
    protected Value evaluate(ExecutionContext executionContext) {

        return new Value(word);
    }

    public String toString() {
        return word;
    }

}
