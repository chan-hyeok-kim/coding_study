package chap07.ex33;

class ex33 {
    private int outerIv = 0;
    static int outerCv = 0;
	
    class InstanceInner {
    	int iiv = outerIv;
    	int iiv2 = outerCv;
	}
    
    static class StaticInner {
//    	int siv = outerIv;
    	static int scv = outerCv;
    }
    
    void myMethod() {
    	int lv = 0;
    	final int LV = 0;
    	
    	class LocalInner {
    		int liv = outerIv;
    		int liv2 = outerCv;
    		
    		int liv3 = lv;
    		int liv4 = LV;
    	}
    }

}
