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