pipeline {
	agent any

	environment {
		mavenHome = tool 'LocalMaven'
	}

	tools {
		jdk 'jdk11'
	}

	stages {

		stage('Build'){
			steps {
				bat "mvn clean install -DskipTests"
			}
		}

		stage('Test'){
			steps{
				bat "mvn test"
			}
		}

		stage('Deploy') {
			steps {
			    bat "mvn spring-boot:run"
			}
		}
	}
}
