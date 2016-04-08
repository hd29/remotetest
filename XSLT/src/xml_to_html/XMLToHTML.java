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
	        //����XML���ļ�������D:\Users\Administrator\Workspaces\MyEclipse 10\XSLT\WebRoot\xmlToHtml\MyHtml.html
	        FileInputStream fis=new FileInputStream("D:/Users/Administrator/Workspaces/MyEclipse 10/XSLT/WebRoot/xmlToHtml/NewXml.xml");  
	        Source source=new StreamSource(fis);  
	          
	        //����XSL�ļ���������  
	        FileInputStream fis1=new FileInputStream("D:/Users/Administrator/Workspaces/MyEclipse 10/XSLT/WebRoot/xmlToHtml/MyXslt.xsl");  
	        Source template=new StreamSource(fis1);  
	          
	        PrintStream stm=new PrintStream(new File("D:/Users/Administrator/Workspaces/MyEclipse 10/XSLT/WebRoot/xmlToHtml/result.html"));  
	        Result result=new StreamResult(stm);  
	        //����XSL�ļ�����׼��ת������  
	        Transformer transformer=TransformerFactory.newInstance().newTransformer(template);  
	        //����xml���н���  
	        transformer.transform(source, result);   
	        //�ر��ļ���  
	        fis1.close();  
	        fis.close();  
	    }  
	      
	    public static void main(String[] args){  
	        try {  
	            translate();  
	            System.out.println("XMLת����HTML�ɹ���");
	        } catch (Exception e) {  
	            System.out.println("XMLת����HTMLʧ�ܣ�"+e.getMessage());  
	        }  
	    }  
	
}
