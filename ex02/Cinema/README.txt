Download tomcat https://tomcat.apache.org/download-90.cgi
Run command: mvn clean package
Copy war from target folder to Tomcat/webapps
Run command: /bin/catalina.sh run in tomcat folder


mvn clean install org.codehaus.cargo:cargo-maven2-plugin:run
