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
 * 游戏的主类，负责切换视图
 * 
 * @author qu
 *
 */
public class WorkNoLateActivity extends Activity {
	View current;		//当前界面
	//LoadingView lv;	//加载界面
	WelcomeView welcomeview;	//欢迎界面
	HelpView helpview;	//帮助界面
	
	Rect rectStart;		//开始游戏按钮
	Rect rectHelp;		//帮助按钮
	Rect rectExit;		//退出按钮
	Rect rectReturn;	//帮助界面返回按钮
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);		 	 //设置全屏
        getWindow().setFlags(
        		WindowManager.LayoutParams.FLAG_FULLSCREEN,
        		WindowManager.LayoutParams.FLAG_FULLSCREEN
        		);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
        
        welcomeview = new WelcomeView(this);
        setContentView(welcomeview);
        current = welcomeview;
        
        initRect();
    }
    
    //初始化按钮的矩形框
    public void initRect() {
    	rectStart = new Rect(0,0,0,0);
    	rectHelp = new Rect(100, 100, 180, 140);
    	rectExit = new Rect(0,0,0,0);
    	rectReturn = new Rect(100, 100, 180, 140);
    }
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {//复写onTouchEvent方法
    	if(event.getAction()== MotionEvent.ACTION_UP){//判断事件类型
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