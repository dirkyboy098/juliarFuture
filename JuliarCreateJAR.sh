export CLASSPATH="jars/antlr-4.6-complete.jar:jars/nirerepl.jar:jars/asm-all-6.0_ALPHA.jar:out"

mkdir temp

cd jars
ls -1 *.jar > filelist

for filename in `cat filelist`
do
cp $filename ../temp/$filename
cd ../temp/
jar -xf $filename
cd ../jars
done
rm filelist
cd ../temp
(echo Main-Class: com.juliar.JuliarCompiler)>manifest.txt
rm *.jar
cp -r ../out/com .
jar cvfm JuliarCompiler.jar manifest.txt com org javax antlr icons properties templates
mv JuliarCompiler.jar ../JuliarCompiler.jar
cd ..
rm -rf temp






