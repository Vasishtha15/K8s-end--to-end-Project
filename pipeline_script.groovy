pipeline {
    agent any
    stages{
        stage ('Code Clone') {
            steps {
                git url : 'https://github.com/Vasishtha15/node-todo-cicd.git' , branch : 'master'
            }
        }
        stage ('Build') {
            steps {
                sh 'docker build . -t  node-todo-cicd:latest'
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

