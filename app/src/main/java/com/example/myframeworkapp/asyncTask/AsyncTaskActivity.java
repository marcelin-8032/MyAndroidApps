package com.example.myframeworkapp.asyncTask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myframeworkapp.OptionMenuActivity;
import com.example.myframeworkapp.R;

public class AsyncTaskActivity extends OptionMenuActivity {

    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        textView=(TextView)findViewById(R.id.textView);
        button=(Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DownloadTask  downloadTask=new DownloadTask(AsyncTaskActivity.this, textView, button);
                downloadTask.execute();
            }
        });
    }
}

