pipeline {
    agent any

    environment {
        IMAGE_TAG = "${env.BUILD_NUMBER}-${env.BUILD_ID}"
    }
    stages {
        stage('Init') {
            steps {
                echo "Initializing.."
                echo "$IMAGE_TAG"
                git 'https://github.com/EmilK102/cicd-test.git'
            }
        }
        stage('Build') {
            steps {
                echo "Building.."
                sh "mvn clean package"
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
                sh "mvn test"
            }
        }
        stage('Build Docker Images') {
            steps {
                echo "Building Images.."
                sh "docker build -t hello-devops:${IMAGE_TAG} ."
            }
        }
        stage('Clean Old Container') {
            steps {
                echo "Cleaning.."
                sh "docker stop get-started|| true" 
                sh "docker rm get-started || true"
            }
        }
        stage('Run Docker Container') {
            steps {
                echo "Deploy.."
                sh "docker run -dp 8083:8083 --name get-started hello-devops:${IMAGE_TAG}"
            }
        }
    }
}
