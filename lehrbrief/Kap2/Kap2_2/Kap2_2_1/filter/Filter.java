package Kap2.Kap2_2.Kap2_2_1.filter;

// import some Scanner, see e.g. Kap3

import java.util.LinkedList;
import Kap2.Exceptions.MismatchError;
import Kap2.Kap2_2.token.Token;

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
