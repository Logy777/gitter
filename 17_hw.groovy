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
        }    
        stage('02.Show_interfaces') {
            steps {
                echo 'show_interfaces..'
                sh """
                /usr/sbin/ip a
                """
            }
        }
        stage('03.Installing nmap, scaning') {
            steps {
                echo 'installing nmap & scaning..'
                sh """
                sudo /bin/yum install nmap -y
                nmap -sP 192.168.100.1/24
                """
            }
        }
        stage('04.Removing nmap') {
            steps {
                echo 'removing nmap..'
                sh """
                sudo /bin/yum remove nmap -y
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