run: runKap6

flex=/opt/homebrew/opt/flex/bin/flex
bison=/opt/homebrew/opt/bison/bin/yacc
code=/Applications/Visual\ Studio\ Code.app/Contents/Resources/app/bin/code

###############################################
########### K A P I T E L   6 #################
###############################################

y.tab.h: EaA.y
	$(bison) -y -d EaA.y

lex.yy.c: y.tab.h EaA.l
	$(flex) EaA.l

EaA_yacc_parser: lex.yy.c y.tab.h ParserTest.c
	gcc lex.yy.c y.tab.c ParserTest.c -ll -ly -o EaA_yacc_parser
	chmod +x EaA_yacc_parser

YaccParser: EaA_yacc_parser ausdruck.txt
	./EaA_yacc_parser < ausdruck.txt
	dot ast.dot -Tpng > ast.png


runKap6: YaccParser 
	$(code) -r ./ast.png

clean:
	rm -f EaA_yacc_parser
	rm -f lex.yy.c
	rm -f y.tab.*
	rm -f ast.*






