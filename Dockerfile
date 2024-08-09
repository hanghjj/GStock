# JDK Image Start
FROM openjdk:17



ENV SPRING_PROFILES_ACTIVE=docker
ENV CLASSPATH=/app/app.jar


# 인자 설정 - JAR_File
ARG JAR_FILE=build/libs/GStock-0.0.1-SNAPSHOT.jar

# jar 파일 복제
COPY ${JAR_FILE} /app/app.jar
COPY src/main/resources/wallet /app/wallet
# 실행 명령어
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

EXPOSE 8080