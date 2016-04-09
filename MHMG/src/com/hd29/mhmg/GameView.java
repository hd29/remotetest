package com.hd29.mhmg;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class GameView extends View {

	public GameMainActivity gameMain = null;
	public static int width = 0;
	public static int xoff = 25;
	public static int yoff = 50;

	public final int WALL = 1;
	public final int GOAL = 2;
	public final int ROAD = 3;
	public final int BOX = 4;
	public final int BOX_AT_GOAL = 5;
	public final int WORKER = 6;
	public final int BACK=7;
	public final int UP=8;
	public final int DOWN=9;
	public final int LEFT=10;
	public final int RIGHT=11;
	public final int MUSIC=12;

	public Bitmap pic[] = null;
	private int[][] map = null;
	private int[][] tem =null;
	private int[][] RC =null;
	private int[][] tem1 = new int[6][6];
	private int gate =0;
	private int manRow = 0;
	private int manColumn = 0;
	public int picSize = 30;
	public int row = 0;
	public int column = 0;
	
	
	MediaPlayer m,m1;

	//内部类 
	class CurrentMap{
		int [][] curMap;
		public CurrentMap(int[][] myMap){
			int r=myMap.length;
			int c=myMap[0].length;
			int[][] temp=new int [r][c];
			Log.d("row", String.valueOf(r));
			Log.d("col", String.valueOf(c));
			for(int i=0;i<r;i++)
				for(int j=0;j<c;j++)
					temp[i][j]=myMap[i][j];
			this.curMap=temp;
		}
		public int[][] getMap(){
			return curMap;
		}
	}
  private ArrayList <CurrentMap> list=new ArrayList<CurrentMap>();
	
  
  
 GestureDetector gestureDetector;
 
	
	@SuppressWarnings("deprecation")
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);

		gameMain = (GameMainActivity) context;
		WindowManager win = gameMain.getWindowManager();
		width = win.getDefaultDisplay().getWidth();
		this.setLongClickable(true);
		gestureDetector = new GestureDetector(new OnGestureListener() {

			@Override
			public void onShowPress(MotionEvent arg0) {
			}
			
			@Override
			public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
					float arg3) {
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent arg0) {
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float arg2,
					float arg3) {
				float x = e2.getX() - e1.getX();  
	            float y = e2.getY() - e1.getY();  
	           
	            if(e1.getX()>xoff+6*picSize && e1.getX()<xoff+9*picSize
	            		&& e1.getY()<13*picSize&& e1.getY()>10*picSize){
            		
	            	if (x > 0) {  
	            		spinL(9,6,3);
	            		invalidate();
	            	} else if (x < 0) {  
	            		System.out.println("go righhghjht");  
	            	}  
            	}else if(e1.getX()>xoff+13*picSize && e1.getX()<xoff+16*picSize
	            		&& e1.getY()<9*picSize&& e1.getY()>6*picSize){
            		
	            	if (x > 0) {  
	            		spinL(5,13,3);
	            		invalidate();
	            	} else if (x < 0) {  
	            		System.out.println("go righhghjht");  
	            	}  
            	}else if(e1.getX()>RC[1][1]*picSize && e1.getX()<xoff+(RC[1][1]+RC[1][3])*picSize
	            		&& e1.getY()>RC[1][0]*picSize&& e1.getY()<yoff+(RC[1][0]+RC[1][2])*picSize){
            		if(y>0&&map[RC[1][0]+RC[1][2]][RC[1][1]]==0){
            			moveD(RC[1][0], RC[1][1], RC[1][2], RC[1][3]);
            			RC[1][0]++;
            			invalidate();
            		}else if(y<0&&map[RC[1][0]-1][RC[1][1]]==0){
            			moveU(RC[1][0], RC[1][1], RC[1][2], RC[1][3]);
            			RC[1][0]--;
            			invalidate();
            		}
//            		invalidate();
            	}else if(e1.getX()>RC[0][1]*picSize && e1.getX()<xoff+(RC[0][1]+RC[0][3])*picSize
	            		&& e1.getY()>RC[0][0]*picSize&& e1.getY()<yoff+(RC[0][0]+RC[0][2])*picSize){
            		if(y>0&&map[RC[0][0]+RC[0][2]][RC[0][1]]==0){
            			moveD(RC[0][0], RC[0][1], RC[0][2], RC[0][3]);
            			RC[0][0]++;
            			invalidate();
            		}else if(y<0&&map[RC[1][0]-1][RC[1][1]]==0){
            			moveU(RC[0][0], RC[0][1], RC[0][2], RC[0][3]);
            			RC[0][0]--;
            			invalidate();
            		}
            	}else if(e1.getX()>RC[2][1]*picSize && e1.getX()<xoff+(RC[2][1]+RC[2][3])*picSize
	            		&& e1.getY()>RC[2][0]*picSize&& e1.getY()<yoff+(RC[2][0]+RC[2][2])*picSize){
            		System.out.println(RC[2][0]+""+RC[2][1]+RC[2][3]);
            		if(x>0&&map[RC[2][0]][RC[2][1]+RC[2][3]]==0){
            			moveR(RC[2][0], RC[2][1], RC[2][2], RC[2][3]);
            			System.out.println(RC[2][0]+"aaa"+RC[2][1]+RC[2][3]);
            			RC[2][1]++;
            			invalidate();
            		}else if(x<0&&map[RC[2][0]][RC[2][1]-1]==0){
            			moveL(RC[2][0], RC[2][1], RC[2][2], RC[2][3]);
            			RC[2][1]--;
            			invalidate();
            		}
            	}else if(e1.getX()>xoff+4*picSize && e1.getX()<xoff+8*picSize
	            		&& e1.getY()>1*picSize&& e1.getY()<5*picSize){
            		if(x<0){
            			
            			spinL(2, 4, 3);
            		}else{
            			spinR(2, 4, 3);
            		}
            	}
	            
	            return true;  
			}
			
			@Override
			public boolean onDown(MotionEvent arg0) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean onSingleTapUp(MotionEvent arg0) {
				// TODO Auto-generated method stub
				return false;
			}
		});   
		
		
		
		intMap();
		intPic();
