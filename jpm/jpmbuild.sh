#!/bin/bash

javac *.java
echo Main-Class: JPM >manifest.txt
jar cvfm JPM.jar manifest.txt *.class

rm JPM.class manifest.txt