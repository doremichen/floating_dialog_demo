package com.adam.app.floatingwindowdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends Activity {

    private AlertDialog mDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mDialog = this.CustDialog(this.getApplicationContext());
        mDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
    }

    public void onShowWindow(View v) {
        
        mDialog.show();
    }
    
    private AlertDialog CustDialog(Context context) {
        
        AlertDialog.Builder builder;
        
        builder = new AlertDialog.Builder(this.getApplicationContext());
        builder.setTitle("Floating dialog");
        builder.setMessage("Click to exit this dialog");
        builder.setCancelable(false);
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        
        AlertDialog dialog = builder.create();
        
        return dialog;
    }
}
