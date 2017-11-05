taskkill /im java.exe /F
taskkill /im nginx.exe /F

call BuildEverything.bat
cd web
LaunchFCGI.bat