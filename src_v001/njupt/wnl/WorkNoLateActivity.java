package njupt.wnl;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.content.pm.ActivityInfo;

/**
 * 游戏的主类，负责切换视图
 * 
 * @author qu
 *
 */
public class WorkNoLateActivity extends Activity {
	View current;		//当前界面
	//LoadingView lv;	//加载界面
	HelpView helpview;	//帮助界面
	
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
        
        helpview = new HelpView(this);
        setContentView(helpview);
        current = helpview;
        
    }
}