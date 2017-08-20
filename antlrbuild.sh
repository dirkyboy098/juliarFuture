#!/bin/sh
export CLASSPATH="$CLASSPATH:jars/antlr-4.6-complete.jar"
if ! [$(which java)]; then
   echo 'java' is not defined. Please make sure you have installed JDK w/ JRE and that 'java' is in the PATH.
   exit 1
fi
java org.antlr.v4.Tool src/com/juliar/parser/Juliar.g4 -o . -no-listener -package com.juliar.parser -visitor
