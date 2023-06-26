package chap07.ex25;

interface Parseable {
	public abstract void parse(String fileName);
}

class  ParserManager {
	public static Parseable gerParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			Parseable p = new HTMLParser();
			return p;
		}
	}
}

class XMLParser implements Parseable {
	public void parse(String fileName) {
		System.out.println(fileName + "- XML parsing completed.");
	}
}

class HTMLParser implements Parseable {
   public void parse(String fileName) {
	System.out.println(fileName + "-HTML parsing completed.");
}
}

public class ex25 {
	public static void main(String[] args) {
	   Parseable parser = ParserManager.getParser("XML");	
	   parser.parse("document.xml");	
	   parser = ParserManager.getParser("HTML");	
	   parser.parse("document2.html");
	}
}
