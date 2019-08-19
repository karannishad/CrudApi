FROM java:8
RUN mkdir app
COPY . ./app
WORKDIR ./app
CMD cd target && java -jar CrudApi-0.0.1-SNAPSHOT.jar

