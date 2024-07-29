pipeline {
    agent any

    stages {
        stage ('Checkout') {
            steps {
                script {
                    echo 'Checking out code...'
                }
            }
        }
        stage('Frontend Build') {
            steps {
                script {
                    echo 'Starting Frontend Build...'
                    echo 'Installing Frontend Dependencies...'
                    echo 'Running Frontend Tests...'
                    echo 'Building Frontend...'
                    echo 'Frontend Build Completed!'
                }
            }
        }
        stage('Backend Build') {
            steps {
                script {
                    echo 'Starting Backend Build...'
                    echo 'Installing Backend Dependencies...'
                    echo 'Running Backend Tests...'
                    echo 'Building Backend...'
                    echo 'Backend Build Completed!'
                }
            }
        }
    }
}