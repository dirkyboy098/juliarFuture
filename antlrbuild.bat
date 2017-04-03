set CLASSPATH=D:\source\juliarFuture\jars\antlr-4.6-complete.jar;%CLASSPATH%
java org.antlr.v4.Tool D:\source\juliarFuture\src\com\juliar\parser\Juliar.g4  -o D:\source\juliarFuture\src\com\juliar\parser -no-listener -package com.juliar.parser -visitor
