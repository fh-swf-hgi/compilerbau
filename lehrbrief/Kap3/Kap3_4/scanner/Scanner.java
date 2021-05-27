package Kap3.Kap3_4.scanner;

import Kap2.Kap2_2.sourcecodeprovider.SourceCodeProvider;
import Kap2.Kap2_2.sourcecodeprovider.StringProvider;
import Kap2.Kap2_2.token.Token;

public class Scanner {
    SourceCodeProvider provider;

    public static void main(String[] args) {
        StringProvider sp = new StringProvider("(14+13-hello");
        Scanner sc = new Scanner(sp);
        Token t;
        do {
            t = sc.getNextToken();
            switch (t.type) {
                case Bezeichner: System.out.println("Bezeichner:"+t.content); break;
                case IntegerLiteral: System.out.println("IntegerLiteral:"+t.content); break;
                case DoubleLiteral: System.out.println("DoubleLiteral "+t.content); break;
                default: System.out.println(t.typeToString(t.type)); break;
            }
        } while (t.type!=Token.Type.EOF);
    }

    public Scanner(SourceCodeProvider provider) { this.provider = provider; }

    static boolean isDigit(char c) { return c>='0' && c<='9'; }
    static boolean isAlpha(char c) { return (c>='a' && c<='z') || (c>='A' && c<='Z'); }
    static boolean isAlphaDigit(char c) { return isDigit(c) || isAlpha(c); }

    public Token getNextToken() {
        Token erg = new Token();
        char nextChar = 0;
        int state = 1;
        StringBuffer content = new StringBuffer();
        erg.startPosition = provider.getNextPosition();
        erg.type = Token.Type.EOF;
        erg.content = "";
        while (state!=0) {
            if (state !=10) nextChar = provider.getNextChar();
            switch (state) {
                case 1:
                    if (isAlpha(nextChar)) state = 2;
                    else if (isDigit(nextChar)) state = 3;
                    else if (nextChar=='.') state = 6;
                    else if ((nextChar=='+') || (nextChar=='-')
                        || (nextChar=='*') || (nextChar=='/') || (nextChar=='%')
                        || (nextChar=='^') || (nextChar=='!')
                        || (nextChar=='(') || (nextChar==')')
                        ) state = 4;
                    else if (nextChar==SourceCodeProvider.EOF) state = 0;
                    else state = 11;
                    break;
                case 2: erg.type = Token.Type.Bezeichner;
                    provider.setMarker();
                    erg.content += content;
                    content.setLength(0);
                    if (!isAlphaDigit(nextChar)) state = 0;
                    break;
                case 3: erg.type = Token.Type.IntegerLiteral;
                    provider.setMarker();
                    erg.content += content;
                    content.setLength(0);
                    if (nextChar=='.') state = 5;
                    else if (nextChar=='e' || nextChar=='E') state = 7;
                    else if (!isDigit(nextChar)) state = 0;
                    break;
                case 4: provider.setMarker();
                    erg.content += content;
                    switch (erg.content.charAt(0)) {
                        case '+': erg.type = Token.Type.PlusSymbol; break;
                        case '-': erg.type = Token.Type.MinusSymbol; break;
                        case '*': erg.type = Token.Type.Multiplikation; break;
                        case '/': erg.type = Token.Type.Division; break;
                        case '%': erg.type = Token.Type.ModuloOperator; break;
                        case '!': erg.type = Token.Type.TypKonverter; break;
                        case '(': erg.type = Token.Type.KlammerAuf; break;
                        case ')': erg.type = Token.Type.KlammerZu; break;
                        case '^': erg.type = Token.Type.Exponentiation; break;
                    }
                    content.setLength(0);
                    state = 0;
                    break;
                case 5: // leading digits
                    erg.type = Token.Type.DoubleLiteral;
                    if (nextChar=='e' || nextChar=='E') state = 7;
                    else if (!isDigit(nextChar)) state = 0;
                    provider.setMarker();
                    erg.content += content;
                    content.setLength(0);
                    break;
                case 6: // no leading digits
                    if (!isDigit(nextChar)) state = 10;
                    else {
                        erg.content += content;
                        content.setLength(0);
                        state = 5;
                    }
                    break;
                case 7: // e,E part
                    erg.type = Token.Type.DoubleLiteral;
                    break;
                case 11:
                case 10: erg.type = Token.Type.ERROR;
                    provider.setMarker();
                    erg.content += content;
                    content.setLength(0);
                    state = 0;
                    break;
            }
            if (state != 10)
                content.append(nextChar);
        }
        provider.resetToMarker();
        erg.endPosition = provider.getCurrentPosition();
        return erg;
    }
}
