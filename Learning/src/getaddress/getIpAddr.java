package getaddress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class getIpAddr{
	
	public static String getAddressByIP(){  
		String addr = null;
		String strIP = "192.168.10.64";   
		URL url = null;
		try {
			url = new URL(
					"http://ip.qq.com/cgi-bin/searchip?searchip1=" + strIP);

			URLConnection conn = url.openConnection(); 
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(conn.getInputStream(), "GBK"));  
			String line = null;

			StringBuffer result = new StringBuffer();  
			Logger logger = Logger.getLogger(getIpAddr.class.getName()) ;
			logger.log(Level.INFO,"����");
			while((line = reader.readLine()) != null)    { 
				result.append(line);  
			}     

			reader.close(); 
			strIP = result.substring(result.indexOf( "��IP���ڵ�Ϊ��" )); 
			strIP = strIP.substring(strIP.indexOf( "��") + 1);  
			String province = strIP.substring(6, strIP.indexOf("ʡ"));
			String city = strIP.substring(strIP.indexOf("ʡ") + 1, strIP.indexOf("��"));  
			addr = province + city;
			return addr;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    

		return addr;
	}	
	
	public static void main(String[] args) {
		String resultAddr = getAddressByIP();
		System.out.println(resultAddr);
	}
}	
