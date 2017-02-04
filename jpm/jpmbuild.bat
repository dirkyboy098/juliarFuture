@echo off


javac *.java
echo Main-Class: JPM >manifest.txt
jar cvfm JPM.jar manifest.txt *.class

del JPM.class manifest.txt