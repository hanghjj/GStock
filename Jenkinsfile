pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'hanghjj' // 위에서 설정한 Docker Hub 인증 정보 ID
        DOKCER_IMAGE_NAME = 'hanghjj/gstock'
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
        stage('Get Solutions Version Informations') {
            steps {
               // Node.js와 npm이 설치되어 있음
               sh 'node --version'
               sh 'npm --version'
               sh 'docker --version'
            }
        }

        stage('Grant Gradle Execute Permission') {
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

        stage('Login & Build Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {

                script {
                    def dockerRegistry = 'https://index.docker.io/v1/'
                    sh """
                    echo $DOCKER_PASSWORD | sudo docker login $dockerRegistry --username $DOCKER_USERNAME --password-stdin
                    """
                    sh "sudo docker build -t ${DOCKER_IMAGE_NAME}:latest -f Dockerfile ."
                }
              }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKER_CREDENTIALS_ID) {
                        sh "sudo docker push ${DOCKER_IMAGE_NAME}:latest"
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