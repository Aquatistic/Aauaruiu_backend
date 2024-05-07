FROM eclipse-temurin:17-jdk as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src
RUN chmod +x ./mvnw
RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

FROM eclipse-temurin:17-jdk
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
COPY src/main/java/com/aquarium/aquarium_backend/databaseTables/DictTableValues/SensorTypes.json src/main/java/com/aquarium/aquarium_backend/databaseTables/DictTableValues/SensorTypes.json
COPY src/main/java/com/aquarium/aquarium_backend/databaseTables/DictTableValues/EffectorTypes.json src/main/java/com/aquarium/aquarium_backend/databaseTables/DictTableValues/EffectorTypes.json
ENTRYPOINT ["java","-cp","app:app/lib/*","com.aquarium.aquarium_backend.AquariumBackendApplication"]