FROM java:8
RUN mkdir app
COPY . ./app
WORKDIR ./app
ENTRYPOINT cd target && java -jar *.jar


