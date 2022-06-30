    podTemplate {
        node('jnlp-agent') {
            stage('build') {
                tool name: 'openJDK11', type: "jdk"
                      
                    git branch: 'sonarqube', url: 'https://github.com/marcosgopen/narayana'
                    
                    sh '''#!/bin/bash -xe
                    
                    ./build.sh -Pcommunity -Prelease clean install -DskipTests
                    '''
                
            }
            stage('Sonarqube') {
                
                    def scannerHome = tool 'SonarQubeScanner'
                
                    withSonarQubeEnv("Red Hat's SonarQube Server") {
                        sh "${scannerHome}/bin/sonar-scanner"
                    }
                    //this needs a webhook to be configured        
                    //timeout(time: 5, unit: 'HOURS') {
                        //waitForQualityGate abortPipeline: true
                    //}
                
            }
        }
    }



