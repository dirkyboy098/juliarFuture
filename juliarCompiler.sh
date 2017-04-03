#!/bin/sh
export CLASSPATH="jars/antlr-4.6-complete.jar:jars/nirerepl.jar:jars/asm-all-6.0_ALPHA.jar:jars/fastcgi.jar:out"
java com.juliar.JuliarCompiler test.jrl . false false

