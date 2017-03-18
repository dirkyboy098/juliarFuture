#!/bin/sh
export CLASSPATH="jars/antlr-4.6-complete.jar:jars/nirerepl.jar:jars/asm-all-6.0_ALPHA.jar:jars/fastcgi.jar:out"

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
jar cvfm JuliarCompiler.jar manifest.txt com org javax antlr icons properties templates
mv JuliarCompiler.jar ../JuliarCompiler.jar
cd ..
rm -rf temp
java -jar JuliarCompiler.jar test.jrl
