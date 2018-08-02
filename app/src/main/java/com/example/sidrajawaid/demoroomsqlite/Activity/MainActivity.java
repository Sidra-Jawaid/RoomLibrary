package com.example.sidrajawaid.demoroomsqlite.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sidrajawaid.demoroomsqlite.R;
import com.example.sidrajawaid.demoroomsqlite.database.AppDatabase;
import com.example.sidrajawaid.demoroomsqlite.utils.DatabaseInitializer;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AppDatabase appDatabase;
        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DatabaseInitializer.populateAsync(AppDatabase.getAppDatabase(getApplicationContext()));
                DatabaseInitializer.populateSync(AppDatabase.getAppDatabase(getApplicationContext()));

            }
        });
    }
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
