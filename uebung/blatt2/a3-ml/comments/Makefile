APP      := comments
LEX      := flex
CC       := gcc

SRC_L    := comments.l
GEN_C    := lex.yy.c
BIN      := $(APP)
INPUT    := primzahltest.c

CFLAGS   := -Wall -Wextra -O2
LDLIBS   := -lfl

.PHONY: all run clean help

all: $(BIN)

help:
	@echo "make        - baut den Scanner"
	@echo "make run    - startet mit stdin-Umleitung aus $(INPUT)"
	@echo "make clean  - löscht erzeugte Dateien"

$(GEN_C): $(SRC_L)
	$(LEX) -o $@ $<

$(BIN): $(GEN_C)
	$(CC) $(CFLAGS) $< -o $@ $(LDLIBS)

run: $(BIN)
	./$(BIN) < $(INPUT)

clean:
	rm -f $(GEN_C) $(BIN)
