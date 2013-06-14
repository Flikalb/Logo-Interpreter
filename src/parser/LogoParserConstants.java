/* Generated By:JavaCC: Do not edit this line. LogoParserConstants.java */
package parser;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface LogoParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int CR = 5;
  /** RegularExpression Id. */
  int NUMBER = 6;
  /** RegularExpression Id. */
  int DIGIT = 7;
  /** RegularExpression Id. */
  int DECIMAL_PART = 8;
  /** RegularExpression Id. */
  int MAKE = 9;
  /** RegularExpression Id. */
  int LOCALMAKE = 10;
  /** RegularExpression Id. */
  int LOCAL = 11;
  /** RegularExpression Id. */
  int WORD = 12;
  /** RegularExpression Id. */
  int LIST = 13;
  /** RegularExpression Id. */
  int SENTENCE = 14;
  /** RegularExpression Id. */
  int FPUT = 15;
  /** RegularExpression Id. */
  int LPUT = 16;
  /** RegularExpression Id. */
  int REVERSE = 17;
  /** RegularExpression Id. */
  int PUSH = 18;
  /** RegularExpression Id. */
  int POP = 19;
  /** RegularExpression Id. */
  int QUEUE = 20;
  /** RegularExpression Id. */
  int DEQUEUE = 21;
  /** RegularExpression Id. */
  int THING = 22;
  /** RegularExpression Id. */
  int FIRST = 23;
  /** RegularExpression Id. */
  int LAST = 24;
  /** RegularExpression Id. */
  int BUTFIRST = 25;
  /** RegularExpression Id. */
  int BUTLAST = 26;
  /** RegularExpression Id. */
  int ITEM = 27;
  /** RegularExpression Id. */
  int PICK = 28;
  /** RegularExpression Id. */
  int REMOVE = 29;
  /** RegularExpression Id. */
  int WAIT = 30;
  /** RegularExpression Id. */
  int SUM = 31;
  /** RegularExpression Id. */
  int DIFF = 32;
  /** RegularExpression Id. */
  int MINUS = 33;
  /** RegularExpression Id. */
  int PROD = 34;
  /** RegularExpression Id. */
  int DIV = 35;
  /** RegularExpression Id. */
  int MOD = 36;
  /** RegularExpression Id. */
  int ROUND = 37;
  /** RegularExpression Id. */
  int SQRT = 38;
  /** RegularExpression Id. */
  int POWER = 39;
  /** RegularExpression Id. */
  int SIN = 40;
  /** RegularExpression Id. */
  int ISEQ = 41;
  /** RegularExpression Id. */
  int RSEQ = 42;
  /** RegularExpression Id. */
  int AND = 43;
  /** RegularExpression Id. */
  int OR = 44;
  /** RegularExpression Id. */
  int NOT = 45;
  /** RegularExpression Id. */
  int LESS = 46;
  /** RegularExpression Id. */
  int LESSEQUAL = 47;
  /** RegularExpression Id. */
  int GREATER = 48;
  /** RegularExpression Id. */
  int GREATEREQUAL = 49;
  /** RegularExpression Id. */
  int EQUAL = 50;
  /** RegularExpression Id. */
  int NOTEQUAL = 51;
  /** RegularExpression Id. */
  int PRINT = 52;
  /** RegularExpression Id. */
  int IF = 53;
  /** RegularExpression Id. */
  int IFELSE = 54;
  /** RegularExpression Id. */
  int REPEAT = 55;
  /** RegularExpression Id. */
  int FOR = 56;
  /** RegularExpression Id. */
  int WHILE = 57;
  /** RegularExpression Id. */
  int UNTIL = 58;
  /** RegularExpression Id. */
  int TO = 59;
  /** RegularExpression Id. */
  int END = 60;
  /** RegularExpression Id. */
  int FORWARD = 61;
  /** RegularExpression Id. */
  int BACK = 62;
  /** RegularExpression Id. */
  int RIGHT = 63;
  /** RegularExpression Id. */
  int LEFT = 64;
  /** RegularExpression Id. */
  int HOME = 65;
  /** RegularExpression Id. */
  int SETPOS = 66;
  /** RegularExpression Id. */
  int SETX = 67;
  /** RegularExpression Id. */
  int SETY = 68;
  /** RegularExpression Id. */
  int SETXY = 69;
  /** RegularExpression Id. */
  int SETHEADING = 70;
  /** RegularExpression Id. */
  int SHOWTURTLE = 71;
  /** RegularExpression Id. */
  int HIDETURTLE = 72;
  /** RegularExpression Id. */
  int CLEAN = 73;
  /** RegularExpression Id. */
  int CLEARSCREEN = 74;
  /** RegularExpression Id. */
  int LABEL = 75;
  /** RegularExpression Id. */
  int CIRCLE = 76;
  /** RegularExpression Id. */
  int ARC = 77;
  /** RegularExpression Id. */
  int ELLIPSE = 78;
  /** RegularExpression Id. */
  int PENDOWN = 79;
  /** RegularExpression Id. */
  int PENUP = 80;
  /** RegularExpression Id. */
  int SETPC = 81;
  /** RegularExpression Id. */
  int PENERASE = 82;
  /** RegularExpression Id. */
  int PENPAINT = 83;
  /** RegularExpression Id. */
  int PENCOLOR = 84;
  /** RegularExpression Id. */
  int PENREVERSE = 85;
  /** RegularExpression Id. */
  int PEN = 86;
  /** RegularExpression Id. */
  int SETPEN = 87;
  /** RegularExpression Id. */
  int SETBACKGROUND = 88;
  /** RegularExpression Id. */
  int TOKENWORD = 89;
  /** RegularExpression Id. */
  int LETTER = 90;
  /** RegularExpression Id. */
  int NONEVALUATE = 91;
  /** RegularExpression Id. */
  int ACCESSOP = 92;
  /** RegularExpression Id. */
  int OPENBRACKET = 93;
  /** RegularExpression Id. */
  int CLOSEBRACKET = 94;
  /** RegularExpression Id. */
  int OPENPARENTH = 95;
  /** RegularExpression Id. */
  int CLOSEPARENTH = 96;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\r\"",
    "\"\\t\"",
    "\"\\n\\t\"",
    "<CR>",
    "<NUMBER>",
    "<DIGIT>",
    "<DECIMAL_PART>",
    "\"make\"",
    "\"localmake\"",
    "\"local\"",
    "\"word\"",
    "\"list\"",
    "<SENTENCE>",
    "\"fput\"",
    "\"lput\"",
    "\"reverse\"",
    "\"push\"",
    "\"pop\"",
    "\"queue\"",
    "\"dequeue\"",
    "\"thing\"",
    "\"first\"",
    "\"last\"",
    "\"butfirst\"",
    "\"butlast\"",
    "\"item\"",
    "\"pick\"",
    "\"remove\"",
    "\"wait\"",
    "\"sum\"",
    "\"difference\"",
    "\"minus\"",
    "\"product\"",
    "\"quotient\"",
    "<MOD>",
    "\"round\"",
    "\"sqrt\"",
    "\"power\"",
    "\"sin\"",
    "\"iseq\"",
    "\"rseq\"",
    "\"and\"",
    "\"or\"",
    "\"not\"",
    "<LESS>",
    "<LESSEQUAL>",
    "<GREATER>",
    "<GREATEREQUAL>",
    "<EQUAL>",
    "<NOTEQUAL>",
    "<PRINT>",
    "\"if\"",
    "\"ifelse\"",
    "\"repeat\"",
    "\"for\"",
    "\"while\"",
    "\"until\"",
    "\"to\"",
    "\"end\"",
    "<FORWARD>",
    "<BACK>",
    "<RIGHT>",
    "<LEFT>",
    "\"home\"",
    "\"setpos\"",
    "\"setx\"",
    "\"sety\"",
    "\"setxy\"",
    "<SETHEADING>",
    "<SHOWTURTLE>",
    "<HIDETURTLE>",
    "\"clean\"",
    "<CLEARSCREEN>",
    "\"label\"",
    "\"circle\"",
    "\"arc\"",
    "\"ellipse\"",
    "<PENDOWN>",
    "<PENUP>",
    "<SETPC>",
    "<PENERASE>",
    "<PENPAINT>",
    "<PENCOLOR>",
    "<PENREVERSE>",
    "\"pen\"",
    "\"setpen\"",
    "<SETBACKGROUND>",
    "<TOKENWORD>",
    "<LETTER>",
    "\"\\\"\"",
    "\":\"",
    "\"[\"",
    "\"]\"",
    "\"(\"",
    "\")\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"<\"",
    "\"<=\"",
    "\">\"",
    "\">=\"",
    "\"=\"",
    "\"<>\"",
  };

}
