pipeline {
    agent any
    environment{
        env1:"env1 value"
    }
    parameters {
        choice(
                name: "Environment",
                choices: ["QA", "Dev", "release"],
                description: "Choice an Environment"
        )
        string(
                name: "Tags",
                defaultValue: "@smoke",
                description: "Add the needed tags"
        )
    }
    stages {
        stage('first stage') {
            steps {
                echo "Text in first stage"
                echo "Print env variable ${env.env1}"
            }
        }
        stage('Second stage') {
            steps {
                echo 'Text in second stage'
            }
        }
    }
}