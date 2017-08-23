#!/bin/sh
export CLASSPATH="jars/antlr-4.7-complete.jar:jars/nirerepl.jar:jars/asm-all-6.0_BETA.jar:jars/richtextfx-fat-0.7-M5.jar:jars/fastcgi.jar:out"

type java > /dev/null 2>&1 || {
echo 'java' is not defined. Please make sure you have installed JDK w/ JRE and that 'java' is in the PATH.;
exit 1
}

type javac > /dev/null 2>&1 || {
echo 'javac' is not defined. Please make sure you have installed JDK and that 'javac' is in the PATH.;
exit 1
}

type jar > /dev/null 2>&1 || {
echo 'jar' is not defined. Please make sure you have installed JDK and 'JAR.exe' is in the PATH.;
exit 1
}

rm -rf out
rm -rf temp

mkdir out
mkdir temp

java org.antlr.v4.Tool src/com/juliar/parser/Juliar.g4  -o . -no-listener -package com.juliar.parser -visitor
javac -Xlint -d out -sourcepath src -g -encoding UTF-8 -source 8 -target 8 src/com/juliar/JuliarCompiler.java -verbose

cd jars || exit
ls -1 ./*.jar > filelist

grep -v '^ *#' < filelist | while IFS= read -r filename
do
cp "$filename" "../temp/$filename"
cd ../temp/ || exit
jar -xf "$filename"
cd ../jars || exit
done
rm filelist
cd ../temp || exit
(echo Main-Class: com.juliar.JuliarCompiler)>manifest.txt
rm *.jar
cp -r ../out/com .
cp ../src/com/juliar/gui/juliar.fxml ../temp/com/juliar/gui/juliar.fxml
cp ../src/com/juliar/gui/packages.fxml ../temp/com/juliar/gui/packages.fxml
cp ../src/com/juliar/gui/juliar.css ../temp/com/juliar/gui/juliar.css
cp ../src/com/juliar/gui/juliarFutureIcon.png ../temp/com/juliar/gui/juliarFutureIcon.png
cp ../src/com/juliar/gui/whitelogo.png ../temp/com/juliar/gui/whitelogo.png
cp ../src/com/juliar/gui/Montserrat-Regular.ttf ../temp/com/juliar/gui/Montserrat-Regular.ttf
cp ../src/com/juliar/gui/Montserrat-Bold.ttf ../temp/com/juliar/gui/Montserrat-Bold.ttf
jar cvfm JuliarCompiler.jar manifest.txt com org javax 
mv JuliarCompiler.jar ../JuliarCompiler.jar
cd ..
rm -rf temp
chmod 777 JuliarCompiler.jar
java -jar JuliarCompiler.jar test.jrl
