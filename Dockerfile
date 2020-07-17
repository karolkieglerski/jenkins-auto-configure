FROM jenkins/jenkins:lts

COPY ./basic-security.groovy /usr/share/jenkins/ref/init.groovy.d/
