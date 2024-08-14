pipeline {
    agent any

    environment {
        DOCKER_CREDENTIALS_ID = 'hanghjj' // 위에서 설정한 Docker Hub 인증 정보 ID
        DOKCER_IMAGE_NAME = 'hanghjj/gstock'
        NODE_VERSION = '22.6.0' // Node.js 버전 이름
        SSH_KEY_ID = 'ORACLE_CLOUD_KEY_PRIVATE'
        REMOTE_USER = 'ubuntu'
        REMOTE_SERVER = '144.24.88.59'
        SERVER_PORT = '22'
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

        stage('Login & Build Docker Image & Push to Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker-hub-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {

                script {
                    def dockerRegistry = 'https://index.docker.io/v1/'
                    sh """
                    echo $DOCKER_PASSWORD | sudo docker login $dockerRegistry --username $DOCKER_USERNAME --password-stdin
                    """
                    withEnv(['DOCKER_IMAGE_NAME=hanghjj/gstock']) {
                        sh "sudo docker build -t $DOCKER_IMAGE_NAME:latest -f Dockerfile ."
                        sh "sudo docker push ${DOCKER_IMAGE_NAME}:latest"
                    }
                }
              }
            }
        }

        stage('Deploy Docker Container In SSH Session') {
            steps {
                withCredentials([file(credentialsId: SSH_KEY_ID, variable: 'SSH_KEY_FILE'),
                                 usernamePassword(credentialsId: DOCKER_CREDENTIALS_ID, usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    script {
                        sh '''
                        # SSH를 통해 원격 서버에 연결하여 Docker Hub에 로그인하고 이미지 빌드 및 푸시 수행
                        ssh -i $SSH_KEY_FILE -p ${SSH_PORT} -o StrictHostKeyChecking=no ${REMOTE_USER}@${REMOTE_SERVER} << 'EOF'
                            # Docker Hub에 로그인
                            echo ${DOCKER_PASSWORD} | docker login --username ${DOCKER_USERNAME} --password-stdin
                            
                            # Docker 이미지 Pull
                            docker pull ${DOCKER_IMAGE_NAME}:latest .
                            
                            # Docker Container Run
                            docker run -d --name gstock_container ${DOCKER_IMAGE_NAME}:latest
                        EOF
                        '''
                    }
                }

            }
        }
    }
}