pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
            echo "Checkout"
//                 git 'https://github.com/yourusername/your-spring-boot-project.git'
            }
        }
        stage('Build') {
            steps {
             echo "Build"
//                 sh 'mvn clean package'
            }
        }
        stage('Test') {
            steps {
             echo "Test"
//                 sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                // You can add deployment steps here, like copying the built artifact to a server
            }
        }
    }
}