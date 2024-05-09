pipeline {
    agent any

    tools {
            // Define the Maven tool to be used in the pipeline
            maven 'maven'
        }

    stages {

    stage('Debug') {
        steps {
            sh 'git ls-remote https://github.com/LearnCodeWithDurgesh/boot-video-stream.git'
        }
    }
        stage('Checkout') {
            steps {
                // Checkout the code from your Git repository
                 git branch: 'main', url: 'https://github.com/LearnCodeWithDurgesh/boot-video-stream.git'

            }
        }

        stage('Build') {
            steps {
                // Build the Spring Boot application using Maven
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                // Run tests for the Spring Boot application
                sh 'mvn test'
            }
        }

        stage('Deploy') {
            steps {
            echo 'deploying...'
                // Example deployment step: Copy the built artifact (JAR file) to a server
               // sh 'scp target/your-spring-boot-project.jar username@server:/path/to/deploy'

                // Example restart command for the application server
                //sh 'ssh username@server "sudo systemctl restart your-application-service"'
            }
        }
    }

    post {
        success {
            // If the pipeline runs successfully, print a success message
            echo 'Pipeline completed successfully! Your Spring Boot application is deployed.'
        }
        failure {
            // If the pipeline fails, print an error message
            echo 'Pipeline failed! Check the logs for details.'
        }
    }
}
