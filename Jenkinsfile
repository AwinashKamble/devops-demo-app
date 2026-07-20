pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                echo '==========================================='
                echo 'Checking out source code from GitHub...'
                echo '==========================================='

                checkout scm
            }
        }

        stage('Environment Information') {
            steps {
                echo '==========================================='
                echo 'Displaying Environment Details'
                echo '==========================================='

                sh '''
                    echo "Current User:"
                    whoami

                    echo ""

                    echo "Hostname:"
                    hostname

                    echo ""

                    echo "Current Directory:"
                    pwd

                    echo ""

                    echo "Git Version:"
                    git --version

                    echo ""

                    echo "Java Version:"
                    java -version

                    echo ""

                    echo "Workspace Files:"
                    ls -la
                '''
            }
        }

        stage('Build Application') {
            steps {

                echo '==========================================='
                echo 'Building Spring Boot Application'
                echo '==========================================='

                sh 'chmod +x mvnw'

                sh './mvnw clean package'
            }
        }

        stage('Verify Artifact') {
            steps {

                echo '==========================================='
                echo 'Verifying Build Artifact'
                echo '==========================================='

                sh '''
                    echo "Artifacts Generated:"
                    ls -lh target

                    echo ""

                    echo "Jar Files:"
                    ls target/*.jar
                '''
            }
        }

        stage('Archive Artifact') {
            steps {

                echo '==========================================='
                echo 'Archiving Artifact'
                echo '==========================================='

                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {

        success {

            echo '==========================================='
            echo 'BUILD SUCCESSFUL'
            echo 'Artifact Created Successfully'
            echo '==========================================='

        }

        failure {

            echo '==========================================='
            echo 'BUILD FAILED'
            echo 'Please Check Console Output'
            echo '==========================================='

        }

        always {

            echo '==========================================='
            echo 'Pipeline Execution Completed'
            echo '==========================================='

            cleanWs()

        }
    }
}