//		initSounds();
		
	}
	
	private void moveD(int row,int col,int height,int width) {
		// TODO Auto-generated method stub

		for (int i = row+height; i > row-1; i--) {
			for (int j = col; j < col+width; j++) {
				if(i>row){
					map[i][j]=map[i-1][j];
					if (map[i][j]==6) {
						manRow=i;
						manColumn=j;
					}
				}else{
					map[i][j]=0;
					
				}
			}
		}
		checkSwitch();
	}
	
	private void moveU(int row,int col,int height,int width) {
		for (int i = row-1; i < row+height; i++) {
			for (int j = col; j < col+width; j++) {
				if(i<row+height-1){
					
					map[i][j]=map[i+1][j];
					if (map[i][j]==6) {
						manRow=i;
						manColumn=j;
					}
				}else{
					map[i][j]=0;
					
				}
			}
		}
		checkSwitch();
	}
	
	private void moveL(int row,int col,int height,int width) {
		for (int i = col-1; i < col+width-1; i++) {
		for (int j = row; j < row+height; j++) {
			
				
				map[j][i]=map[j][i+1];
				if (map[j][i]==6) {
					manRow=j;
					manColumn=i;
				}
			
				
		}
	}
		for (int k = row; k < row+height; k++) {
			
			map[k][col+width-1]=0;
		}
		checkSwitch();
	}
	
	private void moveR(int row,int col,int height,int width) {
		for (int i = col+width; i > col; i--) {
			for (int j = row; j < row+height; j++) {
				
					
					map[j][i]=map[j][i-1];
					if (map[j][i]==6) {
						manRow=j;
						manColumn=i;
					}
				
					
			}
		}
		for (int k = row; k <row+height; k++) {
			
			map[k][col]=0;
		}
		checkSwitch();
	}
	
	private void spinL(int row,int col,int length) {
		//map[9][6]\3
		for (int i = row; i < row+length; i++) {
			for (int j = col; j < col+length; j++) {
				tem1[i-row][j-col]=map[i][j];
			}
		}
		
		for (int i = row; i < row+length; i++) {
			for (int j = col; j < col+length; j++) {
				map[i][j]=tem1[j-col][row+length-1-i];
				if(map[i][j]==6){
					manRow=i;
					manColumn=j;
				}
			}
		}
		
	}
	
	private void spinR(int row,int col,int length) {
		//A
	}
	public void initSounds(){//初始化声音的方法
		/*初始化MediaPlayer对象*/
		
		m = MediaPlayer.create(this.getContext(), R.raw.jimi);
		m.start();
		m1 = MediaPlayer.create(this.getContext(), R.raw.dingdong );
	} 

	public void intMap() {
		// TODO Auto-generated method stub
		map = MapList.getMap(gate);
//		map=MapList.map[gate];
		RC=MapList.moveRowCol[gate];
		// tem=MapList.getMap(gate);
		getMapDetail();
		getManPosition();
	}

	private void getManPosition() {
		// TODO Auto-generated method stub
		for (int i = 0; i < map.length; i++)
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == WORKER) {
					manRow = i;
					manColumn = j;
					break;
				}
			}

	}

	private void getMapDetail() {
		// TODO Auto-generated method stub
		row = map.length;
		column = map[0].length;
		picSize = (int) Math.floor((width - 2 * xoff) / column);
//        RC=MapList.moveRowCol[gate];
		tem = MapList.getMap(gate);
	}

	private void intPic() {
		// TODO Auto-generated method stub
		pic = new Bitmap[13];
		loadPic(WALL, this.getResources().getDrawable(R.drawable.wall));
		loadPic(GOAL, this.getResources().getDrawable(R.drawable.switch1));
		loadPic(ROAD, this.getResources().getDrawable(R.drawable.wall1));
		loadPic(BOX, this.getResources().getDrawable(R.drawable.spin));
		loadPic(BOX_AT_GOAL,this.getResources().getDrawable(R.drawable.spin));
		loadPic(WORKER, this.getResources().getDrawable(R.drawable.manu));
   
		loadPic(BACK, this.getResources().getDrawable(R.drawable.back));
		loadPic(UP, this.getResources().getDrawable(R.drawable.up));
		loadPic(DOWN, this.getResources().getDrawable(R.drawable.down));
		loadPic(LEFT, this.getResources().getDrawable(R.drawable.left));
		loadPic(RIGHT, this.getResources().getDrawable(R.drawable.right));
		loadPic(MUSIC, this.getResources().getDrawable(R.drawable.music));
		
	}

	private void loadPic(int KEY, Drawable dw) {
		// TODO Auto-generated method stub
		Bitmap bm = Bitmap.createBitmap(picSize, picSize,
				Bitmap.Config.ARGB_8888);
		dw.setBounds(0, 0, picSize, picSize);
		Canvas cs = new Canvas(bm);
		dw.draw(cs);
		pic[KEY] = bm;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		Paint paint = new Paint();

		paint.setTextSize(30f);
	    paint.setColor(Color.WHITE);
	   
		canvas.drawText("第"+String.valueOf(gate+1)+"关", width/2-25,yoff , paint);
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++) {
				if (map[i][j] > 0)
					canvas.drawBitmap(pic[map[i][j]], xoff + j * picSize, yoff+ i * picSize, paint);
			}
