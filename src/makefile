Main.class: Main.java Driver.class Finder.class SquareM.class 
	javac -g  Main.java Driver.java Finder.java SquareM.java
Driver.class: Driver.java SquareM.class Finder.Class
	javac -g Driver.java 
SquareM.class: SquareM.java Finder.class
	javac -g  SquareM.java Finder.java
Finder.class: Finder.java
	javac -g SquareM.java
clean: 
	rm *.class
run:	Main.class
	java Main
debug:	Main.class
	jdb Main
