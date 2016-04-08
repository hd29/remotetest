package xml_to_html;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XMLToHTML {
	 public static void translate() throws Exception{  
	        //创建XML的文件输入流D:\Users\Administrator\Workspaces\MyEclipse 10\XSLT\WebRoot\xmlToHtml\MyHtml.html
	        FileInputStream fis=new FileInputStream("D:/Users/Administrator/Workspaces/MyEclipse 10/XSLT/WebRoot/xmlToHtml/NewXml.xml");  
	        Source source=new StreamSource(fis);  
	          
	        //创建XSL文件的输入流  
	        FileInputStream fis1=new FileInputStream("D:/Users/Administrator/Workspaces/MyEclipse 10/XSLT/WebRoot/xmlToHtml/MyXslt.xsl");  
	        Source template=new StreamSource(fis1);  
	          
	        PrintStream stm=new PrintStream(new File("D:/Users/Administrator/Workspaces/MyEclipse 10/XSLT/WebRoot/xmlToHtml/result.html"));  
	        Result result=new StreamResult(stm);  
	        //根据XSL文件创建准个转换对象  
	        Transformer transformer=TransformerFactory.newInstance().newTransformer(template);  
	        //处理xml进行交换  
	        transformer.transform(source, result);   
	        //关闭文件流  
	        fis1.close();  
	        fis.close();  
	    }  
	      
	    public static void main(String[] args){  
	        try {  
	            translate();  
	            System.out.println("XML转换成HTML成功！");
	        } catch (Exception e) {  
	            System.out.println("XML转换成HTML失败："+e.getMessage());  
	        }  
	    }  
	
}
