pipeline {
    agent any
    tools {
        maven 'MAVEN_JENKINS'
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'export MAVEN_HOME=/opt/homebrew/Cellar/maven/3.9.6/libexec'
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
