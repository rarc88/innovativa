# Usamos una imagen base de ubuntu 18.04 ya que es en la que desarrollamos normalmente
FROM    ubuntu:18.04

# Actualizamos el sistema he instalamos los paquetes necesarios
RUN     apt-get update
RUN     apt-get install -y zip wget nano openjdk-8-jdk
RUN     apt-get install -y ant

# Creamos un usuario para ejecutar tomcat y ant
RUN     useradd -G root,root -u 1000 -d /home/openbravo openbravo

# Descargamos tomcat y lo ubicamos en /opt
RUN     cd /tmp &&\
        wget https://apache.ups.edu.ec/dist/tomcat/tomcat-8/v8.5.54/bin/apache-tomcat-8.5.54.zip &&\
        unzip apache-tomcat-8.5.54.zip && rm apache-tomcat-8.5.54.zip && mv apache-tomcat-8.5.54 /opt/tomcat

# Actualizamos el propietario y permisos de /opt
RUN     mkdir -p /opt/innovativa && chmod -R 755 /opt && chown -R openbravo /opt

# Cambiamos al usuario openbravo
USER    openbravo
# Y configuramos las variables de entorno
ENV     JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
ENV     CATALINA_OPTS="-server -Djava.awt.headless=true -Xms384M -Xmx1024M"
ENV     CATALINA_BASE=/opt/tomcat
ENV     CATALINA_HOME=/opt/tomcat

# Comando que se ejecuta por defecto al iniciar el contenedor
CMD     /opt/tomcat/bin/catalina.sh run