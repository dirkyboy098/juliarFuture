SET jloc=C:\Users\AndreiM\Desktop
set CLASSPATH=%jloc%\juliarFuture\jars\antlr-4.5.3-complete.jar;%CLASSPATH%
java org.antlr.v4.Tool %jloc%\juliarFuture\src\com\juliar\parser\juliar.g4  -o %jloc%\juliarFuture\src\com\juliar\parser -no-listener -package com.juliar.parser -visitor