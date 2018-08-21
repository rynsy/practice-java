CLASSPATH = ./classes
JCFLAGS = -Xlint:all -deprecation -classpath $(CLASSPATH) -d $(CLASSPATH) 
JFLAGS = -classpath $(CLASSPATH)

%.class: %.java     
	javac $(JCFLAGS) $<

all:
	javac $(JCFLAGS) Queue.java

run:
	java $(JFLAGS) Queue
	
clean:     
	rm classes/Queue.class
