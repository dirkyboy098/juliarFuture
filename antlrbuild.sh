export CLASSPATH="$CLASSPATH:jars/antlr-4.5.3-complete.jar"
#alias antlr4='java -jar /Users/donreamey/github/juliarFuture/jars/antlr-4.5.3-complete.jar -o /src/com/juliar/parse -no-listener -package com.juliar.parser -visitor'
java org.antlr.v4.Tool src/com/juliar/juliargrammar.g4 -o . -no-listener -package com.juliar -visitor

