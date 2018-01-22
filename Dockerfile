FROM jenkins/jenkins:lts

COPY ./jenkins.install.UpgradeWizard.state /usr/share/jenkins/
COPY ./basic-security.groovy /usr/share/jenkins/ref/init.groovy.d/
