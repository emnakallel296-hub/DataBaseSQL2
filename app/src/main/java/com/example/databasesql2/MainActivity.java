package com.example.databasesql2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button b1,b2;
    private EditText nom,mail,phone;
    DataBase dbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.save);
        b2=(Button)findViewById(R.id.base);
        nom=(EditText)findViewById(R.id.editText);
        mail=(EditText)findViewById(R.id.mail);
        phone=(EditText)findViewById(R.id.phone);
        dbb=new DataBase(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        b1.setOnClickListener(v->{
            if(!nom.getText().toString().equalsIgnoreCase("")
                    && !mail.getText().toString().equalsIgnoreCase("")
                    && !phone.getText().toString().equalsIgnoreCase(""))
            {
                Boolean inserted=dbb.insertData(nom.getText().toString(),mail.getText().toString(),phone.getText().toString());
                if (inserted)
                    Toast.makeText(MainActivity.this,"Insertion avec succes", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Echec d'insertion",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(MainActivity.this,"Tous les champs doivent etre remplis",Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent int1=new Intent(MainActivity.this,ManagingDB.class);
                startActivity(int1);
            }
        });
    }
}