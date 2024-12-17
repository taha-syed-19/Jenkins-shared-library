#!/usr/bin/env groovy
def call() {
    echo "Building the JAR file..."
    sh 'mvn package'
}