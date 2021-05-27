package Kap5.Kap5_3.parser;

import Kap5.Kap5_3.ast.*;
import Kap3.Kap3_4.filter.Filter;
import Kap3.Kap3_4.scanner.Scanner;
import Kap2.Kap2_2.sourcecodeprovider.StringProvider;
import Kap2.Kap2_2.token.Token;
import Kap2.Exceptions.MismatchError;

public class Parser {
    Filter filter;

    public static void main(String[] args) {
        StringProvider sp = new StringProvider("(1-2*3*2)");
        Filter f = new Filter(new Scanner(sp));
        Parser parser = new Parser(f);
        try {
            System.out.println(parser.parse());
        } catch (MismatchError er) {
            System.out.println("Error: "+er);
        }
    }

    public Parser(Filter filter) {
        this.filter = filter;
    }

    public Node parse() throws MismatchError {
        Node r = expr();
        filter.matchToken(Token.Type.EOF);
        return r;
    }

    public Node expr() throws MismatchError {
        // if (filter.getToken(0).type == Token.Type.EOF)
        //    return;
        Node n = prod();
        return exprList(n);
    }
    public Node exprList(Node n) throws MismatchError {
        switch (filter.getToken(0).type) {
            case PlusSymbol:
                filter.matchToken();
                n = new Add(n, prod());
                return exprList(n);
            case MinusSymbol:
                filter.matchToken();
                n = new Sub(n, prod());
                return exprList(n);
            default:
                return n;
        }
    }
    public Node prod() throws MismatchError {
        Node n = expo();
        return prodList(n);
    }
    public Node prodList(Node n) throws MismatchError {
        switch (filter.getToken(0).type) {
            case Multiplikation:
                filter.matchToken();
                n = new Mult(n, expo());
                return prodList(n);
            case Division:
                filter.matchToken();
                n = new Div(n, expo());
                return prodList(n);
            case ModuloOperator:
                filter.matchToken();
                n = new Mod(n, expo());
                return prodList(n);
            default:
                return n;
        }
    }

    public Node expo() throws MismatchError {
       Node n = sign();
       return expoOpt(n);
    }

    public Node expoOpt(Node n) throws MismatchError {
        if (filter.getToken(0).type == Token.Type.Exponentiation) {
            filter.matchToken();
            return new Exp(n,expo());
        }
        else return n;
    }

    public Node sign() throws MismatchError {
        switch (filter.getToken(0).type) {
            case TypKonverter:
                filter.matchToken();
                return new TypeCast(sign());
            case PlusSymbol:
                filter.matchToken();
                return new Pos(sign());
            case MinusSymbol:
                filter.matchToken();
                return new Neg(sign());
            default:
                return atom();
        }
    }
    public Node atom() throws MismatchError {
        switch (filter.getToken(0).type) {
            case IntegerLiteral:
                return new IntL(filter.matchToken());
            case DoubleLiteral:
                return new DoubleL(filter.matchToken());
            case Bezeichner:
                return new Identifier(filter.matchToken());
            default:
                filter.matchToken(Token.Type.KlammerAuf);
                Node n=expr();
                filter.matchToken(Token.Type.KlammerZu);
                return n;
        }
    }

}
