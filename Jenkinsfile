pipeline {
    agent any  // Use any available Jenkins agent

    stages {
        stage('Clone repository') {
            steps {
                // Pull the repository that contains the Dockerfile
                git 'https://github.com/mishraashish084/product-microservice-use-Docker.git'
            }
        }
        stage('Build Docker image') {
            steps {
                script {
                    // Build a Docker image using the Dockerfile
                    docker.build('product-microservice-image', '-f Dockerfile .')
                }
            }
        }
        stage('Test Docker image') {
            steps {
                script {
                    // Optionally run some tests on the Docker image (if applicable)
                    sh 'docker run product-microservice-image'
                }
            }
        }
        stage('Clean up') {
            steps {
                script {
                    // Clean up Docker resources after building
                    sh 'docker rmi product-microservice-image'
                }
            }
        }
    }
}
