package njupt.wnl;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.MotionEvent;
import android.graphics.Rect;
import android.content.pm.ActivityInfo;

import njupt.wnl.view.*;

/**
 * ��Ϸ�����࣬�����л���ͼ
 * 
 * @author qu
 *
 */
public class WorkNoLateActivity extends Activity {
	View current;		//��ǰ����
	//LoadingView lv;	//���ؽ���
	WelcomeView welcomeview;	//��ӭ����
	HelpView helpview;	//��������
	
	Rect rectStart;		//��ʼ��Ϸ��ť
	Rect rectHelp;		//������ť
	Rect rectExit;		//�˳���ť
	Rect rectReturn;	//�������淵�ذ�ť
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);		 	 //����ȫ��
        getWindow().setFlags(
        		WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN
        		);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//ǿ��Ϊ����
        
        welcomeview = new WelcomeView(this);
        setContentView(welcomeview);
        current = welcomeview;
        
        initRect();
    }
    
    //��ʼ����ť�ľ��ο�
    public void initRect() {
    	rectStart = new Rect(0,0,0,0);
    	rectHelp = new Rect(100, 100, 180, 140);
    	rectExit = new Rect(0,0,0,0);
    	rectReturn = new Rect(100, 100, 180, 140);
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {//��дonTouchEvent����
    	if(event.getAction()== MotionEvent.ACTION_UP){//�ж��¼�����
    		int x = (int)event.getX();
    		int y = (int)event.getY();
    		if(current == welcomeview){
    			if(rectHelp.contains(x, y)){
    				helpview = new HelpView(this);
    				this.setContentView(helpview);
    				this.current = helpview;
    			}
    			
    		}else if(current == helpview){
    			if(rectReturn.contains(x, y)){
    				welcomeview = new WelcomeView(this);
    				this.setContentView(welcomeview);
    				this.current = welcomeview;
    			}
    		}
    	}
    	return true;
    }
}