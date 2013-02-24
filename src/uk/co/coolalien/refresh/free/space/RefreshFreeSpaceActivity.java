package uk.co.coolalien.refresh.free.space;

import java.io.File;

import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.app.Activity;
import android.text.format.Formatter;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;



public class RefreshFreeSpaceActivity extends Activity {
	TextView display;
	RefreshFreeSpaceActivity me = this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button);
        display = (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				File path = Environment.getDataDirectory();
				StatFs stat = new StatFs(path.getPath());
				long blockSize = stat.getBlockSize();
				long availableBlocks = stat.getAvailableBlocks();
				display.setText(Formatter.formatFileSize(me, availableBlocks * blockSize));
			}
			
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
