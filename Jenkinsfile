pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'hanghjj' // 위에서 설정한 Docker Hub 인증 정보 ID
        DOKCER_IMAGE_NAME = 'gstock'
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/hanghjj/gstock', branch: 'master'
            }
        }

        stage('Build with Gradle') {
            steps {
                sh './gradlew bootJar'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build(DOKCER_IMAGE_NAME+':latest', '-f Dockerfile .')
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        docker.image(DOKCER_IMAGE_NAME+':latest').push('latest')
                    }
                }
            }
        }

        stage('Deploy Docker Container') {
            steps {
                script {
                    def image = docker.image(DOKCER_IMAGE_NAME':latest')
                    image.pull()
                    image.run('-d -p 8080:8080 --name gstock_container')
                }
            }
        }
    }
}