Un projet from scratch spring boot, mongodb, java 8, Cucumber, maven, testNG
environnement 
- installer java 8 et une base de donnée mongoDB
- exécuter la commande  mvn spring-boot:run pour lancer l'api
- exécuter la commande mvn clean test pour lancer le test
- J'ai exposé deux services avec spring boot: utilisateur et abonné
-Pour accéder au service utilisateur il faut utiliser l'url http://localhost:8080/api/v1/users
.http://localhost:8080/api/v1/users/ pour créer un utilisateur avec la requête post {username: "texte", password:"votre mot de passe"}
.http://localhost:8080/api/v1/users/  avec get pour recuperer la liste des users
.http://localhost:8080/api/v1/users/id en get pour recuperer un utilisateur par son id
.http://localhost:8080/api/v1/users/id en delete  pour supprimer un utilisateur 
Pour accéder au service abonné il faut utiliser l'url http://localhost:8080/api/v1/subscribers


