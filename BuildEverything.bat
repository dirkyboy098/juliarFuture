REM Modify JULIARPATH to the directory JuliarFuture is in.
set JULIARPATH=%cd%


REM DO NOT MODIFY ANYTHING BELOW THIS COMMENT


set CLASSPATH=%JULIARPATH%\jars\antlr-4.6-complete.jar;%JULIARPATH%\jars\nirerepl.jar;%JULIARPATH%\jars\asm-all-6.0_ALPHA.jar;%JULIARPATH%\jars\fastcgi.jar;%JULIARPATH%\out

rmdir /s /q %JULIARPATH%\out
mkdir %JULIARPATH%\out
java org.antlr.v4.Tool %JULIARPATH%\src\com\juliar\parser\Juliar.g4  -o %JULIARPATH%\src\com\juliar\parser -no-listener -package com.juliar.parser -visitor
javac -d %JULIARPATH%\out -sourcepath %JULIARPATH%\src -g -encoding UTF-8 -source 8 -target 8 %JULIARPATH%\src\com\juliar\JuliarCompiler.java


mkdir %JULIARPATH%\temp
cd %JULIARPATH%\temp
(echo Main-Class: com.juliar.JuliarCompiler)>%JULIARPATH%\temp\manifest.txt
for /f %%f in ('dir /b %JULIARPATH%\jars') do jar xf %JULIARPATH%\jars\%%f
xcopy /e /v %JULIARPATH%\out %JULIARPATH%\temp
copy %JULIARPATH%\src\com\juliar\gui\juliar.fxml %JULIARPATH%\temp\com\juliar\gui\juliar.fxml
jar cvfm JuliarCompiler.jar manifest.txt com org javax antlr icons properties templates
copy %JULIARPATH%\temp\JuliarCompiler.jar  %JULIARPATH%\JuliarCompiler.jar

cd %JULIARPATH%
rd %JULIARPATH%\temp /s/q

set CLASSPATH=
java -jar JuliarCompiler.jar test.jrl