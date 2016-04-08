package httpdemo;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UI_HttpReq {
   Frame frame = new Frame();
   Label label = new Label("ID:");
   Label result = new Label("result");
   TextField IDValue = new TextField();
   Button btn = new Button("Ã·Ωª");
   public UI_HttpReq() {

	   frame.setTitle("Requery");
	   frame.setSize(266,222);
	   frame.setLayout(null);
	  
	   label.setBounds(33, 66, 22, 22);
	   result.setBounds(33, 122, 62, 22);
	   IDValue.setBounds(66, 66, 166, 22);
	   btn.setBounds(200, 96, 32, 22);
	   
	   frame.add(label);
	   frame.add(result);
	   frame.add(IDValue);
	   frame.add(btn);
	   frame.setLocationRelativeTo(null);
	   frame.setVisible(true);
	   
	   btn.addMouseListener(new MouseListener() {
		
		public void mouseReleased(MouseEvent arg0) {
			
		}
		
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			String str = IDValue.getText();
			IDValue.setText("");
			System.out.println(str);
			try {
				String ruselt = GetHttpData.post(
						"http://localhost:8080/SSH/action_delete","id="+Integer.parseInt(str));
				result.setText(ruselt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
	   
   }
   public static void main(String[] args) {
	new UI_HttpReq();
}
}
