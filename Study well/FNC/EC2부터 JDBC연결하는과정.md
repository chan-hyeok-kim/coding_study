### 도커 환경 설정

1. ec2 docker
``` 

ec2 인스턴스의 ubuntu로 접속 후
docker 다운로드

1. sudo apt-get update
2. sudo apt-get install apt-transport-https ca-certificates curl gnupg-agent software-properties-common

3. curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -

4. sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"

5. sudo apt-get update

6. sudo apt-get install docker-ce docker-ce-cli containerd.io

```

이후 설치 상태 확인

```

sudo systemctl status docker

//아래는 실행 확인
sudo docker run hello-world
```


7. oracle jdbc환경에 쓸 도커 실행(DB용)

```

sudo docker run -d -p 1521:1521 -e ORACLE_PASSWORD=oracle --name db wnameless/oracle-xe-11g-r2

```

8. DB 및 계정생성


```
sudo apt-get install mysql-server

```

```

CREATE USER '유저명'@'%' IDENTIFIED BY '비밀번호';
GRANT ALL ON db명.* TO '유저명'@'%' IDENTIFIED BY '비밀번호' WITH GRANT OPTION;

grant all privileges on *.* to user01@127.0.0.1 identified by user01;

grant all privileges on *.* to '유저명'@'%' with grant option;

```

9. mybatis 프레임워크

1. mybatis 설치

```
<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis</artifactId>
			<version>3.5.9</version>
		</dependency>
```
2. mybatis-spring
   
```
<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>2.0.7</version>
		</dependency>
```

3. ojdbc
4. 
```
<!-- https://mvnrepository.com/artifact/com.oracle.database.jdbc/ojdbc10 -->
		<dependency>
			<groupId>com.oracle.database.jdbc</groupId>
			<artifactId>ojdbc10</artifactId>
			<version>19.14.0.0</version>
		</dependency>
```
