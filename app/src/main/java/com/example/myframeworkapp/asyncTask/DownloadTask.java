package com.example.myframeworkapp.asyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class DownloadTask extends AsyncTask<Void, Integer, String> {

    private static final String TAG = DownloadTask.class.getSimpleName();

    Context context;
    TextView textView;
    Button button;
    ProgressDialog progressDialog;

    public DownloadTask(Context context, TextView textView, Button button) {
        this.context = context;
        this.textView = textView;
        this.button = button;
    }

    @Override
    protected String doInBackground(Void... params) {
        Log.d(TAG, "do in background method" + params);

        int i = 0;
        synchronized (this) {
            while (i < 10) {
                try {
                    wait(1500);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Download complete.......";
        }
    }

    @Override
    protected void onPreExecute() {
        Log.d(TAG, "OnPrExcute Downloading in progress...;");

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Downloading in Progress......");
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();
        //start loading icon;
    }

    @Override
    protected void onPostExecute(String result) {
        Log.d(TAG, "OnPostExecute :after task" + result);

        textView.setText(result);
        button.setEnabled(true);
        progressDialog.hide();

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        Log.d(TAG, "onProgresUpdate" + values);

        int progress = values[0];
        progressDialog.setProgress(progress);
        textView.setText("Downloading in progress........");

    }
}



