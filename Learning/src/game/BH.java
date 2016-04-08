package game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BH extends Frame{
	
	private int playX ;
	private int playY ;
	
	int [][] map ={
			
			{1,1,4,1,4,1,0,0,4,0,0},
			{2,2,2,2,2,2,2,2,2,2,1},
			{2,3,3,2,2,3,2,2,2,2,1},
			{2,2,4,2,2,2,3,2,2,2,1},
			{2,2,4,2,2,3,4,4,3,2,1},
			{2,3,4,3,2,5,2,4,4,2,1},
			{2,2,4,2,3,2,3,2,2,2,1},
			{2,3,4,2,2,2,3,2,2,2,1}
	};

	private BH() {
		// TODO Auto-generated method stub

		this.setSize(550, 400);
		this.setVisible(true);
		
		this.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			if(e.getKeyCode()==37){
				if(map[playX][playY-1]==2){
					mapAdd(1);	
					map[playX][playY-1]=5;
				}
			}else if(e.getKeyCode()==38){
				if(map[playX-1][playY]==2){
					mapAdd(2);	
					map[playX-1][playY]=5;
				}
			}else if(e.getKeyCode()==39){
				if(map[playX][playY+1]==2){
					mapAdd(3);	
					map[playX][playY+1]=5;
				}
			}else if(e.getKeyCode()==40){
				if(map[playX+1][playY]==2){
					mapAdd(4);	
					map[playX+1][playY]=5;
				}
			}
			repaint();
			System.out.println(e.getKeyCode());
			
		}

		
		});
			
		
	}
	
	private void mapAdd(int n) {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++) 
			for (int j = 0; j < map[0].length; j++) 
					map[i][j] = (map[i][j]+n)%5;
	}

		
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
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
				g.fillRect(j*50, i*50, 50, 50);

			}
		}
	}
	
//	@Override
//	public void repaint() {
//		// TODO Auto-generated method stub
//		super.repaint();
//	}
//	
	public static void main(String[] args) {
		new BH();
	}
}
