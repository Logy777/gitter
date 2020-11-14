pipeline { 
    agent any
    options {
        buildDiscarder(logRotator(numToKeepStr:'5'))
        ansiColor('xterm')
    }
    stages {
        stage('parallel') {
            parallel {
                stage('Clone repository 01') { 
                    steps { 
                        dir('01') {
                            git url: 'git@github.com:Logy777/02.Git.Local.git'
                            sh """
                                tar -zcvf /tmp/package_01.tar.gz  ./
                                ls -l
                            """
                            deleteDir()
                            sh "cp /tmp/package_01.tar.gz  ./"
                        }
                    }
                }
                stage('Clone repository 02') { 
                    steps { 
                        dir('02') {
                            git url: 'git@github.com:Logy777/invoicer.git'
                            sh """
                                tar -zcvf /tmp/package_02.tar.gz  ./
                                ls -l
                            """
                            deleteDir()
                            sh "cp /tmp/package_02.tar.gz  ./"
                        }
                    }
                }
            }
        }
        stage('Packing test') {
            steps {
                sh """
                ls -l ./01
                echo "#####################################################"
                ls -l ./02
                """
            }
        }
    }
}