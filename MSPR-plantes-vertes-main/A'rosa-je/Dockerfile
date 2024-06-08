# Utilisation de l'image openjdk 11
FROM openjdk:11

# Définition de variables d'environnement
ENV ANDROID_HOME /opt/android-sdk-linux
ENV PATH ${PATH}:${ANDROID_HOME}/tools:${ANDROID_HOME}/platform-tools

# Installation des dépendances nécessaires
RUN apt-get update && \
    apt-get install -y wget unzip && \
    wget -q https://dl.google.com/android/repository/commandlinetools-linux-7583922_latest.zip -O /tmp/tools.zip && \
    mkdir -p ${ANDROID_HOME}/cmdline-tools && \
    unzip /tmp/tools.zip -d ${ANDROID_HOME}/cmdline-tools && \
    rm /tmp/tools.zip && \
    yes | ${ANDROID_HOME}/cmdline-tools/tools/bin/sdkmanager --licenses && \
    ${ANDROID_HOME}/cmdline-tools/tools/bin/sdkmanager "platforms;android-33" "build-tools;33.0.0" "extras;google;m2repository" && \
    apt-get purge -y wget unzip && \
    apt-get autoremove -y && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*

# Installation de la librairie Google Volley
RUN wget -q https://github.com/google/volley/archive/master.zip -O /tmp/volley.zip && \
    unzip /tmp/volley.zip -d /opt && \
    rm /tmp/volley.zip

# Copie du code source de l'application dans le conteneur
COPY . /app

# Compilation de l'application
RUN cd /app && \
    ./gradlew assembleDebug

# Exposition du port utilisé par l'application
EXPOSE 8080

# Commande de démarrage de l'application
CMD ["java", "-jar", "/app/build/outputs/apk/debug/app-debug.apk"]
