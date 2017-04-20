set JULIARPATH=%cd%

set CLASSPATH=%JULIARPATH%\jars\antlr-4.6-complete.jar;%CLASSPATH%
java org.antlr.v4.Tool %JULIARPATH%\src\com\juliar\parser\Juliar.g4  -o %JULIARPATH%\src\com\juliar\parser -no-listener -package com.juliar.parser -visitor