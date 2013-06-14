package error;

import error.CompilationErrorType;

public class CompilationException extends Exception {
    private static final long serialVersionUID = -7542484779365077551L;

    private final CompilationErrorType type;
    private final int line;

    public CompilationException(CompilationErrorType type, int endLine, Throwable e) {
        super(e);
        assert (type != null);
        this.type = type;
        this.line = endLine;
    }

    public CompilationException(CompilationErrorType type, Throwable e) {
        super(e);
        this.type = type;
        line = 0;
    }
    
	public CompilationException(CompilationErrorType type, int line, String message) {
		super(message);
		assert(type!=null);
		this.type = type;
		this.line=line;
	}

    public CompilationException(CompilationErrorType type, int line) {
    	this.type = type;
		this.line=line;
	}

	public String toString() {
        return type.toString() + "\nLine : " + line + "\nMessage : " + super.getMessage();
    }

}
