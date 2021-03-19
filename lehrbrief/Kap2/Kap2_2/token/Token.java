package Kap2.Kap2_2.token;

import Kap2.Kap2_2.sourcecodeprovider.SourcePosition;

public class Token {
    public static enum Type { EOF, ERROR, KlammerAuf, KlammerZu, Bezeichner, TypKonverter,
        IntegerLiteral, DoubleLiteral, PlusSymbol, MinusSymbol, Multiplikation,
        Division, ModuloOperator, Exponentiation };
    public Type type;
    public String content;
    public SourcePosition startPosition, endPosition;
	
	public String TypeNames[] = { "EOF", "ERROR", "KlammerAuf", "KlammerZu", "Bezeichner", "TypKonverter",
        "IntegerLiteral", "DoubleLiteral", "PlusSymbol", "MinusSymbol", "Multiplikation",
        "Division", "ModuloOperator", "Exponentiation" };
	
	public String typeToString(Type t){
		return TypeNames[t.ordinal()];
	}
	
}
