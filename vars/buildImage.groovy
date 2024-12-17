#!/usr/bin/env groovy
def call(String imageName) {
    echo "Building the Docker Image in branch $BRANCH_NAME"
    withCredentials([usernamePassword(credentialsId: 'Docker-Auth', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push $imageName"
    }
}
