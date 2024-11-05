# Gestion de Formation

Ce projet est une API RESTful pour la gestion des formations, des apprenants, des formateurs, et des classes. Il permet d'effectuer des opérations CRUD (Créer, Lire, Mettre à jour, Supprimer) sur les entités tout en intégrant la pagination et la gestion des relations entre apprenants, formateurs, classes et formations.

## Table des Matières

### Technologies Utilisées

### Structure du Projet

### Installation

### Endpoints de l'API

### Exemples de Requêtes avec Postman

### Contributions

### Technologies Utilisées

- Java 17
- Spring Boot 3.x (Spring MVC, Spring Data JPA, Spring Validation)
- Hibernate pour l'ORM
- Base de données PostgreSQL
- Lombok pour la réduction du code boilerplate
- Postman pour le test des endpoints
- Maven pour la gestion des dépendances

### Structure du Projet

Le projet suit une architecture en couches pour une séparation claire des responsabilités.

```
📂 src
└── 📂 main
├── 📂 java
│   └── 📂 com.yassine.Gestion_Formation
│       ├── 📂 controller        # Contrôleurs REST pour chaque ressource
│       │   ├── ApprenantController.java
│       │   ├── ClasseController.java
│       │   ├── FormateurController.java
│       │   └── FormationController.java
│       │
│       ├── 📂 service           # Services contenant la logique métier
│       │   ├── 📂 implementation  # Implémentations des services
│       │   │   ├── ApprenantServiceImpl.java
│       │   │   ├── ClasseServiceImpl.java
│       │   │   ├── FormateurServiceImpl.java
│       │   │   └── FormationServiceImpl.java
│       │   └── 📂 Interface       # Interfaces de services
│       │   │   └── IGeneralService.java
│       ├── 📂 repository       # Accès aux données, avec JPA Repositories pour chaque entité
│       │   │   ├── ApprenantRepository     .java
│       │   │   ├── ClasseRepository.java
│       │   │   ├── FormateurRepository.java
│       │   │   └── FormationRepository.java
│       ├── 📂 model            # Entités JPA représentant les tables de la base de données
│       │   ├── Classe.java
│       │   ├── Apprenant.java
│       │   ├── Formateur.java
│       │   └── Formation.java
│       └── 📂 exception        # Gestion des erreurs personnalisées
│
└── 📂 resources                 # Fichiers de configuration
├── application.properties   # Configuration de la base de données
```

### Diagramme de classe
![ClassDiagram1.png](..%2F..%2FDocuments%2FGestion%20de%20formation%2FClassDiagram1.png)
### Installation

Clonez le repository :

```
git clone https://github.com/username/Gestion_Formation.git
```

```
cd Gestion_Formation
```

Configurez la base de données PostgreSQL : Assurez-vous que PostgreSQL est installé et créez une base de données :

CREATE DATABASE formation_db;
Modifiez les informations de connexion dans application.properties :

- spring.datasource.url=jdbc:postgresql://localhost:5432/formation_db
- spring.datasource.username=yourUsername
- spring.datasource.password=yourPassword

Compilez et exécutez l'application :

```
mvn clean install
```

```
mvn spring-boot:run
```

#### Testez les endpoints dans Postman ou tout autre client HTTP.

Endpoints de l'API
Les principaux endpoints de l'API sont décrits ci-dessous. Tous les endpoints sont paginés (paramètres page et size).

#### Apprenants

- GET /apprenants : Obtenir la liste des apprenants (paginée)
- GET /apprenants/{id} : Obtenir un apprenant par ID
- POST /apprenants : Créer un nouvel apprenant
- PUT /apprenants/{id} : Mettre à jour un apprenant
- DELETE /apprenants/{id} : Supprimer un apprenant

#### Formateurs

- GET /formateurs : Obtenir la liste des formateurs (paginée)
- GET /formateurs/{id} : Obtenir un formateur par ID
- POST /formateurs : Créer un nouveau formateur
- PUT /formateurs/{id} : Mettre à jour un formateur
- DELETE /formateurs/{id} : Supprimer un formateur

#### Classes

