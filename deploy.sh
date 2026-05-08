#!/bin/bash

# ====================================================================
# Script de déploiement pour l'application Forage
#
# Ce script effectue les actions suivantes :
# 1. Nettoie le projet et compile le code source.
# 2. Compresse l'application dans un fichier .war.
# 3. Copie le fichier .war dans le répertoire de déploiement de Tomcat.
# ====================================================================



# --- Configuration ---
# !!! MODIFIEZ CETTE LIGNE pour pointer vers votre répertoire Tomcat !!!
TOMCAT_PATH="/home/toky/tomcat"

# Nom du projet (généralement le nom du dossier ou l'artifactId de Maven)
PROJECT_NAME="Forage"

# --- Vérifications ---
# Vérifie si le chemin de Tomcat a été modifié
if [ "$TOMCAT_PATH" == "/path/to/your/tomcat" ]; then
    echo "ERREUR : Veuillez modifier la variable TOMCAT_PATH dans ce script pour indiquer le chemin de votre serveur Tomcat."
    exit 1
fi

# Vérifie si le répertoire webapps de Tomcat existe
if [ ! -d "$TOMCAT_PATH/tomcat-webapps" ]; then
    echo "ERREUR : Le répertoire '$TOMCAT_PATH/tomcat-webapps' est introuvable."
    echo "Veuillez vérifier que TOMCAT_PATH est correctement configuré."
    exit 1
fi

# --- Exécution ---
echo "Lancement du processus de déploiement..."

# 1. Compilation et packaging avec Maven
echo "1/3 - Compilation du projet avec Maven..."
mvn clean package
if [ $? -ne 0 ]; then
    echo "ERREUR : La compilation Maven a échoué."
    exit 1
fi
echo "Compilation terminée avec succès."

# Trouve le nom du fichier .war généré
WAR_FILE=$(find target -maxdepth 1 -name "*.war" | head -n 1)

if [ -z "$WAR_FILE" ]; then
    echo "ERREUR : Aucun fichier .war n'a été trouvé dans le dossier target/."
    exit 1
fi

echo "2/3 - Fichier .war trouvé : $WAR_FILE"

# 3. Copie du .war vers Tomcat
echo "3/3 - Copie de $WAR_FILE vers $TOMCAT_PATH/tomcat-webapps/${PROJECT_NAME}.war..."
cp "$WAR_FILE" "$TOMCAT_PATH/tomcat-webapps/${PROJECT_NAME}.war"
if [ $? -ne 0 ]; then
    echo "ERREUR : La copie vers Tomcat a échoué."
    exit 1
fi

echo "Déploiement terminé avec succès !"
echo "L'application est disponible dans le répertoire tomcat-webapps de Tomcat."

sudo systemctl restart tomcat10
sleep 1

