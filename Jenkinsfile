pipeline {
    agent any

    stages {
        stage('build') {
            tools {
                   jdk "openJDK11"
                }    
            steps {
                sh '''#!/bin/bash
                
                pwd
                cd narayana
                export JAVA_HOME=/usr/lib/jvm/java-11-openjdk
                ./build.sh -Pcommunity -Prelease clean install -DskipTests
                '''
            }
        }
        stage('Sonarqube') {
            environment {
                scannerHome = tool 'SonarQubeScanner'
            }    
            steps {
                withSonarQubeEnv("Red Hat's SonarQube Server") {
                    sh "${scannerHome}/bin/sonar-scanner"
                }        
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}

