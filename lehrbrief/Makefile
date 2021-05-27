
run: runKap2 runKap3 runKap6

###############################################
########### K A P I T E L   2 #################
###############################################

Kap2/Kap2_2/sourcecodeprovider/sourcecodeprovider.class: $(shell find Kap2/Kap2_2/sourcecodeprovider -name *.java)
	javac Kap2/Kap2_2/sourcecodeprovider/*.java


Kap2/Kap2_2/test/testSourceCodeProvider.class: $(shell find Kap2/Kap2_2/test -name *.java) Kap2/Kap2_2/sourcecodeprovider/sourcecodeprovider.class
	javac Kap2/Kap2_2/test/testSourceCodeProvider.java


runKap2_File: Kap2/Kap2_2/test/testSourceCodeProvider.class Kap2/Kap2_2/test/testfile.txt
	java Kap2/Kap2_2/test/testSourceCodeProvider -f Kap2/Kap2_2/test/testfile.txt

runKap2_String: Kap2/Kap2_2/test/testSourceCodeProvider.class Kap2/Kap2_2/test/testfile.txt
	java Kap2/Kap2_2/test/testSourceCodeProvider "Dies . ist . ein . Test. Fertig...	"

Kap2/Kap2_4_1/eaalexer_Lex/lex.yy.c: Kap2/Kap2_4_1/eaalexer_Lex/EaA.l Kap2/Kap2_4_1/eaalexer_Lex/token.h
	cd Kap2/Kap2_4_1/eaalexer_Lex/ && flex EaA.l

Kap2/Kap2_4_1/eaalexer_Lex/EaA.exe: Kap2/Kap2_4_1/eaalexer_Lex/lex.yy.c
	cd Kap2/Kap2_4_1/eaalexer_Lex/ && gcc lex.yy.c -o EaA.exe

runKap2_Flex_EaA: Kap2/Kap2_4_1/eaalexer_Lex/EaA.exe
	Kap2/Kap2_4_1/eaalexer_Lex/EaA.exe < Kap2/Kap2_4_1/eaalexer_Lex/test.txt

Kap2/Kap2_4_2/eaalexer/EaALexer.java: Kap2/Kap2_4_2/eaalexer/EaALexer.jj
	javacc -OUTPUT_DIRECTORY=./Kap2/Kap2_4_2/eaalexer/	Kap2/Kap2_4_2/eaalexer/EaALexer.jj

Kap2/Kap2_4_2/eaalexer/EaALexer.class: Kap2/Kap2_4_2/eaalexer/EaALexer.java
	javac Kap2/Kap2_4_2/eaalexer/*.java

runKap2_JavaCC_EaA: Kap2/Kap2_4_2/eaalexer/EaALexer.class
	java Kap2/Kap2_4_2/eaalexer/EaALexer < Kap2/Kap2_4_1/eaalexer_Lex/test.txt

Kap2/Kap2_5/scanner_STMJ/Scanner.java: Kap2/Kap2_5/scanner_STMJ/Scanner.jj
	javacc -OUTPUT_DIRECTORY=./Kap2/Kap2_5/scanner_STMJ/ Kap2/Kap2_5/scanner_STMJ/Scanner.jj

Kap2/Kap2_5/scanner_STMJ/Scanner.class: Kap2/Kap2_5/scanner_STMJ/ Kap2/Kap2_5/scanner_STMJ/Scanner.java
	javac Kap2/Kap2_5/scanner_STMJ/*.java

runKap2_Scanner_STMJ: Kap2/Kap2_5/scanner_STMJ/Scanner.class
	java Kap2/Kap2_5/scanner_STMJ/Scanner

runKap2: runKap2_File runKap2_String runKap2_Flex_EaA runKap2_JavaCC_EaA runKap2_Scanner_STMJ

###############################################
########### K A P I T E L   3 #################
###############################################

Kap3/Kap3_4/filter/Filter.class: Kap3/Kap3_4/filter/Filter.java
	javac Kap3/Kap3_4/filter/*.java

Kap3/Kap3_4/scanner/Scanner.class: Kap3/Kap3_4/scanner/Scanner.java
	javac Kap3/Kap3_4/scanner/*.java

runKap3: Kap3/Kap3_4/scanner/Scanner.class
	java Kap3/Kap3_4/scanner/Scanner


###############################################
########### K A P I T E L   5 #################
###############################################

Kap5/Kap5_3/ast/Exp.class: Kap5/Kap5_3/ast/Exp.java
	javac Kap5/Kap5_3/ast/*.java

Kap5/Kap5_3/parser/Parser.class: Kap5/Kap5_3/parser/Parser.java
	javac Kap5/Kap5_3/parser/Parser.java

runKap5: Kap5/Kap5_3/parser/Parser.class
	java Kap5/Kap5_3/parser/Parser

###############################################
########### K A P I T E L   6 #################
###############################################

Kap6/Kap6_1_EaAParser_Yacc/y.tab.h: Kap6/Kap6_1_EaAParser_Yacc/EaA.y
	cd Kap6/Kap6_1_EaAParser_Yacc/ && bison -y -d EaA.y

Kap6/Kap6_1_EaAParser_Yacc/lex.yy.c: Kap6/Kap6_1_EaAParser_Yacc/y.tab.h Kap6/Kap6_1_EaAParser_Yacc/EaA.l
	cd Kap6/Kap6_1_EaAParser_Yacc/ && flex EaA.l

Kap6/Kap6_1_EaAParser_Yacc/EaA_yacc_parser: Kap6/Kap6_1_EaAParser_Yacc/lex.yy.c Kap6/Kap6_1_EaAParser_Yacc/y.tab.h
	cd Kap6/Kap6_1_EaAParser_Yacc/ && gcc lex.yy.c y.tab.c ParserTest.c -ll -ly -o EaA_yacc_parser

runKap6YaccParser: Kap6/Kap6_1_EaAParser_Yacc/EaA_yacc_parser
	cd Kap6/Kap6_1_EaAParser_Yacc/ && ./EaA_yacc_parser < ausdruck.txt
	cd Kap6/Kap6_1_EaAParser_Yacc/ && dot ast.dot -Tpng > ast.png


Kap6/Kap6_2_1_EaAParser_JavaCC/EaA.java: Kap6/Kap6_2_1_EaAParser_JavaCC/EaA.jj
	javacc -OUTPUT_DIRECTORY=./Kap6/Kap6_2_1_EaAParser_JavaCC/ Kap6/Kap6_2_1_EaAParser_JavaCC/EaA.jj

Kap6/Kap6_2_1_EaAParser_JavaCC/EaA.class: Kap6/Kap6_2_1_EaAParser_JavaCC/EaA.java
	javac Kap6/Kap6_2_1_EaAParser_JavaCC/*.java

runKap6JavaccEaA: Kap6/Kap6_2_1_EaAParser_JavaCC/EaA.class
	cd Kap6/Kap6_2_1_EaAParser_JavaCC/ && java EaAParser ExamplesEaA/Example1.eaa
	

Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaA.jj: Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaA.jjt
	jjtree -OUTPUT_DIRECTORY=./Kap6/Kap6_2_3_EaAParserAst_JavaCC/ Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaA.jjt

Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaAParser.java: Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaA.jj
	javacc -OUTPUT_DIRECTORY=./Kap6/Kap6_2_3_EaAParserAst_JavaCC/ Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaA.jj

Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaAParser.class: Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaAParser.java
	javac Kap6/Kap6_2_3_EaAParserAst_JavaCC/*.java

runKap6JavaccEaA_Ast: Kap6/Kap6_2_3_EaAParserAst_JavaCC/EaAParser.class Kap6/Kap6_2_3_EaAParserAst_JavaCC/ExamplesEaA/Example1.eaa
	cd Kap6/Kap6_2_3_EaAParserAst_JavaCC/ && java EaAParser ExamplesEaA/Example1.eaa

Kap6/Kap6_3_STMJParser/Parser.jj: Kap6/Kap6_3_STMJParser/Parser.jjt
	jjtree -OUTPUT_DIRECTORY=./Kap6/Kap6_3_STMJParser/ Kap6/Kap6_3_STMJParser/Parser.jjt

Kap6/Kap6_3_STMJParser/STMJ.java: Kap6/Kap6_3_STMJParser/Parser.jj
	javacc -OUTPUT_DIRECTORY=./Kap6/Kap6_3_STMJParser/ Kap6/Kap6_3_STMJParser/Parser.jj

Kap6/Kap6_3_STMJParser/STMJ.class: Kap6/Kap6_3_STMJParser/STMJ.java
	javac Kap6/Kap6_3_STMJParser/*.java

runKap6JavaccSTMJ: Kap6/Kap6_3_STMJParser/STMJ.class 
	java Kap6/Kap6_3_STMJParser/STMJ

runKap6: runKap6YaccParser runKap6JavaccEaA runKap6JavaccEaA_Ast runKap6JavaccSTMJ

allclean:
	rm -rf $(shell find Kap2 -name *.class)
	rm -rf $(shell find Kap3 -name *.class)
	rm -f Kap2/Kap2_5/scanner_STMJ/*.java
	rm -f Kap2/Kap2_4_2/eaalexer/*.java
	rm -f Kap2/Kap2_4_1/eaalexer_Lex/lex.yy.c Kap2/Kap2_4_1/eaalexer_Lex/EaA.exe
	rm -f Kap5/Kap5_3/ast/*.class
	rm -f Kap5/Kap5_3/parser/*.class
	rm -f Kap6/Kap6_1_EaAParser_Yacc/EaA_yacc_parser
	rm -f Kap6/Kap6_1_EaAParser_Yacc/lex.yy.c
	rm -f Kap6/Kap6_1_EaAParser_Yacc/y.tab.*
	rm -f Kap6/Kap6_1_EaAParser_Yacc/ast.*
	rm -f Kap6/Kap6_2_1_EaAParser_JavaCC/*.java
	rm -f Kap6/Kap6_2_1_EaAParser_JavaCC/*.class
	rm -f Kap6/Kap6_2_3_EaAParserAst_JavaCC/*.jj
	rm -f Kap6/Kap6_2_3_EaAParserAst_JavaCC/*.java
	rm -f Kap6/Kap6_2_3_EaAParserAst_JavaCC/*.class
	rm -f Kap6/Kap6_3_STMJParser/*.jj
	rm -f Kap6/Kap6_3_STMJParser/*.class





