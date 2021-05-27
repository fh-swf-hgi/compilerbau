package Kap3.Kap3_4.filter;

import Kap3.Kap3_4.scanner.Scanner;
import Kap2.Kap2_2.token.Token;
import Kap2.Exceptions.MismatchError;

import java.util.LinkedList;

public class Filter {
    Scanner scanner;
    LinkedList<Token> tokenList = new LinkedList<>();

    public Filter(Scanner scanner) { this.scanner = scanner; }
    public Token getToken(int i) {
        while (tokenList.size()<=i) tokenList.addLast(scanner.getNextToken());
        return tokenList.get(i);
    }
    public Token matchToken() {
        if (tokenList.size()==0)
            tokenList.addLast(scanner.getNextToken());
        return tokenList.removeFirst();
    }
    public boolean matchToken(Token.Type type) throws MismatchError {
        Token t = matchToken();
        return t.type == type; 
    }
}
