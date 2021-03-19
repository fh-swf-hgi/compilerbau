pname=$(notdir $(CURDIR))

default: run

lex.yy.c: $(pname).l
	flex $(pname).l

$(pname): lex.yy.c
	gcc lex.yy.c -o $(pname)

run: $(pname)
	./$(pname) primzahltest.c

.PHONY: clean default run

clean:
	rm -f lex.yy.c $(pname)
