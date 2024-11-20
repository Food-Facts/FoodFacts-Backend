FROM amazoncorretto:23-alpine-jdk
WORKDIR /app

# Copia los archivos necesarios
COPY pom.xml .
COPY src ./src

# Instala Maven
RUN yum update -y && \
    yum install -y maven

# Ejecuta la aplicación directamente
CMD ["mvn", "spring-boot:run"]