package com.example.sidrajawaid.demoroomsqlite.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sidrajawaid.demoroomsqlite.R;
import com.example.sidrajawaid.demoroomsqlite.database.AppDatabase;
import com.example.sidrajawaid.demoroomsqlite.entity.User;
import com.example.sidrajawaid.demoroomsqlite.utils.DatabaseInitializer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
Button btn,btn2,btn3,btn4;
EditText ed1,ed2,ed3;
TextView tv;
    List<User> newlist=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppDatabase appDatabase;
        btn=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        ed1=findViewById(R.id.editText1);
        ed2=findViewById(R.id.editText2);
        ed3=findViewById(R.id.editText3);
        tv=findViewById(R.id.textView);
        //show
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(getApplicationContext()));
                DatabaseInitializer.showData(AppDatabase.getAppDatabase(getApplicationContext()));

                newlist=DatabaseInitializer.showData(AppDatabase.getAppDatabase(getApplicationContext()));
                String details="";
                for (int i=0;i<=newlist.size()-1;i++) {
                    details=i+"- "+newlist.get(i).getFirstName().toString()+"  "+newlist.get(i).getLastName().toString()+"  "+newlist.get(i).getAge()+"\n";

                }
                tv.setText(details);
                Toast.makeText(MainActivity.this," showed",Toast.LENGTH_SHORT).show();

            }
        });
        //save
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(getApplicationContext()));
                String e1=ed1.getText().toString();
                String e2=ed2.getText().toString();
                int e3= Integer.parseInt(ed3.getText().toString());
                DatabaseInitializer.saveData(AppDatabase.getAppDatabase(getApplicationContext()),e1,e2,e3);
                Toast.makeText(MainActivity.this,"saved",Toast.LENGTH_SHORT).show();

            }
        });
        //delete
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1=ed1.getText().toString();
                DatabaseInitializer.deleteData(AppDatabase.getAppDatabase(getApplicationContext()),e1);
                Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_SHORT).show();

            }
        });
        //Edit
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(getApplicationContext()));
                String e1=ed1.getText().toString();
                String e2=ed2.getText().toString();
                int e3= Integer.parseInt(ed3.getText().toString());
                DatabaseInitializer.editData(AppDatabase.getAppDatabase(getApplicationContext()),e1,e2,e3);
                Toast.makeText(MainActivity.this,"edited",Toast.LENGTH_SHORT).show();

            }
        });
    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
