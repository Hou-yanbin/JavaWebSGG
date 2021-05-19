package com.atguigu.pojo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class Dom4jTest {
    @Test
    public void test1() throws Exception {
        // 创建一个SaxReader输入流，去读取 xml配置文件，生成Document对象
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read("src/books.xml");

        System.out.println(document);
    }

    @Test
    public void test2() throws DocumentException {
        //1.读取books.xml文件
        SAXReader reader=new SAXReader();
        //在junit测试中，相对路径是从模板名开始算
        Document document=reader.read("src/books.xml");
        //2.通过Document对象获取根元素
        Element rootElement=document.getRootElement();
//        System.out.println(rootElement);
        //3.通过根元素获取book标签对象
        //elements()和element()都是通过标签名查找子元素
        List<Element> books= rootElement.elements("book");//List<Element>代表这个集合中存放了很多个Element对象
        //4.遍历处理每个book标签转换为Book类
        for (Element book : books){
//            //asXML()把标签对象转换为标签字符串
//            System.out.println(book.asXML());
            Element nameElement =book.element("name");
           // System.out.println(nameElement.asXML());
            //getText()可以获取标签中的文本内容
            String nameText=nameElement.getText();
            //System.out.println(nameText);
            //直接获取指定标签名的文本内容
            String priceText=book.elementText("price");
            //System.out.println(priceText);
            String authorText=book.elementText("author");
            //System.out.println(authorText);
            String snValue=book.elementText("sn");

            System.out.println(new Book(snValue,nameText, Double.parseDouble(priceText),authorText));
        }

    }
}
