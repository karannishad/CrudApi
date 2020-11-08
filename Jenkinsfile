pipeline {
    agent any
    triggers{
    pollSCM('*/15 * * * *')
    }
    stage("Test"){
    when{branch "master"}
    steps{
    sh '''
    mvn test
    '''
    }
    }
}