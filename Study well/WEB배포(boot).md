### 3가지 배포 방식

#### 준비
* war파일 생성
* 배포용 properties도 가져와야 함.

1. SSH 접속
2. PUTTYGEN사용하여 SSH접속
3. FTP사용 + 우분투에서 git pull로 가져오기


3번 때 사용한 명령어들


```

   85  ls
   86  cd product/
   87  ls -l
   88  java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
   89  java -verstion
   90  java -version
   91  java c
   92  javac
   93  sudo apt-get update
   94  sudo apt-get update install openjdk-11-jdk
   95* sudo apt-get
   96  dir
   97  java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
   98  sudo server restart
   99  java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
  100  sudo java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
  101  java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
  102  sudo java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
  103  cd
  104  git --versiton
  105  git --verstion
  106  git --version
  107  git config --global user.name="Hamelen"
  108  git config --global user.name "Hamelen"
  109  git config --global user.email "daiolous@gmail.com"
  110  git config --list
  111  cd product/
  112  pwd
  113  git config --global user.name="Hamelen"
  114  git init
  115  ls -al
  116  git remote add origin https://github.com/Hamelen/GDJ68-Boot.git
  117  git pull origin Study_AOP
  118  dir
  119  rm -rf GDJ68-Boot-0.0.1-SNAPSHOT.war
  120  rm -rf application-prod.properties
  121  ls
  122*
  123  mvnw clean install -Dmaven.test.skip=true
  124  ls -l
  125  chmod 761 mvnw
  126  ls -al
  127  ./mvnw clean install -Dmaven.test.skip=true
  128  cd src/
  129  ls
  130  ls -a
  131  ls -al
  132  cd main
  133  ls -al
  134  cd
  135  cd product/src
  136  cd
  137  cd /product
  138  cd product
  139  ls -al
  140  cd target/
  141  ls -al
  142  cd ..
  143  cat pom.xml
  144  git pull origin Study_AOP
  145  cat pom.xml
  146* ./mvnw clean install -Dmaven.test.skip=tru
  147  ls -al
  148  cd target.
  149  cd target/
  150  ls -al
  151  java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
  152  sudo java -jar GDJ68-Boot-0.0.1-SNAPSHOT.war --spring.profiles.active=prod
  153  history



```


### CI/CD 파이프라인
* 지속적인 배포, 서비스 제공
