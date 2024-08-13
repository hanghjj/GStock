pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'hanghjj' // 위에서 설정한 Docker Hub 인증 정보 ID
        DOKCER_IMAGE_NAME = 'gstock'
        NODE_VERSION = '22.6.0' // Node.js 버전 이름
    }

    tools {
            nodejs NODE_VERSION
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/hanghjj/gstock', branch: 'master'
            }
        }
        stage('Setup Node.js') {
            steps {
               // Node.js와 npm이 설치되어 있음
               sh 'node --version'
               sh 'npm --version'
            }
        }

        stage('Grant Execute Permission') {
            steps {
                // Gradle Wrapper에 실행 권한 부여
                sh 'chmod +x ./gradlew'
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
                    def image = docker.image(DOKCER_IMAGE_NAME + ':latest')
                    image.pull()
                    image.run('-d -p 8080:8080 --name gstock_container')
                }
            }
        }
    }
}