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
set CLASSPATH=jars\antlr-4.7-complete.jar;out

rmdir /s /q out
rmdir /s /q temp

mkdir out
mkdir temp

java org.antlr.v4.Tool src\com\juliar\parser\Juliar.g4 -no-listener -package com.juliar.parser -visitor
javac -Xlint -d out -sourcepath src -g -encoding UTF-8 -source 8 -target 8 src\com\juliar\JuliarAndroid.java

(echo Main-Class: com.juliar.JuliarAndroid)>temp\manifest.txt
cd temp
jar xf ..\jars\antlr-4.7-complete.jar
cd ..
xcopy /e /v out temp
cd temp
jar cvfm JuliarAndroidLib.jar manifest.txt com org javax
cd ..
copy temp\JuliarAndroidLib.jar JuliarAndroidLib.jar

rd temp /s/q

set CLASSPATH=