- GET /classes : Obtenir la liste des classes (paginée)
- GET /classes/{id} : Obtenir une classe par ID
- POST /classes : Créer une nouvelle classe
- PUT /classes/{id} : Mettre à jour une classe
- DELETE /classes/{id} : Supprimer une classe

#### Formations

- GET /formations : Obtenir la liste des formations (paginée)
- GET /formations/{id} : Obtenir une formation par ID
- POST /formations : Créer une nouvelle formation
- PUT /formations/{id} : Mettre à jour une formation
- DELETE /formations/{id} : Supprimer une formation

#### Recherche par Nom

- GET /apprenants/search?nom={nom} : Rechercher des apprenants par nom
- GET /formateurs/search?nom={nom} : Rechercher des formateurs par nom
- GET /classes/search?nom={nom} : Rechercher des classes par nom
- GET /formations/search?nom={nom} : Rechercher des formations par nom

### Exemples de Requêtes avec Postman

1. Créer un Formateur
   POST http://localhost:8080/formateurs/add

-

```
{
    "prenom" : "Test",
    "nom" : "test",
    "email" : "test@gmail.com",
    "specialite" : "Full Stack",
    "classe" : {
        "id" : 1
    },
    "formation" : {
        "id" : 1
    }
}
```

2. Obtenir tous les Apprenants (avec Pagination)

   GET http://localhost:8080/apprenants/list?page=0&size=5

Réponse :

-

```
{
    "content": [
        {
            "id": 2,
            "nom": "test",
            "prenom": "Youness",
            "email": "youness@gmail.com",
            "niveau": "1eme année",
            "classeNom": "Classe1",
            "formationNom": "Youcode"
        },
        {
            "id": 3,
            "nom": "Hanach",
            "prenom": "Yassine",
            "email": "yassine.hanach02@gmail.com",
            "niveau": "2eme année",
            "classeNom": "Classe2",
            "formationNom": "Youcode"
        },
        {
            "id": 4,
            "nom": "Akil",
            "prenom": "SalahEddine",
            "email": "akilsalah101@gmail.com",
            "niveau": "2eme année",
            "classeNom": "Classe2",
            "formationNom": "Youcode"
        },
        {
            "id": 5,
            "nom": "Talemssi",
            "prenom": "Abdellah",
            "email": "abdellah@gmail.com",
            "niveau": "2eme année",
            "classeNom": "Classe2",
            "formationNom": "Youcode"
        },
        {
            "id": 6,
            "nom": "Belhassan",
            "prenom": "Anour",
            "email": "belhassan@gmail.com",
            "niveau": "2eme année",
            "classeNom": "Classe2",
            "formationNom": "Youcode"
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 5,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": false,
    "totalPages": 2,
    "totalElements": 6,
    "size": 5,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 5,
    "empty": false
}
```

3. Rechercher une Classe par Nom :

   GET http://localhost:8080/classes/search?nom=Classe2

Réponse :
```
{
    "id": 2,
    "nom": "Classe2",
    "numSalle": "20",
    "apprenants": [
        {
            "id": 3,
            "nom": "Hanach",
            "prenom": "Yassine",
            "email": "yassinedubraska@gmail.com",
            "niveau": "2eme année",
            "classeNom": "Classe2",
            "formationNom": "Youcode"
        }
    ],
    "formateur": {
        "id": 8,
        "nom": "Abouabdelmajid",
        "prenom": "Khalil",
        "email": "khalilabouabdelamajid@gmail.com",
        "specialite": "Full Stack",
        "formationId": 2,
        "classeNumSalle": "20",
        "classeNom": "Classe2",
        "formationNom": "Youcode"
    }
}
```
### Contributions
Les contributions sont les bienvenues ! Veuillez suivre les étapes ci-dessous pour proposer des modifications :

- Forkez le projet
- Créez une branche pour votre fonctionnalité ``git checkout -b nouvelle-fonctionnalite``
- Commitez vos modifications ``git commit -am 'Ajouter une nouvelle fonctionnalité'``
- Poussez sur la branche ```git push origin nouvelle-fonctionnalite```
- Créez une Pull Request
### Auteur

Yassine Hanach
- GitHub: [https://github.com/Yassinean](https://github.com/Yassinean)