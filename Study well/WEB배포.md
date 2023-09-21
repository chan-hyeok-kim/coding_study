### 배포


```


1. 해당 파일
2. apache-tomcat-9.0.76-webapp에 war 파일 넣고
3. bin에서 startup.bat 실행

startup.sh(mac인 경우)

포트 82로는 톰캣 서버 webapp까지만 들어옴


```



```
sudo docker images
REPOSITORY                   TAG       IMAGE ID       CREATED       SIZE
wnameless/oracle-xe-11g-r2   latest    0d19fd2e072e   3 years ago   2.1GB
ubuntu@ip-172-31-43-90:~$ sudo docker pull tomcat
Using default tag: latest
latest: Pulling from library/tomcat
44ba2882f8eb: Pull complete
2cabec57fa36: Pull complete
c4e554d59e12: Pull complete
111cbdbeed15: Pull complete
ebe3e1fbfc69: Pull complete
dfa1fc9cfd4d: Pull complete
33eb4f163d71: Pull complete
064a77b1040e: Pull complete
Digest: sha256:a215a8c356af7ff323595018bd1fb97a4893d49ae8f53746a969ba57a8534846
Status: Downloaded newer image for tomcat:latest
docker.io/library/tomcat:latest
ubuntu@ip-172-31-43-90:~$ sudo docker images
REPOSITORY                   TAG       IMAGE ID       CREATED       SIZE
tomcat                       latest    d0ed0a728666   13 days ago   426MB
wnameless/oracle-xe-11g-r2   latest    0d19fd2e072e   3 years ago   2.1GB
ubuntu@ip-172-31-43-90:~$ -i
-i: command not found
ubuntu@ip-172-31-43-90:~$ sudo docker run -p 80:8080 --name myweb tomcat


```

* 톰캣 실행


### 내 로컬에 있는 파일이-> 인스턴스로 가려면


```

1. FTP도구 써야 함
ex)파일질라

2. SCP명령어
scp -i pem파일명 업로드할파일명과 경로 ubuntu@ip:/home/ubuntu

```

* PEM과 업로드할 파일 보내줌(ROOT란 이름으로 보내줘야 한다)

```
scp -i .\GDJ68-KCH.pem .\ROOT.war ubuntu@3.34.47.242:/home/ubuntu

```


```

Last login: Thu Sep 14 22:57:35 2023 from 14.36.141.71
ubuntu@ip-172-31-43-90:~$ ls -a
.              .bashrc   .sudo_as_admin_successful
..             .cache    GDJ68-KCH.pem
.bash_history  .profile  main-1.0.0-BUILD-SNAPSHOT.war
.bash_logout   .ssh
ubuntu@ip-172-31-43-90:~$ ls
GDJ68-KCH.pem  main-1.0.0-BUILD-SNAPSHOT.war
ubuntu@ip-172-31-43-90:~$ rm -f main-1.0.0-BUILD-SNAPSHOT.war
ubuntu@ip-172-31-43-90:~$ ls -l
total 26624
-rw-rw-r-- 1 ubuntu ubuntu     1674 Jul 10 00:56 GDJ68-KCH.pem
-rw-rw-r-- 1 ubuntu ubuntu 27258201 Sep 15 06:49 ROOT.war
ubuntu@ip-172-31-43-90:~$ sudo docker cp ~/ROOT.war myweb:/usr/local/tomcat/webapps
Successfully copied 27.3MB to myweb:/usr/local/tomcat/webapps
ubuntu@ip-172-31-43-90:~$ sudo docker exec -it myweb /bin/bash  

```


사용했던 명령어들
```


  sudo apt-get update
    2  sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common
    3  curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
    4  sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
    5  sudo apt-get update
    6  sudo apt-get install docker-ce docker-ce-cli containerd.io
    7  sudo systemctl status docker
    8  cd
    9  exit
   10  cd
   11  ls
   12  pwd
   13  apt list --upgradable
   14  docker --version
   15  history
   16  sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
   17  docker --version
   18  sudo docker pull wnameless/oracle-xe-11g-r2
   19  sudo docker run -d -p 1521:1521 -e ORACLE_PASSWORD=oracle --name db gvenzl/oracle-xe-11g-r2
   20  sudo docker run -d -p 1521:1521 -e ORACLE_PASSWORD=oracle --name db wnameless/oracle-xe-11g-r2
   21  docker ls
   22  docker img
   23  sudo docker ps
   24  exit
   25  ifconfig
   26  ipconfig
   27  docker ls
   28  docker ls -a
   29  docker ps -a
   30  history
   31  docker ps
   32  ls
   33  sudo docker ps
   34  sudo docker ps -a
   35  sudo docker start db
   36  docker ps
   37  sudo docker ps
   38  sudo docker ps
   39  sudo docker start db
   40  sudo docker ls
   41  sudo docker ls -a
   42  sudo docker ps -a
   43  sudo docker ps
   44  sudo docker start db
   45  sudo docker start dbb
   46  sudo docker start db
   47  sudo docker restart db
   48  sudo docker start db
   49  ls -a
   50  ls
   51  rm -f main-1.0.0-BUILD-SNAPSHOT.war
   52  ls -l
   53  sudo docker cp ~/ROOT.war myweb:/usr/local/tomcat/webapps
   54  sudo docker exec -it myweb /bin/bash
   55  pwd
   56  docker ps
   57  sudo docker ps
   58  sudo docker images
   59  sudo docker pull tomcat
   60  sudo docker images
   61  -i
   62  sudo docker run -p 80:8080 --name myweb tomcat
   63  ls
   64  sudo docker cp ~/ROOT.war myweb:/usr/local/tomcat/webapps
   65  sudo docker exec -it myweb /bin/bash
   66  sudo docker start myweb
   67  sudo docker exec -it myweb /bin/bash
   68  sudo docker images
   69  sudo docker pull mariadb
   70  mysql -u root
   71  sudo mysql -u root
   72  mysql -u root -p
   73  sudo apt update
   74  sudo docker image
   75  sudo docker images
   76  sudo docker run -d -p 3306:3306 -e MARIADB_ROOT_PASSWORD=1234 --name maria mariadb
   77  sudo docker ps
   78  sudo docker ps -a
   79  sudo docker stop tomcat
   80  sudo docker stop myweb
   81  mysql -u root -p
   82  sudo docker exec -it mariadb /bin/bash
   83  sudo docker exec -it maria /bin/bash
   84  sudo docker start maria


```