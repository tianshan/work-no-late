package njupt.wnl;

import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.Context;
import android.widget.TextView;

/**
 * 游戏中的帮助界面
 * 
 * @author qu
 *
 */
public class HelpView extends SurfaceView  implements SurfaceHolder.Callback{
	
	WorkNoLateActivity father;		//Activity的引用
	private SurfaceHolder holder;
	private MyThread thread;		//画图线程
	
	public HelpView(WorkNoLateActivity father){
		super(father);
		this.father = father;
		holder = this.getHolder();
		holder.addCallback(this);	//添加Callback接口
		
		thread = new MyThread(holder);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		thread.isRun = true;
		thread.start();
	}
	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		thread.isRun = false;
	}
}

class MyThread extends Thread{	//画图线程
	
	boolean isRun;
	private SurfaceHolder holder;
	
	public MyThread(SurfaceHolder holder){
		this.holder = holder;
	}
	@Override
	public void run(){
		while (isRun) {
			Paint paint = new Paint();
			paint.setColor(Color.BLUE);
			paint.setTextSize(20f);
			
			Canvas canvas = null;
			try{
				canvas = holder.lockCanvas();
				canvas.drawColor(Color.WHITE);	//清屏幕
				canvas.drawText("helpview", 100, 100, paint);
			}catch(Exception ex){
			}finally{
				if(canvas != null)
					holder.unlockCanvasAndPost(canvas);  //将画好的画布提交
			}
        }
	}
}
