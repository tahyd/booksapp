def img
pipeline {
    environment {
        registry = "tahyd003/booksapp"
        registryCredentials = "docker_id"
        githubCredentials = "git-hub-credentials"
        dockerImage = ""
        
    }
    tools{
    jdk 'jdk17'
    maven 'maven3'
    }
    agent any 
    
    stages {
        // Pull the code from GitHub
        stage("checkout"){
            steps {
              git branch: 'main',
              credentialsId: githubCredentials,
              url: 'https://github.com/tahyd/booksapp.git'
            }
            
            }
/*

stage('SonarQube analysis') {
    steps{
 script{
     scannerHome = tool 'SonarQubeScanner-5.0.1';
 }

  withSonarQubeEnv(credentialsId:'sonar_local_token',installationName:'SonarQube-9.9.3') { // If you have configured more than one global server connection, you can specify its name
      bat "${scannerHome}/bin/sonar-scanner  -Dsonar.projectKey=python_flask_loanapp"
    }
    }
   
   
  }
*/
       stage("Build package"){
       
       steps{
       
       bat 'mvn clean package'
       }
       
       }



         stage("Test"){
             
             steps {
                 echo "Testing completed"
             }
         }
         
         //  Clean the docker containers if already running
        stage ('Clean Up'){
            steps{
                sh returnStatus: true, script: 'docker stop $(docker ps -a | grep ${JOB_NAME} | awk \'{print $1}\')'
                sh returnStatus: true, script: 'docker rmi $(docker images | grep ${registry} | awk \'{print $3}\') --force' //this will delete all images
                sh returnStatus: true, script: 'docker rm ${JOB_NAME}'
            }
        }

       // Sonar Analysis

       
         // Build docker image
         
        
        stage('Build Image') {
            steps {
                script {
                    //img = registry + ":${env.BUILD_ID}"
                    img = registry + ":latest"
                    println ("${img}")
                    dockerImage = docker.build("${img}")
                }
            }
        }
        
        // Push to docker hub
        
        /*  stage('Push To DockerHub') {
            steps {
                script {
                    docker.withRegistry( 'https://registry.hub.docker.com ',registryCredentials ) {
                        dockerImage.push()
                    }
                }
            }
        }*/
        
        // Deploy in Local machine
        
        
        
         stage('Deploy') {
           steps {
           println("${JOB_NAME}")
                sh label: '', script: "docker run -d --name ${JOB_NAME}  -p 9091:9091 ${img}"
               
               
          }
        }
        
        
        
    }
    
}




/*stage("Quality Gate"){
  timeout(time: 1, unit: 'HOURS') { // Just in case something goes wrong, pipeline will be killed after a timeout
    def qg = waitForQualityGate() // Reuse taskId previously collected by withSonarQubeEnv
    if (qg.status != 'OK') {
      error "Pipeline aborted due to quality gate failure: ${qg.status}"
    }
  }
}
*/