pipeline {
    agent any

    tools {
        maven "Maven-3"
    }

    stages {
        stage('Build') { // Clonamos el repositorio y descargamos las dependencias
            steps {

                git branch: 'main', url: 'https://github.com/HerbertMG/Test-Web-Exito.git'

                bat "mvn clean package -DskipTest=true -f pom.xml"
            }

        }
        stage('Test') {  // Ejecutamos el runner del proyecto
            steps {

                bat "mvn test -f pom.xml"
            }
        }
    }
}