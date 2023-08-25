package EducativeIo.DesignPatterns.CreatorDesignPatterns.AdapterPattern;

public class JsonAdapter {
    JsonObj jsonObj;
    JsonAdapter(JsonObj jsonObj){
        this.jsonObj=jsonObj;
    }

    public XmlObj jsonToXml(){
        XmlObj xmlObj=new XmlObj();
        xmlObj.xmlKey=jsonObj.key;
        xmlObj.xmlValue= jsonObj.val;
        return xmlObj;
    }
}
