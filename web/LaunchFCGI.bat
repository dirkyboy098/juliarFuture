taskkill /im java.exe /F
taskkill /im nginx.exe /F

set "mycurrdir=%cd%"

cd ..
if not exist JuliarCompiler.jar (
    echo "ERROR: File JuliarCompiler.jar is not found!!! Cannot Launch!"
    timeout /t 15
    Exit 2
)
start cmd.exe /C java -DFCGI_PORT=9000 -jar JuliarCompiler.jar
cd C:\nginx\
start nginx.exe
cd %mycurrdir%

