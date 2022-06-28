    podTemplate {
        node('jnlp-agent') {
            stage('build') {
                tools {
                       jdk "openJDK11"
                    }    
                steps {
                    sh '''#!/bin/bash
                    
                    pwd
                    cd narayana
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



