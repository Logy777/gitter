pipeline {
    agent { label 'local_vagrant_node' }

    stages {
        stage('01.Check_connection') {
            steps {
                echo 'pinging tut.by..'
                sh """
                ping tut.by -c 3
                """
            }
        stage('02.Show_interfaces') {
            steps {
                echo 'show_interfaces..'
                sh """
                /usr/sbin/ip a
                """
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}