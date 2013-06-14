package type;

import error.CompilationException;
import error.CompilationErrorType;

public class NumberUtil {
	
	private static Number parseInteger(String number, int line) throws CompilationException {
		Number n = null;
		try {
			n = Byte.parseByte(number);
		}
		catch(Throwable _) {
			//
		}
		if (n==null) {
			try {
				n = Short.parseShort(number);
			}
			catch(Throwable _) {
				//
			}
		}
		if (n==null) {
			try {
				n = Integer.parseInt(number);
			}
			catch(Throwable _) {
				//
			}
		}
		if (n==null) {
			try {
				n = Long.parseLong(number);
			}
			catch(Throwable _) {
				throw new CompilationException(
						CompilationErrorType.NUMBER_LITERAL_REQUIRED,
						line,
						_);
			}
		}
		assert(n!=null);
		return n;
	}
	
	public static Number parse(String number, int line) throws CompilationException {
		Number n = null;
		try {
			n = Float.parseFloat(number);
			if ((n.floatValue() - n.longValue())==0l) {
				return parseInteger(Long.toString(n.longValue()), line);
			}
		}
		catch(Throwable _) {
			//
		}
		if (n==null) {
			try {
				n = Double.parseDouble(number);
				if ((n.doubleValue() - n.longValue())==0l) {
					return parseInteger(Long.toString(n.longValue()), line);
				}
			}
			catch(Throwable e) {
				//
			}
		}
		
		if (n!=null) return n;
		return parseInteger(number, line);
	}
	
	public static Integer parseInt(String number) {
		try {
			return Integer.parseInt(number);
		}
		catch(Throwable _) {
			return null;
		}
	}
	
	public static Number toNumber(double v) {
		if (Double.isNaN(v)) return Float.NaN;
		if (Double.isInfinite(v))
			return Float.valueOf(((v>=0.) ? Float.POSITIVE_INFINITY : Float.NEGATIVE_INFINITY));
		try {
			return parse(Double.toString(v), -1);
		}
		catch (CompilationException e) {
			return Double.valueOf(v);
		}
	}
}
