## Titre du Projet: Demo JPA

Ce dépôt est dédié à l'exploration et à la compréhension des fonctionnalités principales de Java Persistence API (JPA). Le projet est construit en utilisant Java, Spring Boot, et Maven.

## Commencer

Ces instructions vous permettront d'obtenir une copie du projet en fonctionnement sur votre machine locale à des fins de développement et de tests.

### Prérequis

- Java 8 ou supérieur
- Maven
- MySQL

### Installation

1. Clonez le dépôt
2. Naviguez jusqu'au répertoire du projet
3. Exécutez `mvn clean install` pour construire le projet

## Exécution de l'Application

Vous pouvez exécuter l'application en utilisant la commande `mvn spring-boot:run`. L'application commencera à fonctionner à `http://localhost:8082`.

## Construit Avec

- [Java](https://www.java.com/) - Le langage de programmation utilisé
- [Spring Boot](https://spring.io/projects/spring-boot) - Le framework utilisé pour créer des applications Spring autonomes de qualité production
- [Maven](https://maven.apache.org/) - Gestion des dépendances

## Caractéristiques

Le projet démontre les fonctionnalités suivantes de JPA :

- Création d'entité : La classe `Patient` est annotée avec `@Entity`, indiquant qu'il s'agit d'une entité JPA.
- Génération de clé primaire : Le champ `id` dans la classe `Patient` est annoté avec `@Id` et `@GeneratedValue`, indiquant qu'il s'agit de la clé primaire et que sa valeur est générée automatiquement.
- Création de requête : L'interface `PatientRepository` étend `JpaRepository`, fournissant plusieurs méthodes pour interroger la base de données.
- Création de requête personnalisée : La méthode `chercherPatient` dans l'interface `PatientRepository` démontre comment créer des requêtes personnalisées en utilisant l'annotation `@Query`.

## Auteurs
YassinMk
