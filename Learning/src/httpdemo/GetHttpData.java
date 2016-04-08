package httpdemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import sun.io.Converters;

public class GetHttpData {
	//发送一个GET请求
	static int count = 0;
	public static String get(String path) throws Exception{
		HttpURLConnection httpConn=null;
		BufferedReader in=null;
		try {
			URL url=new URL(path);
			httpConn=(HttpURLConnection)url.openConnection();

			//读取响应
			if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
				StringBuffer content=new StringBuffer();
				String tempStr="";
				in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
				while((tempStr=in.readLine())!=null){
					content.append(tempStr+"\n");
				}
				return content.toString();
			}else{
				throw new Exception("请求出现了问题!");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			in.close();
			httpConn.disconnect();
		}
		return null;
	}
 //发送一个GET请求,参数形式key1=value1&key2=value2...
	public static String post(String path,String params) throws Exception{
		HttpURLConnection httpConn=null;
		BufferedReader in=null;
		PrintWriter out=null;
		try {
			URL url=new URL(path);
			httpConn=(HttpURLConnection)url.openConnection();
			
			httpConn.setRequestMethod("POST");
//			设置输入输出请求为真
			httpConn.setDoInput(true);
			httpConn.setDoOutput(true);

			//发送post请求参数
			out=new PrintWriter(httpConn.getOutputStream());
			out.println(params);
			out.flush();

			//读取响应
			if(httpConn.getResponseCode()==HttpURLConnection.HTTP_OK){
				StringBuffer content=new StringBuffer();
				String tempStr="";
				in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
				while((tempStr=in.readLine())!=null){
					content.append(tempStr);
				}
				return content.toString();
			}else{
				throw new Exception("请求出现了问题!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			in.close();
			out.close();
			httpConn.disconnect();
		}
		return null;
	}
    
	public static String getM(String path) throws IOException {

		StringBuffer context = new StringBuffer();
		String str = null;
		HttpURLConnection con = null;
		BufferedReader br = null;
//		String path = "";
		try {
			
			URL url = new URL(path);
			con = (HttpURLConnection) url.openConnection();
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK){
				br = new BufferedReader(
						new InputStreamReader(
								con.getInputStream()));
				while ((str = br.readLine())!=null) {
					context.append(str);
				}
			}
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			br.close();
			con.disconnect();
		}
		return context.toString();
		
	}
	
	public static void filterCode(String code) throws IOException {
		 String resMessage=GetHttpData.getM(
				 "http://hq.sinajs.cn/list="+code);
//			String resMessage=GetHttpData.post(
//					"http://localhost:8080/SSH/action_delete", "id=3");
//			System.out.println(resMessage);
			String[] array = new String[1111];
			array = resMessage.split(",");
			if(array.length>2){
				double d = Double.parseDouble(array[2]);
				
			if(d<15.00){
				count++;
			System.out.println("========================================");
//			for (String str : array) {
//				System.out.println(str);
//			}
			System.out.println(array[0]);
			System.out.println(d);
			}
			}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("running!");
		for (int i = 1000; i < 3000; i++) {
			filterCode("sh60"+i);
			filterCode("sz00"+i);
		}
		for (int i = 100; i < 999; i++) {
			filterCode("sz000"+i);
			filterCode("sh600"+i);
		}
		for (int i = 10; i < 99; i++) {
			filterCode("sz0000"+i);
			filterCode("sh6000"+i);
		}
		System.out.println("总共查到"+count+"条信息");
	}

}
