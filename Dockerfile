FROM maven:3.9.3-eclipse-temurin-17
ENV PORT=8083
EXPOSE $PORT
WORKDIR /app
COPY . .
RUN mvn package
CMD ["sh", "-c", "java -jar target/demo-*.jar --server.port=$PORT"]