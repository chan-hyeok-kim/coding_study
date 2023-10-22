
### JsonElement
간단한 json문자열을 jsonData라는 문자열에 넣고 JsonParser를 사용해 데이터를 꺼내는 예제입니다.

@Test
void test() {
    // {"name":"John", "age":"20"}
    String jsonData = "{\"name\":\"John\", \"age\":\"20\"}";
    JsonParser jsonParser = new JsonParser();
    JsonElement jsonElement = jsonParser.parse(jsonData);
    JsonObject jsonObject = jsonElement.getAsJsonObject();
    String name = jsonObject.get("name").getAsString();
    System.out.println("name = " + name);
}
 

1. JsonParser.parse를 이용하여 문자열을 JsonElement로 변환

2. 변환한 JsonElement를 JsonObject로 변경

3. jsonObject.get("key").getAsString() 을 이용하여 원하는 데이터 추출

 

### JSON 파싱
다음 3종류의 JSON을 파싱하는 예제를 소개합니다.

 - 간단한 Key-Value만 있는 JSON
 - 하위에 여러 Object가 있는 JSON
 - Array가 있는 JSON


#### 1. 간단한 Key-Value만 있는 JSON
파싱할 JSON string은 코드로 직접 하드코딩했습니다.

```

import org.json.JSONArray;
import org.json.JSONObject;

public void jsonParsing1() {
    String jsonString = "{\"title\": \"how to get stroage size\","
            + "\"url\": \"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/\","
            + "\"draft\": false,"
            + "\"star\": 10"
            + "}";

    // JSONObjet를 가져와서 key-value를 읽습니다.
    JSONObject jObject = new JSONObject(jsonString);
    String title = jObject.getString("title");
    String url = jObject.getString("url");
    Boolean draft = jObject.getBoolean("draft");
    int star = jObject.getInt("star");

    System.out.println("title: " + title);
    System.out.println("url: " + url);
    System.out.println("draft: " + draft);
    System.out.println("star: " + star);
}
```

결과

title: how to get stroage size
url: https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/
draft: false
star: 10

#### 2. 하위에 여러 Object가 있는 JSON
파싱할 JSON string은 코드로 직접 하드코딩했습니다.

```
import org.json.JSONArray;
import org.json.JSONObject;

public void jsonParsing2() {
    String jsonString =
        "{"
        +   "\"post1\": {"
        +       "\"title\": \"how to get stroage size\","
        +       "\"url\": \"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/\","
        +       "\"draft\": false"
        +"  },"
        +   "\"post2\": {"
        +       "\"title\": \"Android Q, Scoped Storage\","
        +       "\"url\": \"https://codechacha.com/ko/android-q-scoped-storage/\","
        +       "\"draft\": false"
        +   "}"
        +"}";

    // 가장 큰 JSONObject를 가져옵니다.
    JSONObject jObject = new JSONObject(jsonString);

    // 첫번째 JSONObject를 가져와서 key-value를 읽습니다.
    JSONObject post1Object = jObject.getJSONObject("post1");
    System.out.println(post1Object.toString());
    System.out.println();
    String title = post1Object.getString("title");
    String url = post1Object.getString("url");
    boolean draft = post1Object.getBoolean("draft");
    System.out.println("title(post1): " + title);
    System.out.println("url(post1): " + url);
    System.out.println("draft(post1): " + draft);
    System.out.println();

    // 두번째 JSONObject를 가져와서 key-value를 읽습니다.
    JSONObject post2Object = jObject.getJSONObject("post2");
    System.out.println(post2Object.toString());
    System.out.println();
    title = post2Object.getString("title");
    url = post2Object.getString("url");
    draft = post2Object.getBoolean("draft");
    System.out.println("title(post1): " + title);
    System.out.println("url(post1): " + url);
    System.out.println("draft(post1): " + draft);
}
```
결과

{"draft":false,"title":"how to get stroage size","url":"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/"}

title(post1): how to get stroage size
url(post1): https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/
draft(post1): false

{"draft":false,"title":"Android Q, Scoped Storage","url":"https://codechacha.com/ko/android-q-scoped-storage/"}

title(post1): Android Q, Scoped Storage
url(post1): https://codechacha.com/ko/android-q-scoped-storage/
draft(post1): false


3. Array가 있는 JSON
파싱할 JSON string은 코드로 직접 하드코딩했습니다.

```
import org.json.JSONArray;
import org.json.JSONObject;

public void jsonParsing3() {
    String jsonString =
    "{"
    +   "\"posts\": ["
    +       "{"
    +           "\"title\": \"how to get stroage size\","
    +           "\"url\": \"https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/\","
    +           "\"draft\": false"
    +       "},"
    +       "{"
    +           "\"title\": \"Android Q, Scoped Storage\","
    +           "\"url\": \"https://codechacha.com/ko/android-q-scoped-storage/\","
    +           "\"draft\": false"
    +       "},"
    +       "{"
    +           "\"title\": \"How to parse JSON in android\","
    +           "\"url\": \"https://codechacha.com/ko/how-to-parse-json-in-android/\","
    +           "\"draft\": true"
    +       "}"
    +   "]"
    +"}";

    // 가장 큰 JSONObject를 가져옵니다.
    JSONObject jObject = new JSONObject(jsonString);
    // 배열을 가져옵니다.
    JSONArray jArray = jObject.getJSONArray("posts");

    // 배열의 모든 아이템을 출력합니다.
    for (int i = 0; i < jArray.length(); i++) {
        JSONObject obj = jArray.getJSONObject(i);
        String title = obj.getString("title");
        String url = obj.getString("url");
        boolean draft = obj.getBoolean("draft");
        System.out.println("title(" + i + "): " + title);
        System.out.println("url(" + i + "): " + url);
        System.out.println("draft(" + i + "): " + draft);
        System.out.println();
    }
}
```

결과

title(0): how to get stroage size
url(0): https://codechacha.com/ko/get-free-and-total-size-of-volumes-in-android/
draft(0): false

title(1): Android Q, Scoped Storage
url(1): https://codechacha.com/ko/android-q-scoped-storage/
draft(1): false

title(2): How to parse JSON in android
url(2): https://codechacha.com/ko/how-to-parse-json-in-android/
draft(2): true
