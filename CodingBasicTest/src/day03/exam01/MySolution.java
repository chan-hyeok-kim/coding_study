package day03.exam01;

public class MySolution {
    public String solution(String str1, String str2) {
    	
    	StringBuilder result = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            result.append(str1.charAt(i));
            result.append(str2.charAt(i));
        }
        return result.toString();
            //append()는 Java에서 문자열을 이어붙이는 메소드
            //toString()은 객체의 정보를 문자열로 변환하여 반환하는 역할을 한다.
    } 
    }

/* 길이가 같은 두 문자열 str1과 str2가 주어집니다.
두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.
*/