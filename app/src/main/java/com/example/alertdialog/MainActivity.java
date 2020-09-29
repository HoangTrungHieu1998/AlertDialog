package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.alertdialog.helpers.DialogHelper;

public class MainActivity extends AppCompatActivity {
Button mbtnAlarm;
int mposition = -1;
String mResult ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtnAlarm = findViewById(R.id.btnAlarm);

        mbtnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogHelper dialogHelper = new DialogHelper();
                dialogHelper.showLoginDialog(MainActivity.this);

            }
        });

    }
    private void setDialog(){
        Context context;
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông báo");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setCancelable(false);

        final String[] arrayAnimal = {"Cat","Dog","Bird", "Mouse","Pig"};
        final boolean[] arrayChecked = {false,false,false,false,false};

        //Single choice
                /*/builder.setSingleChoiceItems(arrayAnimal, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position) {
                        mposition = position;
                    }
                });*/

        //Multiple choice
        builder.setMultiChoiceItems(arrayAnimal, arrayChecked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(
                            MainActivity.this,
                            "Bạn đã chọn "+arrayAnimal[which],
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(
                            MainActivity.this,
                            "Bạn bỏ chọn "+arrayAnimal[which],
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Nút có
        builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                        /*if(mposition ==-1){
                            Toast.makeText(
                                    MainActivity.this,
                                    "Bạn chưa chọn",
                                    Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Toast.makeText(
                                MainActivity.this,
                                arrayAnimal[mposition],
                                Toast.LENGTH_SHORT).show();*/
                for (int i = 0; i <arrayChecked.length ; i++) {
                    if(arrayChecked[i]){
                        mResult += arrayAnimal[i] +" , ";

                    }
                    mResult.substring(0,mResult.length()-3);
                    Toast.makeText(MainActivity.this, mResult, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Nút không
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        // Nút huỷ
                /*builder.setNeutralButton("Huỷ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });*/

        builder.show();
    }
}