//		for (int i = manRow-2; i < manRow+3; i++)
//			for (int j = manColumn-2; j < manColumn+3; j++) {
//				if (map[i][j] > 0)
//					canvas.drawBitmap(pic[map[i][j]], xoff + j * picSize, yoff+ i * picSize, paint);
//			}
//		
		canvas.drawBitmap(pic[BACK], xoff +1*picSize, 2*yoff+ row* picSize, paint);
		canvas.drawBitmap(pic[UP], xoff +4*picSize, 2*yoff+ row* picSize, paint);
		canvas.drawBitmap(pic[DOWN], xoff +7*picSize, 2*yoff+ row* picSize, paint);
		canvas.drawBitmap(pic[LEFT], xoff +10*picSize, 2*yoff+ row* picSize, paint);
		canvas.drawBitmap(pic[RIGHT], xoff +13*picSize, 2*yoff+ row* picSize, paint);
		canvas.drawBitmap(pic[MUSIC], xoff +16*picSize, 2*yoff+ row* picSize, paint);
		

		super.onDraw(canvas);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_DPAD_DOWN) {
			moveDown();

		}

		else if (keyCode == KeyEvent.KEYCODE_DPAD_UP) {
			moveUp();

		}

		else if (keyCode == KeyEvent.KEYCODE_DPAD_LEFT) {
			moveLeft();

		}

		else if (keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) {
			moveRight();

		}
		else if(keyCode == KeyEvent.KEYCODE_DPAD_CENTER){
			 backMap();
		}
			
		if (gameIsFinished()) {
			nextGate();

		}
		
		
		invalidate();
		return true;
	}
		

