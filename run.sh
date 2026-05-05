#!/bin/bash

# Compilation
# javac -d . -cp "./lib/*" src/*.java

# # Exécution (on ajoute :./src pour les ressources)
# java -cp ".:./src:./lib/*" main.Main
mvn clean compile
sleep 3
mvn exec:java -Dexec.mainClass="main.Main"