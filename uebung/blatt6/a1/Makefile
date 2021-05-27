pname=calc
fname=$(pname)$(VERSION)

.PHONY: clean

y.tab.h y.tab.c: $(fname).y
	bison -y -d --graph $(fname).y

lex.yy.c: $(fname).l
	flex $(fname).l

$(pname): clean y.tab.c lex.yy.c
	gcc y.tab.c lex.yy.c -o $(pname) -ll -ly

clean:
	rm -f y.tab.h y.tab.c lex.yy.c $(pname)
