pipeline{
    agent any
    stages{
        stage('first stage'){
            steps{
                echo "Text in first stage"
            }
        }
        stage('Second stage'){
            steps{
                echo 'Text in second stage'
            }
        }
    }
}