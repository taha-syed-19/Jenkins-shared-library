#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {
    def script

    Docker(script) {
        this.script = script

    }

    def buildDockerImage(String imageName) {
        script.echo "Building the Docker Image..."
        script.withCredentials([script.usernamePassword(credentialsId: 'Docker-Auth', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            script.sh 'docker build -t tahasyed19/tahasyed:1.1.1 .'
            script.sh "echo $script.PASSWORD | docker login -u $script.USERNAME --password-stdin"
            script.sh 'docker push tahasyed19/tahasyed:1.1.1'

        }

    }
}