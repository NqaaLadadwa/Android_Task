package com.todo.a1180629nqaaziadladadwa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddSailorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sailor);


        String[] options = {"Palestinian", "Jordanian", "Qatari"};
        final Spinner nationalitySpinner =(Spinner) findViewById(R.id.spinner_Nationality);
        ArrayAdapter<String> objNationalityArr = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, options);
        nationalitySpinner.setAdapter(objNationalityArr);

        final EditText boatIdEditText = (EditText)findViewById(R.id.editText_BoatId);
        final EditText sailorNameEditText = (EditText)findViewById(R.id.editText_SailorName);

        Button addSailorButton = (Button) findViewById(R.id.button_Add_Sailor);
        Button return2Button = (Button) findViewById(R.id.button_Return2);


        addSailorButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Sailor newSailor = new Sailor();

                if(boatIdEditText.getText().toString().isEmpty()) newSailor.setmBoatId(0);
                else newSailor.setmBoatId(Integer.parseInt(boatIdEditText.getText().toString()));

                if(sailorNameEditText.getText().toString().isEmpty()) newSailor.setmSailorName("No Name");
                else newSailor.setmSailorName(sailorNameEditText.getText().toString());

                newSailor.setmNationality(nationalitySpinner.getSelectedItem().toString());


                //EXPERIMENT 4
                DataBaseHelper dataBaseHelper =new DataBaseHelper(AddSailorActivity.this,"M1180629",null,1);
                dataBaseHelper.insertSailor(newSailor);



                Intent intent=new Intent(AddSailorActivity.this,MainActivity.class);
                AddSailorActivity.this.startActivity(intent);
                finish();
            }
        });

        return2Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AddSailorActivity.this,MainActivity.class);
                AddSailorActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}