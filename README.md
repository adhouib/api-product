### Microservice de Gestion de Produits

#### Contexte : Vous travaillez pour une entreprise de commerce en ligne et on vous charge de développer un microservice pour gérer l'inventaire des produits.

#### Objectif : Construire un microservice en utilisant Spring Boot qui expose une API REST pour ajouter, supprimer, mettre à jour et récupérer des informations sur les produits.

#### Contraintes :

##### Configuration du projet :
Créez un projet Spring Boot avec les dépendances nécessaires (Spring Web, Spring Data JPA, H2 Database).

##### Définition du modèle de données :
Définissez une entité Produit avec les attributs suivants : id (clé primaire), nom, quantité en stock, et prix.

##### Création des API REST : 
Développez un contrôleur REST avec les endpoints nécessaire pour effectuer les opérations suivantes :

* Ajouter un nouveau produit.
* Récupérer la liste de tous les produits.
* Récupérer un produit spécifique par son ID.
* Mettre à jour un produit existant.
* Supprimer un produit >> sécuriser cette partie avec une authentification basic

### Lancement 
le repertoire ressource contient deux fichiers: le premier est une collection d'appel et le deuxieme servira pour la configuration des variables d'environnement.
Importez les deux fichier et lancez l'application Spring boot 
