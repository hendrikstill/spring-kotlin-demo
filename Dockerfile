# Very simple Dockerfile. Do not use in Production!
FROM gcr.io/distroless/java-debian10:11

COPY ./build/libs/disruptive-guestbook.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
