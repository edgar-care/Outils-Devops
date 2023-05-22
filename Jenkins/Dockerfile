#######################################
#			SET ENVIRONEMENT		  #
#######################################

FROM jenkins/jenkins

USER root

ENV JAVA="-Djenkins.install.runSetupWizard=false"


###################################
#			INSTALL JENKINS		  #
###################################

RUN apt-get update && apt-get install -y lsb-release

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt

RUN jenkins-plugin-cli --clean-download-directory --list --view-security-warnings -f /usr/share/jenkins/ref/plugins.txt

COPY jenkins-config.yml /usr/share/jenkins/ref/jenkins-config.yml

COPY job_dsl.groovy /usr/local/job_dsl.groovy

USER root

ENV CASC_JENKINS_CONFIG /usr/share/jenkins/ref/jenkins-config.yml

USER root