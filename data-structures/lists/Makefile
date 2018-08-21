CLASSPATH = ./classes
JCFLAGS = -Xlint:all -deprecation -classpath $(CLASSPATH) -d $(CLASSPATH) 
JFLAGS = -classpath $(CLASSPATH)

%.class: %.java     
	javac $(JCFLAGS) $<

all:
	javac $(JCFLAGS) Lists.java

run:
	java $(JFLAGS) Lists
	
clean:     
	rm classes/Lists.class
