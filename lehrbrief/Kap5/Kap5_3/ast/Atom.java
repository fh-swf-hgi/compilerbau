package Kap5.Kap5_3.ast;

import Kap2.Kap2_2.token.Token;

public class Atom extends Node {
    Token token;

    public Atom(Token token) { this.token = token; }
    public String toString() {
        return "     >" + token.typeToString(token.type) + "\n";
    }
}
