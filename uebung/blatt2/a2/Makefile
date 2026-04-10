# Makefile für Aufgabe 2:
# - Assembler-Ausgabe für verschiedene Optimierungsstufen
# - GCC-Pass-Ausgabe
# - GIMPLE/SSA-Dumps
# - DOT/PNG-Dateien aus GCC-Graph-Dumps
#
# Annahme:
#   Quelldatei heißt main.c
#
# Nutzung:
#   make
#   make asm
#   make passes
#   make ir
#   make graphs
#   make clean

CC      := gcc-14
CFLAGS  := -Wall -Wextra -std=c11
SRC     := main.c
BASE    := $(basename $(SRC))

DOT     := dot

ASM_LEVELS := 0 1 2 3 s
ASM_FILES  := $(addprefix $(BASE)_O,$(addsuffix .s,$(ASM_LEVELS)))

.PHONY: all asm passes ir graphs clean help

all: asm passes ir graphs

help:
	@echo "Verfügbare Ziele:"
	@echo "  make asm     - Assemblerdateien für -O0, -O1, -O2, -O3, -Os"
	@echo "  make passes  - Ausgabe der GCC-Passes auf stdout"
	@echo "  make ir      - GIMPLE- und SSA-Dumps erzeugen"
	@echo "  make graphs  - DOT-Dateien und PNG-Bilder aus GCC-Graph-Dumps erzeugen"
	@echo "  make clean   - erzeugte Dateien löschen"

asm: $(ASM_FILES)

$(BASE)_O0.s: $(SRC)
	$(CC) $(CFLAGS) -O0 -S $< -o $@

$(BASE)_O1.s: $(SRC)
	$(CC) $(CFLAGS) -O1 -S $< -o $@

$(BASE)_O2.s: $(SRC)
	$(CC) $(CFLAGS) -O2 -S $< -o $@

$(BASE)_O3.s: $(SRC)
	$(CC) $(CFLAGS) -O3 -S $< -o $@

$(BASE)_Os.s: $(SRC)
	$(CC) $(CFLAGS) -Os -S $< -o $@

passes:
	$(CC) $(CFLAGS) -Os -S $(SRC) -fdump-passes -o /dev/null

ir:
	$(CC) $(CFLAGS) -c $(SRC) -fdump-tree-gimple
	$(CC) $(CFLAGS) -c $(SRC) -fdump-tree-ssa

graphs:
	$(CC) $(CFLAGS) -c -O3 $(SRC) -fdump-tree-all-graph
	@for f in $(SRC).*t.*.dot; do \
		if [ -f "$$f" ]; then \
			$(DOT) -Tpng "$$f" -o "$$f.png"; \
			echo "Erzeugt: $$f.png"; \
		fi; \
	done

clean:
	rm -f $(BASE)_O0.s $(BASE)_O1.s $(BASE)_O2.s $(BASE)_O3.s $(BASE)_Os.s
	rm -f $(BASE).o
	rm -f $(SRC).*
	rm -f *.dot *.dot.png
	rm -f *.gimple *.ssa
