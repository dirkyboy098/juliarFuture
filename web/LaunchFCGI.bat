taskkill /im java.exe /F
taskkill /im nginx.exe /F

cd ..
start cmd.exe /C java -jar -DFCGI_PORT=9000 JuliarCompiler.jar
cd C:\nginx\
start nginx.exe
