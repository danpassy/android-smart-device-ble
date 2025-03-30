# AndroidSmartDevice

## Description
AndroidSmartDevice est une application Android développée pour faciliter la communication et la gestion des appareils Bluetooth Low Energy (BLE). L'application permet aux utilisateurs de scanner, se connecter, et interagir avec des appareils BLE à proximité.

## Fonctionnalités

- **Scan des appareils BLE** : Permet aux utilisateurs de découvrir des appareils BLE à proximité.
- **Connexion aux appareils BLE** : Les utilisateurs peuvent se connecter à un appareil BLE pour interagir davantage.
- **Contrôle des LEDs** : Une fois connecté, l'utilisateur peut allumer et éteindre les LEDs sur l'appareil BLE.
- **Notifications** : Abonnement aux notifications des boutons sur l'appareil BLE pour recevoir des mises à jour en temps réel.

## Architecture du Projet

Le projet utilise l'architecture MVVM pour la séparation des préoccupations et une meilleure gestion du code. Les principales activités incluent :

- `MainActivity` : Point d'entrée de l'application où les utilisateurs peuvent commencer le processus de scan.
- `ScanActivity` : Activité pour scanner les appareils BLE.
- `DeviceActivity` : Activité pour se connecter et interagir avec un appareil BLE spécifique.

## Technologies Utilisées

- **Kotlin** : Langage de programmation principal pour le développement Android.
- **Android Studio** : Environnement de développement intégré (IDE) pour le développement Android.
- **Material Design** : Bibliothèque de design utilisée pour les interfaces utilisateur.
- **Bluetooth API** : API Android pour la gestion des communications Bluetooth.

## Configuration Requise

- **Android SDK** : Version 21 (Lollipop) ou supérieure.
- **Gradle** : Compatible avec la version utilisée par Android Studio pour la construction du projet.

## Installation

Pour exécuter ce projet, suivez ces étapes :

1. Clonez le dépôt Git :
   ```
   git clone https://github.com/danpassy/android-smart-device-ble.git
   ```
2. Ouvrez le projet dans Android Studio.
3. Connectez un appareil Android ou configurez un émulateur.
4. Exécutez l'application via Android Studio.

## Contribution

Les contributions à ce projet sont bienvenues. Si vous souhaitez contribuer, veuillez fork le dépôt, créer une branche de fonctionnalité, et soumettre une pull request.

## Licence

Ce projet est sous licence MIT. Voir le fichier `LICENSE.md` pour plus de détails.
