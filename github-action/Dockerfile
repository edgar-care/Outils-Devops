#######################################
#			SET ENVIRONEMENT		  #
#######################################

FROM ubuntu

USER root

COPY depo-repo/* /test

###########################################
#			INSTALL DOCKER AND NPM		  #
###########################################

RUN apt-get update

RUN apt install -y docker-compose

RUN apt-get install -y \
	apt-transport-https \
	ca-certificates \
 	curl \
 	software-properties-common

 RUN curl -fsSL https://download.docker.com/linux/ubuntu/gpg | gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

RUN echo \
 	"deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu \
 	$(lsb_release -cs) stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null
	
RUN apt-get update

RUN apt-get install -y docker-ce docker-ce-cli containerd.io


# # Télécharger le binaire act depuis GitHub
# RUN curl -sSL https://github.com/nektos/act/releases/download/v0.2.21/act_Linux_x86_64.tar.gz \
#     | tar -xz --strip-components=1 -C /usr/local/bin

# # Définir le répertoire de travail

# # Exécuter act
# CMD ["act", "--help"]



# Mise à jour du système et installation des outils nécessaires
RUN apt-get update && apt-get install -y build-essential curl file git

# Installation de Linuxbrew
RUN /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# Ajout du répertoire Linuxbrew à la variable d'environnement PATH
ENV PATH="/home/linuxbrew/.linuxbrew/bin:${PATH}"

# Exemple d'utilisation de Linuxbrew pour installer un paquet (ex: wget)
RUN brew install act

#RUN brew install wget

# Commande par défaut pour le conteneur
CMD ["/bin/bash"]