FROM openjdk:21-slim

WORKDIR /app

# gradle 설정파일 복사
COPY gradlew gradle build.gradle settings.gradle /app/
COPY gradle/wrapper /app/gradle/wrapper

# 실행권한 부여 & build.gradle 의존성 다운로드
RUN chmod +x gradlew \
    && ./gradlew dependencies

# 소스코드 복사
COPY src /app/src

# 최소권한 설정
RUN groupadd -r appgroup && useradd -r -g appgroup appuser \
    && mkdir -p /home/appuser/.gradle \
    && chown -R appuser:appgroup /app /home/appuser/.gradle

USER appuser

CMD ["./gradlew", "bootRun"]