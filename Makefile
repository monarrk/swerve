# This was made for BSD make, so it may not be GNU compatible, not sure.

BUILD=.
JAVAC=javac
JAVA=java
JAR=jar
GEN=${BUILD}/Driver.class ${BUILD}/Pair.class ${BUILD}/Vector.class ${BUILD}/Wheel.class ${BUILD}/Wheels.class

all: ${GEN} bach/index.html

${GEN}: src/Driver.java
	${JAVAC} -d ${BUILD} src/Driver.java

# TODO how
#${BUILD}/Driver.jar:
#	${JAR} cf ${BUILD}/Driver.jar ${BUILD}/Driver.class

bach/index.html: ${GEN}
	bach

run:
	${JAVA} Driver

fmt:
	clang-format -i */*.java

clean: 
	rm -rf **.class **.jar