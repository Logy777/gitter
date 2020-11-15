# 17.Jenkins.As code

## The [17_hw.groovy](17_hw.groovy) pipeline Console output:

```bash
Started by user Dzianis_Z
Obtained 17_hw.groovy from git git@github.com:Logy777/gitter.git
Running in Durability level: MAX_SURVIVABILITY
[Pipeline] Start of Pipeline
[Pipeline] node
Running on local_vagrant_node in /var/lib/jenkins/workspace/17_hw.groovy
[Pipeline] {
[Pipeline] stage
[Pipeline] { (Declarative: Checkout SCM)
[Pipeline] checkout
Selected Git installation does not exist. Using Default
The recommended git tool is: NONE
using credential j_deb_dock_github
Fetching changes from the remote Git repository
 > git rev-parse --is-inside-work-tree # timeout=10
 > git config remote.origin.url git@github.com:Logy777/gitter.git # timeout=10
Fetching upstream changes from git@github.com:Logy777/gitter.git
 > git --version # timeout=10
 > git --version # 'git version 1.8.3.1'
using GIT_SSH to set credentials j_deb_dock_github
 > git fetch --tags --progress git@github.com:Logy777/gitter.git +refs/heads/*:refs/remotes/origin/* # timeout=10
Checking out Revision 7571aa529ce598f0a15b4c894797395412906920 (refs/remotes/origin/master)
Commit message: "speedtest accept license"
 > git rev-parse refs/remotes/origin/master^{commit} # timeout=10
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 7571aa529ce598f0a15b4c894797395412906920 # timeout=10
 > git rev-list --no-walk 1710eb150d578374d2738baca9e42ed57c902424 # timeout=10
[Pipeline] }
[Pipeline] // stage
[Pipeline] withEnv
[Pipeline] {
[Pipeline] stage
[Pipeline] { (01.Check_connection)
[Pipeline] echo
pinging tut.by..
[Pipeline] sh
+ ping tut.by -c 3
PING tut.by (178.172.160.4) 56(84) bytes of data.
64 bytes from 178-172-160-4.hosterby.com (178.172.160.4): icmp_seq=1 ttl=63 time=12.3 ms
64 bytes from 178-172-160-4.hosterby.com (178.172.160.4): icmp_seq=2 ttl=63 time=4.41 ms
64 bytes from 178-172-160-4.hosterby.com (178.172.160.4): icmp_seq=3 ttl=63 time=5.02 ms

--- tut.by ping statistics ---
3 packets transmitted, 3 received, 0% packet loss, time 2005ms
rtt min/avg/max/mdev = 4.418/7.260/12.338/3.599 ms
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (02.Show_interfaces)
[Pipeline] echo
show_interfaces..
[Pipeline] sh
+ /usr/sbin/ip a
1: lo: <LOOPBACK,UP,LOWER_UP> mtu 65536 qdisc noqueue state UNKNOWN group default qlen 1000
    link/loopback 00:00:00:00:00:00 brd 00:00:00:00:00:00
    inet 127.0.0.1/8 scope host lo
       valid_lft forever preferred_lft forever
    inet6 ::1/128 scope host 
       valid_lft forever preferred_lft forever
2: eth0: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc pfifo_fast state UP group default qlen 1000
    link/ether 52:54:00:4d:77:d3 brd ff:ff:ff:ff:ff:ff
    inet 10.0.2.15/24 brd 10.0.2.255 scope global noprefixroute dynamic eth0
       valid_lft 59513sec preferred_lft 59513sec
    inet6 fe80::5054:ff:fe4d:77d3/64 scope link 
       valid_lft forever preferred_lft forever
3: docker0: <NO-CARRIER,BROADCAST,MULTICAST,UP> mtu 1500 qdisc noqueue state DOWN group default 
    link/ether 02:42:16:77:30:e6 brd ff:ff:ff:ff:ff:ff
    inet 172.17.0.1/16 brd 172.17.255.255 scope global docker0
       valid_lft forever preferred_lft forever
    inet6 fe80::42:16ff:fe77:30e6/64 scope link 
       valid_lft forever preferred_lft forever
4: eth1: <BROADCAST,MULTICAST,UP,LOWER_UP> mtu 1500 qdisc pfifo_fast state UP group default qlen 1000
    link/ether 08:00:27:ee:a3:dc brd ff:ff:ff:ff:ff:ff
    inet 192.168.100.41/24 brd 192.168.100.255 scope global noprefixroute eth1
       valid_lft forever preferred_lft forever
    inet6 fe80::a00:27ff:feee:a3dc/64 scope link 
       valid_lft forever preferred_lft forever
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (03.Installing nmap, scaning)
[Pipeline] echo
installing nmap & scaning..
[Pipeline] sh
+ sudo /bin/yum install nmap -y
Loaded plugins: fastestmirror
Loading mirror speeds from cached hostfile
 * base: centos2.hti.pl
 * extras: ftp.byfly.by
 * updates: ftp.byfly.by
Resolving Dependencies
--> Running transaction check
---> Package nmap.x86_64 2:6.40-19.el7 will be installed
--> Finished Dependency Resolution
Dependencies Resolved

================================================================================
 Package        Arch             Version                   Repository      Size
================================================================================
Installing:
 nmap           x86_64           2:6.40-19.el7             base           3.9 M

Transaction Summary
================================================================================
Install  1 Package

Total download size: 3.9 M
Installed size: 16 M
Downloading packages:
Running transaction check
Running transaction test
Transaction test succeeded
Running transaction
  Installing : 2:nmap-6.40-19.el7.x86_64                                    1/1 
  Verifying  : 2:nmap-6.40-19.el7.x86_64                                    1/1 

Installed:
  nmap.x86_64 2:6.40-19.el7                                                     

Complete!
+ nmap -sP 192.168.100.1/24

Starting Nmap 6.40 ( http://nmap.org ) at 2020-11-11 22:24 +03
Nmap scan report for _gateway (192.168.100.1)
Host is up (0.0031s latency).
Nmap scan report for 192.168.100.2
Host is up (0.026s latency).
Nmap scan report for 192.168.100.3
Host is up (0.077s latency).
Nmap scan report for 192.168.100.13
Host is up (0.0034s latency).
Nmap scan report for dz-15.jenkins.dz (192.168.100.14)
Host is up (0.00031s latency).
Nmap scan report for 192.168.100.26
Host is up (0.12s latency).
Nmap scan report for 192.168.100.41
Host is up (0.00047s latency).
Nmap scan report for 192.168.100.254
Host is up (0.087s latency).
Nmap done: 256 IP addresses (8 hosts up) scanned in 11.67 seconds
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (04.Removing nmap)
[Pipeline] echo
removing nmap..
[Pipeline] sh
+ sudo /bin/yum remove nmap -y
Loaded plugins: fastestmirror
Resolving Dependencies
--> Running transaction check
---> Package nmap.x86_64 2:6.40-19.el7 will be erased
--> Finished Dependency Resolution
Dependencies Resolved

================================================================================
 Package        Arch             Version                  Repository       Size
================================================================================
Removing:
 nmap           x86_64           2:6.40-19.el7            @base            16 M

Transaction Summary
================================================================================
Remove  1 Package

Installed size: 16 M
Downloading packages:
Running transaction check
Running transaction test
Transaction test succeeded
Running transaction
  Erasing    : 2:nmap-6.40-19.el7.x86_64                                    1/1 
  Verifying  : 2:nmap-6.40-19.el7.x86_64                                    1/1 

Removed:
  nmap.x86_64 2:6.40-19.el7                                                     

Complete!
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (05.Installing speedtest)
[Pipeline] echo
installing speedtest..
[Pipeline] sh
+ wget https://bintray.com/ookla/rhel/rpm -O bintray-ookla-rhel.repo
--2020-11-11 22:24:50--  https://bintray.com/ookla/rhel/rpm
Resolving bintray.com (bintray.com)... 75.126.118.184
Connecting to bintray.com (bintray.com)|75.126.118.184|:443... connected.
HTTP request sent, awaiting response... 200 OK
Length: unspecified [text/plain]
Saving to: 'bintray-ookla-rhel.repo'

     0K                                                        4.23M=0s

2020-11-11 22:24:50 (4.23 MB/s) - 'bintray-ookla-rhel.repo' saved [172]

+ sudo mv bintray-ookla-rhel.repo /etc/yum.repos.d/
+ sudo /bin/yum install speedtest -y
Loaded plugins: fastestmirror
Loading mirror speeds from cached hostfile
 * base: centos2.hti.pl
 * extras: ftp.byfly.by
 * updates: ftp.byfly.by
Package speedtest-1.0.0.2_1.5ae238b-1.x86_64 already installed and latest version
Nothing to do
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (06.Speed testing)
[Pipeline] echo
Testing..
[Pipeline] sh
+ speedtest --accept-license
==============================================================================

You may only use this Speedtest software and information generated
from it for personal, non-commercial use, through a command line
interface on a personal computer. Your use of this software is subject
to the End User License Agreement, Terms of Use and Privacy Policy at
these URLs:

	https://www.speedtest.net/about/eula
	https://www.speedtest.net/about/terms
	https://www.speedtest.net/about/privacy

==============================================================================

License acceptance recorded. Continuing.


   Speedtest by Ookla

     Server: MGTS - Minsk (id = 1119)
        ISP: Beltelecom
    Latency:     2.92 ms   (2.37 ms jitter)
   Download:    20.87 Mbps (data used: 15.4 MB)                               
     Upload:    40.74 Mbps (data used: 74.8 MB)                               
Packet Loss:     0.0%
 Result URL: https://www.speedtest.net/result/c/c5de0a0d-0196-4fe4-b487-5ab0b6a9d1c3
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (07.Removing speedtest)
[Pipeline] echo
removing speedtest..
[Pipeline] sh
+ rpm -qa
+ grep speedtest
+ xargs -I '{}' sudo /bin/yum -y remove '{}'
Loaded plugins: fastestmirror
Resolving Dependencies
--> Running transaction check
---> Package speedtest.x86_64 0:1.0.0.2_1.5ae238b-1 will be erased
--> Finished Dependency Resolution

Dependencies Resolved

================================================================================
 Package      Arch      Version                   Repository               Size
================================================================================
Removing:
 speedtest    x86_64    1.0.0.2_1.5ae238b-1       @bintray--ookla-rhel    2.2 M

Transaction Summary
================================================================================
Remove  1 Package

Installed size: 2.2 M
Downloading packages:
Running transaction check
Running transaction test
Transaction test succeeded
Running transaction
  Erasing    : speedtest-1.0.0.2_1.5ae238b-1.x86_64                         1/1 
  Verifying  : speedtest-1.0.0.2_1.5ae238b-1.x86_64                         1/1 

Removed:
  speedtest.x86_64 0:1.0.0.2_1.5ae238b-1                                        

Complete!
[Pipeline] }
[Pipeline] // stage
[Pipeline] stage
[Pipeline] { (Done message)
[Pipeline] echo
Done....
[Pipeline] }
[Pipeline] // stage
[Pipeline] }
[Pipeline] // withEnv
[Pipeline] }
[Pipeline] // node
[Pipeline] End of Pipeline
Finished: SUCCESS

```
