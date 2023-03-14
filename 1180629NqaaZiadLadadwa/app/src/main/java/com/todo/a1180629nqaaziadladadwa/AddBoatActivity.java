package com.todo.a1180629nqaaziadladadwa;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddBoatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat);

        String[] options = { "Red", "Blue", "White", "Black" };
        final Spinner colorSpinner =(Spinner) findViewById(R.id.spinner_Color);
        ArrayAdapter<String> objColorArr = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item, options);
        colorSpinner.setAdapter(objColorArr);

        final EditText boatNameEditText = (EditText)findViewById(R.id.editText_boatName);

        Button addBoatButton = (Button) findViewById(R.id.button_Add_Boat);
        Button returnButton = (Button) findViewById(R.id.button_Return);


        addBoatButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Boat newBoat = new Boat();

                if(boatNameEditText.getText().toString().isEmpty()) newBoat.setmBoatName("No Name");
                else newBoat.setmBoatName(boatNameEditText.getText().toString());

                newBoat.setmColor(colorSpinner.getSelectedItem().toString());


                DataBaseHelper dataBaseHelper =new DataBaseHelper(AddBoatActivity.this,"M1180629",null,1);
                dataBaseHelper.insertBoat(newBoat);

                Intent intent=new Intent(AddBoatActivity.this,MainActivity.class);
                AddBoatActivity.this.startActivity(intent);
                finish();
            }
        });

        returnButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent=new Intent(AddBoatActivity.this,MainActivity.class);
                AddBoatActivity.this.startActivity(intent);
                finish();
            }
        });



    }

}
