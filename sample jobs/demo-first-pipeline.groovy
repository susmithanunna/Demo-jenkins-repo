pipeline {
    agent any
    environment{
        env1="env1 value"
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
                echo "print the enviromnet that is selected ${env.Environment}"
                echo "Print env variable ${env.env1}"
            }
        }
        stage('Second stage') {
            steps {
                echo 'Text in second stage'
                echo "print the Tags that is selected ${env.Tags}"
            }
        }
        stage("Parallel Stage"){
            parallel{
                stage('parallel stage1'){
                    steps{
                        echo "This parallel stage one step1"
                        echo "This parallel stage one step2"
                        echo "This parallel stage one step3"
                        echo "This parallel stage one step4"
                        echo "This parallel stage one step5"
                        echo "This parallel stage one step6"
                    }
                }
                stage('parallel stage2'){
                    steps{
                        echo "This parallel stage two step1"
                        echo "This parallel stage two step2 "
                    }
                }
            }
        }
    }
     post{
            sucess{
                echo "✅ job is success"
            }
            failure{
                echo "❌ job is failed"
            }
            aborted{
                echo "🛑 job is aborted"
            }
            always{
                echo "📌 job finished"
            }
            cleanup{
                echo "🧹 cleaning "
            }
        }
}
