wmic Path win32_process Where "CommandLine Like '%%JuliarCompiler.jar%%'" Call Terminate
set CLASSPATH=jars\antlr-4.6-complete.jar;jars\nirerepl.jar;jars\asm-all-6.0_ALPHA.jar;jars\fastcgi.jar;jars\richtextfx-fat-0.7-M5.jar;out

rmdir /s /q out
rmdir /s /q temp

mkdir out
mkdir temp

java org.antlr.v4.Tool src\com\juliar\parser\Juliar.g4 -no-listener -package com.juliar.parser -visitor
javac -Xlint -d out -sourcepath src -g -encoding UTF-8 -source 8 -target 8 src\com\juliar\JuliarCompiler.java

(echo Main-Class: com.juliar.JuliarCompiler)>temp\manifest.txt
cd temp
for /f %%f in ('dir /b ..\jars') do jar xf ..\jars\%%f
cd ..
xcopy /e /v out temp
copy src\com\juliar\gui\juliar.fxml temp\com\juliar\gui\juliar.fxml
copy src\com\juliar\gui\packages.fxml temp\com\juliar\gui\packages.fxml
copy src\com\juliar\gui\juliar.css temp\com\juliar\gui\juliar.css
copy src\com\juliar\gui\juliarFutureIcon.png temp\com\juliar\gui\juliarFutureIcon.png
copy src\com\juliar\gui\whitelogo.png temp\com\juliar\gui\whitelogo.png
copy src\com\juliar\gui\Montserrat-Regular.ttf temp\com\juliar\gui\Montserrat-Regular.ttf
cd temp
jar cvfm JuliarCompiler.jar manifest.txt com org javax antlr
cd ..
copy temp\JuliarCompiler.jar JuliarCompiler.jar

rd temp /s/q

set CLASSPATH=
java -jar JuliarCompiler.jar test.jrl