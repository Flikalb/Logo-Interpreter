package error;

public class InterpretationException extends Exception {
    private static final long serialVersionUID = 3483503316548193780L;

    private final InterpretationErrorType type;
    private final int line;

    public InterpretationException(InterpretationErrorType type, int endLine, Throwable e) {
        super(e);
        assert (type != null);
        this.type = type;
        this.line = endLine;
    }

    /*
     * public InterpreterException(InterpretationErrorType type, Throwable e) {
     * super(e); line = 0; this.type = type; }
     */

    public String toString() {
        return type.toString() + "\nLine : " + line + "\nMessage : " + super.getMessage();
    }
}
