pipeline {
    
    agent any

    environment {
        CI = 'true'
    }

    stages {
        stage('Build') { 
            steps {
                bat 'npm install' 
            }
        }

        stage('Deploy') { 
            steps {
                bat 'npm start' 
            }
        }
    }
}