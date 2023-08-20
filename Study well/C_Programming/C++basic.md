### cout
* 출력 함수

1. <iostream>을 include해야 함
2. 사용법
    - 출력: << 변수 <<
    - 줄바꿈: endl, \n
3. 예시
```

#include <iostream>

using namespace std;

int main()
{
        int a = 100;

        char b = 'A';

        long long c = 10000;

        cout<<a<<endl;

        cout<<b<<" "<<"Hello\n";

        cout<<"long long c value : "<<c<<endl;

        return 0;
}

```

```
100
A hello
long long c value : 10000
```
이 출력됨   

### 포인터
  - 사전 이해
  - 포인터라는 것은 주소를 참조하는 것(4byte고정, reference)
  - java의 멤버변수를 생각하면 편할 듯
  
1. *, &연산자를 사용
2. 초기화 null
3. 사용 예시

```
int a = 1;
int *b = &a;
```

* 선언은 *을 변수명 앞에 붙인다.
* &는 scanf사용 시에도 쓰이는 것으로 주소값을 의미 


### 포인터 배열