package njupt.wnl;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.content.pm.ActivityInfo;

/**
 * ��Ϸ�����࣬�����л���ͼ
 * 
 * @author qu
 *
 */
public class WorkNoLateActivity extends Activity {
	View current;		//��ǰ����
	//LoadingView lv;	//���ؽ���
	HelpView helpview;	//��������
	
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
        
        helpview = new HelpView(this);
        setContentView(helpview);
        current = helpview;
        
    }
}