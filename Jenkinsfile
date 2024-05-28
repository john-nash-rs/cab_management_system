pipeline {
    agent any
    tools {
        maven 'MAVEN_JENKINS'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install -DskipTests'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                // Add your deployment script/commands here
            }
        }
    }
}
