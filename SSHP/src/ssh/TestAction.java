package ssh;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	private String name ;
	private File file;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() {
		  System.out.println(name);
		  if(file!=null){
			  try {
				uploadFile(file) ;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		  }
		  if(name.equals("aaaaaaaa")){
				return "success";
			}else{
				return "errHandler";
			}
		}
	public String register() {
		// TODO Auto-generated method stub
		System.out.println(name);
		if(name.equals("aaaaaaaa")){
			return "success";
		}else{
			return "errHandler";
//			return "exception";
		}
	}
	
	public void validateExecute() {
		System.out.println(1111);
		// TODO Auto-generated method stub
		System.out.println("validate()方法执行");
		if(name == null || name.length()<6 || name.length()>15){
			this.addFieldError("name","错误提示：用户名不正确！");
			addActionError("dd");
		}
	}
//	验证表单
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		super.validate();
		System.out.println(2111);
		// TODO Auto-generated method stub
		System.out.println("validate()方法执行");
		if(name == null || name.length()<6 || name.length()>15){
			this.addFieldError("name","错误提示：用户名不正确！");
			addActionError("ddd");
			addActionMessage("ddd");
		}
	}
	
	private void uploadFile(File file) throws FileNotFoundException, IOException {
        try {
            InputStream in = new FileInputStream(file);
//            String dir = ServletActionContext.getRequest().getRealPath(UPLOADDIR);
            File uploadFile = new File("text.text");
            OutputStream out = new FileOutputStream(uploadFile);
            byte[] buffer = new byte[1024 * 1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
 
            in.close();
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
