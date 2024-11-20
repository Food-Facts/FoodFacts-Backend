FROM amazoncorretto:23-alpine-jdk
WORKDIR /app

# Instala las herramientas necesarias
RUN apk update && \
    apk add --no-cache maven

# Copia los archivos del proyecto
COPY pom.xml .
COPY src ./src

# Construye la aplicación
RUN mvn clean package -DskipTests

# Expone el puerto de la aplicación
EXPOSE 8080

# Ejecuta la aplicación
ENTRYPOINT ["java", "-jar", "/app/target/FoodFacts-0.0.1-SNAPSHOT.jar"]