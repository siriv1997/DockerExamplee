CODE_CHANGES = getGitChanges()

pipeline{
    agent any
    environment{
        NEW_VERSION = '1.3.0'
        Docker_Credentials = credentials('Docker Key')
        // SAMPLE_CREDENTIALS = credentials('sample')
    }
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
                echo "buildiing version ${NEW_VERSION}"
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
                withCredentials([
                    usernamePassword(credentials:'sample',usernameVariable: USER, passwordVariable: PWD)
                ])
                {
                    sh "some script ${USER} ${PWD}"
                }
            }
        }

        stage("deploy"){    
            steps{
                echo "deploying the application"
                echo "deploying with ${SAMPLE_CREDENTIALS}"
                sh "${SAMPLE_CREDENTIALS}"
            }
        }
    }
    
}