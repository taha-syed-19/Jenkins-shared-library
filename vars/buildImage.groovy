#!/usr/bin/env groovy
def call(String imageName) {
    echo "Building the Docker Image in branch $BRANCH_NAME"
    withCredentials([usernamePassword(credentialsId: 'Docker-Auth', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh "docker build -t $imageName ."
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
        sh "docker push $imageName"
    }
}
