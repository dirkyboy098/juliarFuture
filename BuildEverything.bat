@echo off
java -v >nul 2>&1
if errorlevel 9009 if not errorlevel 9010 (
@echo on
echo 'java' is not defined. Please make sure you have installed JDK w/ JRE and that 'java' is in the PATH.
timeout 15
EXIT /B 1
)

javac >nul 2>&1
if errorlevel 9009 if not errorlevel 9010 (
@echo on
echo 'javac' is not defined. Please make sure you have installed JDK and that 'javac' is in the PATH.
timeout 15
EXIT /B 1
)

jar >nul 2>&1
if errorlevel 9009 if not errorlevel 9010 (
@echo on
echo 'jar' is not defined. Please make sure you have installed JDK and 'JAR.exe' is in the PATH.
timeout 15
EXIT /B 1
)
@echo on

wmic Path win32_process Where "CommandLine Like '%%JuliarCompiler.jar%%'" Call Terminate
set CLASSPATH=jars\antlr-4.7-complete.jar;jars\nirerepl.jar;jars\asm-all-6.0_BETA.jar;jars\fastcgi.jar;jars\richtextfx-fat-0.7-M5.jar;out

rmdir /s /q out
rmdir /s /q temp

mkdir out
mkdir temp

java org.antlr.v4.Tool src\com\juliar\parser\Juliar.g4 -no-listener -package com.juliar.parser -visitor
javac -Xlint -d out -sourcepath src -g -encoding UTF-8 -source 8 -target 8 src\com\juliar\JuliarCompiler.java
copy src\com\juliar\gui\juliar.fxml out\com\juliar\gui\juliar.fxml
copy src\com\juliar\gui\packages.fxml out\com\juliar\gui\packages.fxml
copy src\com\juliar\gui\juliar.css out\com\juliar\gui\juliar.css
copy src\com\juliar\gui\juliarFutureIcon.png out\com\juliar\gui\juliarFutureIcon.png
copy src\com\juliar\gui\whitelogo.png out\com\juliar\gui\whitelogo.png
copy src\com\juliar\gui\Montserrat-Regular.ttf out\com\juliar\gui\Montserrat-Regular.ttf
copy src\com\juliar\gui\Montserrat-Bold.ttf out\com\juliar\gui\Montserrat-Bold.ttf

(echo Main-Class: com.juliar.JuliarCompiler)>temp\manifest.txt
cd temp
for /f %%f in ('dir /b ..\jars') do jar xf ..\jars\%%f
cd ..
xcopy /e /v out temp
cd temp
jar cvfm JuliarFuture.jar manifest.txt com org javax
cd ..
copy temp\JuliarFuture.jar JuliarFuture.jar

rd temp /s/q

set CLASSPATH=
java -jar JuliarFuture.jar test.jrl