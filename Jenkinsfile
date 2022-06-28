pipeline {
    agent any

    stages {
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

