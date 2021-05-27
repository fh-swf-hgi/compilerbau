run: runKap6

###############################################
########### K A P I T E L   6 #################
###############################################

y.tab.h: EaA.y
	bison -y -d EaA.y

lex.yy.c: y.tab.h EaA.l
	flex EaA.l

EaA_yacc_parser: lex.yy.c y.tab.h ParserTest.c
	gcc lex.yy.c y.tab.c ParserTest.c -ll -ly -o EaA_yacc_parser

YaccParser: EaA_yacc_parser ausdruck.txt
	./EaA_yacc_parser < ausdruck.txt
	dot ast.dot -Tpng > ast.png


runKap6: YaccParser 
	nomacs ast.png &

clean:
	rm -f EaA_yacc_parser
	rm -f lex.yy.c
	rm -f y.tab.*
	rm -f ast.*






