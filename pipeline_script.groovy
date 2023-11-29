pipeline {
    agent any
    stages{
        stage ('Code Clone') {
            steps {
                git url : 'https://github.com/Vasishtha15/pipeline_script.groovy' , branch : 'main'
            }
        }
        stage ('Build') {
            steps {
                sh 'docker build . -t  node-todo-cicd:latest'
            }
        }
        stage ('Push to Docker Hub') {
            steps {
                echo "Pushing the image to Docker Hub"
                sh "docker login"
            }
        }
        stage ('Testing') {
            steps {
                echo 'testing'
            }
        }
        stage ('Deploy') {
            steps {
                sh 'docker run -d -p 8000:8000 node-todo-cicd:latest'
            }
        }
    }
}

