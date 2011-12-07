package njupt.wnl.view;

import njupt.wnl.WorkNoLateActivity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * ��Ϸ�Ļ�ӭ���棬״̬ѡ��
 * 
 * @author qu
 *
 */

public class WelcomeView  extends SurfaceView  implements SurfaceHolder.Callback{
	
	WorkNoLateActivity father;		//Activity������
	private SurfaceHolder holder;
	private WeThread thread;		//��ͼ�߳�
	
	public WelcomeView(WorkNoLateActivity father){
		super(father);
		this.father = father;
		holder = this.getHolder();
		holder.addCallback(this);	//���Callback�ӿ�
		
		thread = new WeThread(holder);
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

class WeThread extends Thread{	//��ͼ�߳�
	
	boolean isRun;
	private SurfaceHolder holder;
	
	public WeThread(SurfaceHolder holder){
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
				canvas.drawColor(Color.WHITE);	//����Ļ
				canvas.drawRect(100,100,180,140,paint);
				//canvas.drawText("helpview", 100, 100, paint);
			}catch(Exception ex){
			}finally{
				if(canvas != null)
					holder.unlockCanvasAndPost(canvas);  //�����õĻ����ύ
			}
        }
	}
}

