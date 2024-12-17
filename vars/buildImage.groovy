#!/usr/bin/env groovy
def call() {
    echo "Building the Docker Image..."
    withCredentials([usernamePassword(credentialsId: 'Docker-Auth', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t tahasyed19/tahasyed:1.1.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push tahasyed19/tahasyed:1.1.1'
    }
}