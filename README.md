# FrasesCelebres

Para desplegar la aplicación

Crear base de datos frases_celebres

importar tablas de frases_celebres.sql del raiz de la aplicacion

cd carpeta del proyecto 

mysql -u root -p frases_celebres < frases_celebres.sql

Por último realizamos los siguientes comandos

mvn clean

mvn package

mvn install

mvn tomee:run

Una vez arrancamos el servidor embebido tomme, nos iremos al navegador y colocaremos la siguiente direccion

http://localhost:8084/JSFMavenEstadio2/
