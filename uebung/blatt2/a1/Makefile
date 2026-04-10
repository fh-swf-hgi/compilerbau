# Makefile für Aufgabe 1:
# - Token-Ausgabe des Clang-Lexers
#
# Voraussetzung:
#   clang (Apple Clang genügt)
#   Quelldatei: main.c
#
# Nutzung:
#   make
#   make tokens
#   make raw
#   make clean

CLANG  := clang
SRC    := main.c
BASE   := $(basename $(SRC))

OUT_TOKENS := $(BASE)_tokens.txt
OUT_RAW    := $(BASE)_raw_tokens.txt

.PHONY: all tokens raw clean help

all: tokens raw

help:
	@echo "Verfügbare Ziele:"
	@echo "  make tokens  - dump-tokens (vorverarbeitete Tokens)"
	@echo "  make raw     - dump-raw-tokens (ohne Präprozessor)"
	@echo "  make clean   - Ausgabedateien löschen"

tokens: $(OUT_TOKENS)

$(OUT_TOKENS): $(SRC)
	$(CLANG) -cc1 -dump-tokens $(SRC) > $@

raw: $(OUT_RAW)

$(OUT_RAW): $(SRC)
	$(CLANG) -cc1 -dump-raw-tokens $(SRC) > $@

clean:
	rm -f $(OUT_TOKENS) $(OUT_RAW)
