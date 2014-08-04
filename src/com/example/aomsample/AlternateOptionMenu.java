package com.example.aomsample;

import android.app.Activity;
import android.app.Dialog;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class AlternateOptionMenu {

	private Activity activity;
	private Dialog dialog = null;
	private int layoutid;
	private int animationid;
	
	public static int NOANIM = 0;
	
	public AlternateOptionMenu(Activity act,int lid,int animid)
	{
		activity = act;
		layoutid = lid;
		animationid = animid;
		if(animationid!=NOANIM)
			dialog= new Dialog(activity,animationid);
		else
			dialog= new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.setContentView(layoutid);
				
		Window window = dialog.getWindow();
		WindowManager.LayoutParams wlp = window.getAttributes();
		wlp.verticalMargin = 0;
		wlp.gravity = Gravity.BOTTOM;
		wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
		window.setAttributes(wlp);
		
	}
	public Dialog getView()
	{
		return dialog;
	}
	public void show()
	{
		if(dialog!=null)
			dialog.show();
	}
	public void dismiss()
	{
		if(dialog!=null&&dialog.isShowing())
			dialog.dismiss();
	}
	public void toggleDisplay()
	{
		if(dialog!=null)
		{
			if(dialog.isShowing())
				dialog.dismiss();
			else
				dialog.show();
		}
	}
}
