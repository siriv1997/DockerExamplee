CODE_CHANGES = getGitChanges()

pipeline{
    agent any
    stages{
        stage("build"){
            when{
                expression{
                    BRANCH_NAME == 'main' && CODE_CHANGES == true
                }
            }
            steps
            {
                echo "building the application"
            }
        }

        stage("test"){
            when{
                expression{
                    BRANCH_NAME == 'main' || BRANCH_NAME == 'dev'
                }
            }
            steps{
                echo "tesing the application"
            }
        }

        stage("deploy"){    
            steps{
                echo "deploying the application"
            }
        }
    }
    
}