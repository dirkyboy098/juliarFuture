# Juliar.Future Web Component

[![juliarFutureLogo](https://cloud.githubusercontent.com/assets/11934545/21415540/c50c8034-c7d8-11e6-9f76-9b37833e6cae.jpg)](https://www.juliar.org)

# Intro
Juliar.Future can be ran as FastCGI for executing on web. This can be useful for people writing web server programs to execute Juliar Code and provide results on the go.
In order to use FastCGI as service. You must first start FastCGI process and then start the server.
It is recommended to first make sure that server is working and then make sure that the FastCGI results are being processed.
To test, make a simple `index.html` file and put some words into it. Then go to your hostname (http://localhost) and make sure that file outputs something.

# What Web Servers are supported?
Almost any web server is supported as long as it provides some form of FastCGI protocol.
We have provided configurations for Apache, NGINX, and Lighttpd. Every operating system is supported.
We suggest using NGINX with juliar.Future. Although, Apache works very well too.

# Apache
Open up `apache_add_to_httpd.conf` file and follow the instructions

# Nginx
Depending on your system, take the appropriate `nginx_`OS`.conf`
and rename it to `nginx.conf` put the file into appropriate nginx conf
directory. It will ask you to overwrite the file. click yes.

# Lighttpd
Launching lighttpd server is as easy as doing
`lighttpd -D -f lighttpd.conf`
This should start the server.

# Starting FastCGI
Look at `LaunchFCGI.bat` script and `LaunchFCGI.sh` to find out how
to launch JuliarCompiler.jar as FastCGI process. It is very straightforward.
It is as easy as:

`
java -jar -DFCGI_PORT=9000 JuliarCompiler.jar
`
where `-DFCGI_PORT` is the port you want to use for the application.

