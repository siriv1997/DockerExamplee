CODE_CHANGES = getGitChanges()

pipeline{
    agent any
    environment{
        NEW_VERSION = '1.3.0'
        DockerCredentials = credentials('DockerCred')
    }
    stages{
        stage("build"){
            steps
            {
                sh 'docker build -t siriv1997/dockerexam:latest .'
            }
        }

        stage("Login"){
            steps
            {
                sh 'echo $DockerCredentials_PSW | docker login -u DockerCredentials_USR --password-stdin'
            }
        }

        stage("Push"){
           steps
           {
               sh 'docker push siriv1997/dockerexam:latest'
           }
        }

    }

    post
    {
        always
        {
            sh 'docker logout'
        }
    }
    
}