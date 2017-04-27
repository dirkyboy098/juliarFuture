#!/bin/sh
export CLASSPATH="jars/antlr-4.6-complete.jar:jars/nirerepl.jar:jars/asm-all-6.0_ALPHA.jar:jars/richtextfx-fat-0.7-M5.jar:jars/fastcgi.jar:out"

rm -rf out
mkdir out
java org.antlr.v4.Tool src/com/juliar/parser/Juliar.g4  -o . -no-listener -package com.juliar.parser -visitor
javac -d out -sourcepath src -g -encoding UTF-8 -source 8 -target 8 src/com/juliar/JuliarCompiler.java -verbose


mkdir temp

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
rm "*.jar"
cp -r ../out/com .
cp ../src/com/juliar/gui/juliar.fxml ../temp/com/juliar/gui/juliar.fxml
cp ../src/com/juliar/gui/juliar.css ../temp/com/juliar/gui/juliar.css
cp ../src/com/juliar/gui/juliarFutureIcon.png ../temp/com/juliar/gui/juliarFutureIcon.png
cp ../src/com/juliar/gui/Montserrat-Regular.ttf ../temp/com/juliar/gui/Montserrat-Regular.ttf
jar cvfm JuliarCompiler.jar manifest.txt com org javax antlr icons properties templates
mv JuliarCompiler.jar ../JuliarCompiler.jar
cd ..
rm -rf temp
java -jar JuliarCompiler.jar test.jrl
