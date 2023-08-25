package EducativeIo.DesignPatterns.StructuralDesignPatterns.AdapterPattern;

public class Client {
    public static void main(String[] args) {
        JsonObj jsonObj=new JsonObj("alpha","11");
        XmlObj xmlObj=new JsonAdapter(jsonObj).jsonToXml();
        System.out.println(xmlObj.xmlKey+" : "+xmlObj.xmlValue);
    }
}
