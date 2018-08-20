CLASSPATH = ./classes
JCFLAGS = -Xlint:all -deprecation -classpath $(CLASSPATH) -d $(CLASSPATH) 
JFLAGS = -classpath $(CLASSPATH)

%.class: %.java     
	javac $(JCFLAGS) $<

all:
	javac $(JCFLAGS) HelloWorld.java

run: 
	java $(JFLAGS) HelloWorld
	
clean:     
	rm classes/HelloWorld.class
