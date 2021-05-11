pipeline {
//     agent none
    agent {
                docker { image 'maven:3.3.3' }
    }
    triggers{
        pollSCM('*/15 * * * *')
    }
    stages {
        stage('build') {
            steps {
                sh 'mvn package'
            }
        }
        stage('test') {
                    steps {
                        sh 'mvn test'
                    }
        }
        stage('push build') {
                    steps {
                        sh 'mvn spring-boot:build-image'
         }
        }
    }
}