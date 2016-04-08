package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class MapTest extends JFrame{
	
	private int playX ; 
	private int playY ; 

	public int[][][] intMap(){
		int [][][] map ={
				  
				{
					{1,1,1,1,9,1,1,1,1,1,1,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,3,3,3,2,1,3,3,3,3,3,1,1,1,9,0,0,0,0,0,1},
					{4,3,3,3,3,2,4,3,3,3,3,3,1,1,1,9,0,0,0,0,0,1},
					{2,3,3,3,3,2,1,3,3,3,3,3,0,0,0,0,0,0,0,0,0,1},
					{1,3,3,3,3,2,1,3,3,0,3,3,0,1,1,9,0,0,0,0,0,1},
					{2,2,2,0,2,2,2,4,3,0,3,3,0,1,1,9,9,9,9,9,9,9},
					{4,2,1,0,3,1,0,0,0,0,2,1,0,1,1,9,1,1,1,1,1,1},
					{2,3,3,0,3,2,0,2,3,2,4,1,0,1,1,9,0,0,0,0,0,1},
					{1,3,3,0,0,0,0,4,2,0,1,1,0,1,1,9,0,0,0,0,0,1},
					{1,1,1,1,1,1,0,1,3,2,4,1,0,0,0,0,0,0,0,0,0,1},
					{4,3,3,3,3,1,0,1,4,0,2,1,1,1,1,9,0,0,0,0,0,1},
					{2,3,3,3,3,3,3,3,3,2,4,1,1,1,1,9,0,0,0,0,1,1},
					{1,3,3,3,3,3,3,3,2,0,1,1,1,1,1,9,0,0,0,0,0,1},
					{2,3,3,3,3,3,3,3,3,2,4,1,1,1,1,9,0,0,0,0,1,1},
					{4,2,1,2,3,1,4,2,4,0,2,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,4,3,2,0,3,1,3,2,1,1,1,1,1,9,1,1,1,1,1,1}
				},
				
				{
					{1,1,1,1,9,1,1,1,1,1,1},
					{2,3,1,4,0,2,1,2,0,2,1},
					{4,1,3,2,2,3,4,3,2,0,1},
					{2,3,4,1,4,2,1,2,3,2,4},
					{1,2,3,2,0,2,3,4,2,0,1},
					{2,3,4,3,2,5,2,4,3,2,4},
					{4,2,1,2,3,1,4,2,4,0,2},
					{2,3,4,3,2,0,3,1,3,2,1}
				},
				
				{
					{1,1,1,1,9,1,1,1,1,1,1,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,3,3,3,2,1,2,0,2,1,1,1,1,1,9,1,1,1,1,1,1},
					{4,3,3,3,3,3,4,3,2,0,1,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,3,3,3,2,1,2,3,2,4,1,1,1,1,9,1,1,1,1,1,1},
					{1,3,3,3,3,2,3,4,2,0,1,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,4,3,2,5,2,4,3,2,4,1,1,1,1,9,1,1,1,1,1,1},
					{4,2,1,2,3,1,4,2,4,0,2,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,3,3,3,2,1,2,3,2,4,1,1,1,1,9,1,1,1,1,1,1},
					{1,3,3,3,3,2,3,4,2,0,1,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,4,3,2,5,2,4,3,2,4,1,1,1,1,9,1,1,1,1,1,1},
					{4,2,1,2,3,1,4,2,4,0,2,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,3,3,3,2,1,2,3,2,4,1,1,1,1,9,1,1,1,1,1,1},
					{1,3,3,3,3,2,3,4,2,0,1,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,4,3,2,5,2,4,3,2,4,1,1,1,1,9,1,1,1,1,1,1},
					{4,2,1,2,3,1,4,2,4,0,2,1,1,1,1,9,1,1,1,1,1,1},
					{2,3,4,3,2,0,3,1,3,2,1,1,1,1,1,9,1,1,1,1,1,1}
				}
		};
		
		return map;
	}
	private int gate = 0;
	private int [][] map;
	private MapTest() {
		// TODO Auto-generated method stub

		this.setTitle("BHMG");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		map = intMap()[gate];
	
		this.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			if(e.getKeyCode()==37){
				gate--;
				map = intMap()[gate];
			}else if(e.getKeyCode()==39){
				gate++;
				map = intMap()[gate];
			}
			repaint();
			
		}
		
		});
				
	}
	
	
		
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLUE);
		g.fillRect(50, 30, 50, 50);
		g.setColor(Color.green);
		g.fillRect(150, 30, 50, 50);
		g.setColor(Color.black);
		g.fillRect(250, 30, 50, 50);
		g.setColor(Color.yellow);
		g.fillRect(350, 30, 50, 50);
		g.setColor(Color.red);
		g.fillRect(450, 30, 50, 50);
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				
				if(map[i][j]==1){
					g.setColor(Color.BLUE);
				}else if(map[i][j]==2){
					g.setColor(Color.green);
				}else if(map[i][j]==3){
					g.setColor(Color.black);
				}else if(map[i][j]==4){
					g.setColor(Color.yellow);
				}else if(map[i][j]==5){
					g.setColor(Color.PINK);
					playX = i;
					playY = j;
				}else{
					g.setColor(Color.red);
				}
				g.fillRect(j*30, i*30+100, 30, 30);

			}
		}
	}
	
	public static void main(String[] args) {
		new MapTest();
	}
}
