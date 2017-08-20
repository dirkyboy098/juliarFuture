@echo off
java -v >nul 2>&1
if errorlevel 9009 if not errorlevel 9010 (
@echo on
echo 'java' is not defined. Please make sure you have installed JDK w/ JRE and that 'java' is in the PATH.
timeout 15
EXIT /B 1
)
set CLASSPATH=jars\antlr-4.6-complete.jar;
java org.antlr.v4.Tool src\com\juliar\parser\Juliar.g4 -no-listener -package com.juliar.parser -visitor
