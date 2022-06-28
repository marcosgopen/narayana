pipeline {
    agent any

    stages {
        stage('Sonarqube') {
            environment {
                scannerHome = tool 'sonar'
            }    
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh "${scannerHome}/bin/sonar-scanner"
                }        
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}

