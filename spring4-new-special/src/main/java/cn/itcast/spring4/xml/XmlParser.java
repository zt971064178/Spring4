package cn.itcast.spring4.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class XmlParser {
	/**
     * 将对象序列化为XML
     * @param entity
     * @return
     */
    public static <T> String parseToXml(T entity) {  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(out));  
        encoder.writeObject(entity);  
        encoder.close();  
        return out.toString();  
    }  
    /**
     * 将XML反序列化到指定对象
     * @param xml
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T loadFromXml(String xml) {  
        ByteArrayInputStream in = new ByteArrayInputStream(xml.getBytes());  
        XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(in));  
        decoder.close();  
        return (T) decoder.readObject();  
    }  
}
