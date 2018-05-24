package com.example.android.databaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.databaseapp.Contract.GuestDBHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    GuestDBHelper guestDBHelper;
    @BindView(R.id.idEditText)
    EditText idText;
    @BindView(R.id.NameEditText)
    EditText nameEditText;
    @BindView(R.id.CompanyEditText)
    EditText companyEditText;
    @BindView(R.id.TypeEditText)
    EditText typeEditText;
    @BindView(R.id.SaveButton)
    Button saveButton;
    @BindView(R.id.NextButton)
    Button nextButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        guestDBHelper= new GuestDBHelper(this);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=guestDBHelper.getWritableDatabase();
                String Id=idText.getText().toString();
                String Name=nameEditText.getText().toString();
                String Company=companyEditText.getText().toString();
                String Type=typeEditText.getText().toString();
                guestDBHelper.AddGuestInfo(Id,Name,Company,Type,db);
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                idText.setText("");
                nameEditText.setText("");
                companyEditText.setText("");
                typeEditText.setText("");

            }
        });
    }
}
