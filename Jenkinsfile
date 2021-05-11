pipeline {
//     agent none
    agent {
                docker {
                    image 'maven:3.3.3'
                    args '-v /var/run/docker.sock:/var/run/docker.sock -v $HOME/.m2:/root/.m2'
            }
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