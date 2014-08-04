package com.example.aomsample;


import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private Boolean isInitComplete = false;
	private AlternateOptionMenu optMenu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		optMenu = new AlternateOptionMenu(MainActivity.this, R.layout.optionmenu_layout, AlternateOptionMenu.NOANIM);
		Dialog d = optMenu.getView();
		ListView lst = (ListView) d.findViewById(R.id.optionsListView);
		final String[] options = {"Option 1","Option 2","Option 3"};
		int[] opt_icons = {R.drawable.ic_dmenu_mvessel,R.drawable.ic_dmenu_new_insp,R.drawable.ic_dmenu_setemail};
		AlternateOptionMenuAdapter lstAdapter = new AlternateOptionMenuAdapter(MainActivity.this,options,opt_icons);
		lst.setAdapter(lstAdapter);
		lst.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				optMenu.toggleDisplay();
				Toast.makeText(getApplicationContext(), "You have selected : "+options[position], Toast.LENGTH_LONG).show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		if(isInitComplete)
		{
			optMenu.toggleDisplay();

		}
		isInitComplete = true;
		return false;
	}
	@Override
	public void onPause() {
		super.onPause();
		optMenu.dismiss();
	}

}