//	
//	 private GestureDetector.OnGestureListener mgestureDetector =   
//			         new GestureDetector.SimpleOnGestureListener() {  
//			        @Override  
//			        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,  
//			                 float velocityY) {  
//			           float x = e2.getX() - e1.getX();  
//			            float y = e2.getY() - e1.getY();  
//			  
//			            if (x > 0) {  
//			            	System.out.println("go right");  
//			            } else if (x < 0) {  
//			            	System.out.println("go righhghjht");  
//			             }  
//			            return true;  
//			       }  
//			     };  

	
	

	private float x=0;
	private float y=0;
	
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
	
		x=event.getX();
		y=event.getY();
		
		if(event.getAction()==MotionEvent.ACTION_DOWN){
			//在图中点触
			if(x>xoff+manColumn*picSize && x<xoff+manColumn*picSize+picSize){
				if(y<yoff+manRow*picSize)
					moveUp();
				
				else if(y>yoff+manRow*picSize+picSize)
				    moveDown();
			   
			}else if(y>yoff+manRow*picSize && y<yoff+manRow*picSize+picSize){
				if(x<xoff+manColumn*picSize)
					moveLeft();
				
				if(x>xoff+manColumn*picSize+picSize)
					moveRight();
			}
		
		}
//		else if(event.getAction()==MotionEvent.ACTION_MOVE){
//			//System.out.println("ACTION_MOVE");
//			gestureDetector.onTouchEvent(event);
//		}
		gestureDetector.onTouchEvent(event);
		//在图标点触
		
		if(y>2*yoff+ row* picSize && y<2*yoff+ row* picSize+picSize){
			if(x> xoff+1*picSize&& x<xoff+2*picSize){
				backMap();
			}
			else if(x> xoff+4*picSize&& x<xoff+5*picSize){
				moveUp();
			}
			else if(x> xoff+7*picSize&& x<xoff+8*picSize){
				moveDown();
			}
			else if(x> xoff+10*picSize&& x<xoff+11*picSize){
				moveLeft();
			}
			else if(x> xoff+13*picSize&& x<xoff+14*picSize){
				moveRight();
			}
			else if(x> xoff+16*picSize&& x<xoff+17*picSize){
			
				if(!m.isPlaying()){
					m.start();//播放声音
			   }else
				   m.pause();
		  }
		}
	
		if (gameIsFinished()) {
			nextGate();

		}
		checkSwitch();
		invalidate();
		
		return super.onTouchEvent(event);
	}
	

	//返回上一步
	private void backMap(){
		if(list.size()>0){
			CurrentMap priMap=list.get(list.size()-1);
			map=priMap .getMap();
			getManPosition();
			list.remove(list.size()-1);
			
		}
		else
			Toast.makeText(this.getContext(), "You can't back the game!", Toast.LENGTH_LONG).show();
	}
	
	private void storeMap(int [][] maps){
		CurrentMap curMap=new CurrentMap(maps);
		list.add(curMap);
		if(list.size()>10)
			list.remove(0);
	}
	
	private boolean gameIsFinished() {
		// TODO Auto-generated method stub
		boolean gameFinsh = true;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				if (map[i][j] == BOX)
					gameFinsh = false;

		return gameFinsh;
	}

	
	private void nextGate() {
		// TODO Auto-generated method stub
		
		if(MapList.getCount()==gate+1){
			AlertDialog.Builder builder=new AlertDialog.Builder(gameMain);
			builder.setTitle("哇！你太棒了！您已通全关了"); 
			builder.setMessage("重新玩还是退出?"); 
			builder.setPositiveButton("重新", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					gate=0;
					intMap();
					invalidate();
				}
				
			});
			builder.setNegativeButton("退出", new DialogInterface.OnClickListener(){

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					gameMain.finish();//结束游戏
					//m.stop(); //关闭背景音乐
				}
				
			});
			builder.create();
			builder.show();
		}
		
		else{
			gate++;
			//m1.start();//闯关音乐欢呼声响起
			intMap();
		}
		
		
	}

	private void moveDown() {
		// TODO Auto-generated method stub
		if (map[manRow + 1][manColumn] == ROAD) {
				storeMap(map);
				checkSwitch();
				map[manRow + 1][manColumn] = WORKER;
				map[manRow][manColumn] = ROAD;
				manRow++;
				return;
		} else if( map[manRow+1][manColumn] == BOX_AT_GOAL) {
			storeMap(map);
			
			map[manRow+1][manColumn] = WORKER;
			map[manRow][manColumn] = ROAD;
			manRow++;
			return;
	}
	}

	private void moveUp() {
		// TODO Auto-generated method stub
		if (map[manRow - 1][manColumn] == ROAD) {
			storeMap(map);
			checkSwitch();
			map[manRow - 1][manColumn] = WORKER;
			map[manRow][manColumn] = ROAD;
			manRow--;
			return;
	} else if( map[manRow - 1][manColumn] == BOX_AT_GOAL) {
			storeMap(map);
			checkSwitch();
			map[manRow - 1][manColumn] = WORKER;
			map[manRow][manColumn] = ROAD;
			manRow--;
			return;
	}
	}

	private void moveLeft() {
		// TODO Auto-generated method stub
		if (map[manRow][manColumn-1] == ROAD) {
			storeMap(map);
			checkSwitch();
			map[manRow][manColumn-1] = WORKER;
			map[manRow][manColumn] = ROAD;
			manColumn--;
			return;
	} else if( map[manRow][manColumn-1] == BOX_AT_GOAL) {
		storeMap(map);
		map[manRow][manColumn-1] = WORKER;
		map[manRow][manColumn] = ROAD;
		manColumn--;
		return;
     }else if( map[manRow][manColumn-1] == LEFT) {
		nextGate();
			return;
	}
	}

	private void moveRight() {
		// TODO Auto-generated method stub
		if (map[manRow][manColumn+1] == ROAD) {
			storeMap(map);
			checkSwitch();
			map[manRow][manColumn+1] = WORKER;
			map[manRow][manColumn] = ROAD;
			manColumn++;
			return;
	} else if( map[manRow][manColumn+1] == BOX_AT_GOAL) {
			storeMap(map);
			
			map[manRow][manColumn+1] = WORKER;
			map[manRow][manColumn] = ROAD;
			manColumn++;
			return;
	}
	}
	
	private void checkSwitch(){
		if(map[7][7]!=5){
			if(map[8][9]!=6)
			map[8][9]=3;
		}
        if(map[18][10]!=5){
        	if(map[15][11]!=6)
			map[15][11]=3;
		}
	}
	
}
