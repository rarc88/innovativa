pipeline {
    agent {
        docker {
            image 'innovativa'
            args '-p 8084:8080'
        }
    }
    environment {
        CI = 'true'
    }
    stages {
        stage('Build') {
            steps {
                sh 'ant smartbuild'
            }
        }
        // stage('Test') {
        //     steps {
        //         sh './jenkins/scripts/test.sh'
        //     }
        // }
        // stage('Deliver') {
        //     steps {
        //         sh './jenkins/scripts/deliver.sh'
        //         input message: 'Finished using the web site? (Click "Proceed" to continue)?'
        //         sh './jenkins/scripts/kill.sh'
        //     }
        // }
    }
}
