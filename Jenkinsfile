pipeline {
    agent none
        triggers{
            pollSCM('*/15 * * * *')
        }
    stages {
        stage('build') {
                    agent {
                                docker {
                                    image 'maven:3.3.3'
                                    args '-v /var/run/docker.sock:/var/run/docker.sock -v $HOME/.m2:/root/.m2'
                            }
                    }
                    steps {
                        sh 'mvn package'
                    }
        }
        stage('push build') {
                agent {
                        docker {
                                image 'sonarsource/sonar-scanner-cli:latest'
                                args '--network host '//'-e SONAR_LOGIN="d81cf4f13bc2a0fa5a2f253035861f22ab4edef7"'
                        }
                }
                steps {
                    sh 'sonar-scanner -Dsonar.projectKey=crudapi -Dsonar.java.binaries=**/* -Dsonar.host.url=http://localhost:9000 -Dsonar.login=d81cf4f13bc2a0fa5a2f253035861f22ab4edef7'
                }
        }
    }
}