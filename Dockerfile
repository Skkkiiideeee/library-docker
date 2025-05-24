FROM openjdk:21

# Copy the wait script and jar
COPY wait-for-it.sh wait-for-it.sh
COPY target/library-0.0.1-SNAPSHOT.jar app.jar

# Make script executable
RUN chmod +x wait-for-it.sh

# Wait for MongoDB on port 27017, then start the app
ENTRYPOINT ["./wait-for-it.sh", "mongo:27017", "--", "java", "-jar", "app.jar"]

EXPOSE 2943
