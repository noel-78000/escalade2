## site web escalade

## comment compiler

* __installer maven & mysql sur votre systeme__<br/>
  aide en ligne ici:<br/>
  https://maven.apache.org/install.html<br/>
  https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/<br/>

* __créer la base de donnée__<br />
  en lançant dans workbench le fichier create.sql du projet<br/>
  éventuellement vous pouvez créer qques données par le fichier populate.sql du projet<br/>

* __creer un repertoire conf sur votre systeme__<br />
  mkdir /usr/local/conf<br/>
  dans lequel sera placé vos fichiers de configuration<br/>
  lesquels seront installés automatiquement par maven<br/>
  vous pouvez les modifier si besoin, ex: pour l'acces mysql<br/>

* __compiler:__<br/>
  mvn clean install -PprodEnv<br />

* __lancer l'application:__<br/>
  dans Tomcat, lien ici: https://tomcat.apache.org/tomcat-8.5-doc/deployer-howto.html<br/>
  dans le fichier setclasspath.sh exporter le repertoire de configuration:<br/>
  en rajoutant au début la ligne: export CLASSPATH=/usr/local/conf<br/>
  lancer tomcat par bin/startup.sh<br/>
  taper l'url dans le navigateur http://localhost:8080/escalade2