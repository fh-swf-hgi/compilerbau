pname=parser

.PHONY: clean

run: $(pname)
	./$(pname) testfile
	dot ast.dot -Tpng > ast.png

$(pname): clean y.tab.c lex.yy.c parser.h ast.c
	gcc y.tab.c lex.yy.c ast.c -o $(pname) -ll -ly

y.tab.h y.tab.c: $(pname).y parser.h
	bison -y -d $(pname).y

lex.yy.c: $(pname).l parser.h
	flex $(pname).l


clean:
	rm -f y.tab.h y.tab.c lex.yy.c $(pname)
