CC=g++
JAVA=javac
CFLAGS=-c -Wall
JFLAGS=
LDFLAGS=
CSOURCES= driver.cpp Matrix2D.cpp
JSOURCES= Driver.java Matrix2D.java
OBJECTS=$(SOURCES:.c=.o)
        EXECUTABLE=Matrix2D

java: 
	$(JAVA) $(JFLAGS) $(JSOURCES)

cpp: 
	$(CSOURCES) $(EXECUTABLE)
            
$(EXECUTABLE): $(OBJECTS) 
	$(CC) $(LDFLAGS) $(OBJECTS) -o $@

.c.o:
	$(CC) $(CFLAGS) $< -o $@


clean:
	rm -rf *.o *.s ip 
