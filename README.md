# Matematicas
Ejemplo de operaciones matemáticas

## Requisitos para instalar el proyecto: ##
- IDE cono soporte Springboot, por ejemplo Intellij CE 
- Tener maven instalado, versión 3.
- Java 11
- Springboot


## Instrucciones para instalar el proyecto: ##
1. Clonar el repositorio desde https://github.com/n1c4n0r/matematicas.git
2. Compilar el proyecto usando el comando mvn clean install
    De esta forma se descargaran todas las librerías citadas en el pom.xml 
    y se irán instalando en el directorio .m2 configurado en maven.
    A su vez estaramos ejecutando los tests de la aplicación.
3. Arrancar en la IDE seleccionada la clase [ApiMatematicasApplication.java],
    usando Java 11 y configuración básica.
4. Una vez arrancado, usar por ejemplo la aplicación postman para lanzar
    una petición tipo POST:
    http://localhost:8080/api/v1/numeros/sumaCienPrimeros
5. Los datos de prueba irán en el body y el tipo de datos es Json:
    Esto seria un ejemplo con el array de 100 números
    ````
    [1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
    11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
    21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
    31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
    41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
    51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
    61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
    71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
    81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
    91, 92, 93, 94, 95, 96, 97, 98, 99, 100
    ]
6. Si se posee una aplicación tipo postman se podría usar el comando curl 
válido en varios sistemas operativos:
    ````    
   curl --location 'http://localhost:8080/api/v1/numeros/sumaCienPrimeros' \
   --header 'Content-Type: application/json' \
   --data '[1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
   11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
   21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
   31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
   41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
   51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
   61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
   71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
   81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
   91, 92, 93, 94, 95, 96, 97, 98, 99, 100
   ]'