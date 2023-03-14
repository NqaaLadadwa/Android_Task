package com.todo.a1180629nqaaziadladadwa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    LinearLayout secondLinearLayout;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayout firstLinearLayout=new LinearLayout(this);
        Button addBoatButton =new Button(this);
        secondLinearLayout=new LinearLayout(this);
        Button addSailorButton =new Button(this);
        Button redBoatsButton =new Button(this);
        Button numOfSailorsButton =new Button(this);
        Button palestinianAndRedButton =new Button(this);


        ScrollView scrollView=new ScrollView(this);

        firstLinearLayout.setOrientation(LinearLayout.VERTICAL);
        secondLinearLayout.setOrientation(LinearLayout.VERTICAL);


        addBoatButton.setText("Add Boat");
        addBoatButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        addSailorButton.setText("Add Sailor");
        addSailorButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        numOfSailorsButton.setText("Numbers of Sailors' Nationalities");
        numOfSailorsButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        redBoatsButton.setText("Names of Red Boats");
        redBoatsButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        palestinianAndRedButton.setText(" Palestinian sailors with red boats");
        palestinianAndRedButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT));


        firstLinearLayout.addView(addBoatButton);
        firstLinearLayout.addView(addSailorButton);
        firstLinearLayout.addView(numOfSailorsButton);
        firstLinearLayout.addView(redBoatsButton);
        firstLinearLayout.addView(palestinianAndRedButton);


        scrollView.addView(secondLinearLayout);
        firstLinearLayout.addView(scrollView);

        setContentView(firstLinearLayout);

        SharedPreferences shPref = getSharedPreferences("shPref",MODE_PRIVATE);
        boolean mainPage = shPref.getBoolean("mainPage", true);

        if(mainPage){
            showData();
        }


        addBoatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddBoatActivity.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

        addSailorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddSailorActivity.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });

        redBoatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper =new DataBaseHelper(MainActivity.this,"M1180629", null,1);
                Cursor allBoatsCursor = dataBaseHelper.getAllBoats();
                secondLinearLayout.removeAllViews();
                while (allBoatsCursor.moveToNext()){
                    TextView textView =new TextView(MainActivity.this);
                    textView.setText(
                            "BoatName= "+allBoatsCursor.getString(1)
                                    +"\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }
            }
        });
        numOfSailorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper =new DataBaseHelper(MainActivity.this,"M1180629", null,1);
                Cursor allSailorsCursor = dataBaseHelper.getNumOfPalestinianSailors();
                Cursor allSailorsCursor2 = dataBaseHelper.getNumOfJordanianSailors();
                Cursor allSailorsCursor3 = dataBaseHelper.getNumOfQatariSailors();
                secondLinearLayout.removeAllViews();
                while (allSailorsCursor.moveToNext()){
                    TextView textView =new TextView(MainActivity.this);
                    textView.setText(
                            "Number Of Palestinian Sailors= " + allSailorsCursor.getString(0)
                                    + "\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }
                while (allSailorsCursor2.moveToNext()){
                    TextView textView =new TextView(MainActivity.this);
                    textView.setText(
                            "Number Of Jordanian Sailors= " + allSailorsCursor2.getString(0)
                                    + "\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }
                while (allSailorsCursor3.moveToNext()){
                    TextView textView =new TextView(MainActivity.this);
                    textView.setText(
                            "Number Of Qatari Sailors= " + allSailorsCursor3.getString(0)
                                    + "\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }
            }
        });

        redBoatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper =new DataBaseHelper(MainActivity.this,"M1180629", null,1);
                Cursor allBoatsCursor = dataBaseHelper.getRedBoats();
                secondLinearLayout.removeAllViews();
                while (allBoatsCursor.moveToNext()){
                    TextView textView =new TextView(MainActivity.this);
                    textView.setText(
                            "BoatName= "+allBoatsCursor.getString(0)
                                    +"\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }
            }
        });

        palestinianAndRedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper =new DataBaseHelper(MainActivity.this,"M1180629", null,1);
                Cursor allBoatsCursor = dataBaseHelper.getPalestinianAndRedBoats();
                secondLinearLayout.removeAllViews();
                while (allBoatsCursor.moveToNext()){
                    TextView textView =new TextView(MainActivity.this);
                    textView.setText(
                            "SailorName= "+allBoatsCursor.getString(0)
                                    +"\n\n"
                    );
                    secondLinearLayout.addView(textView);
                }
            }
        });

    }

    private void showData(){
       dataBaseHelper = new DataBaseHelper(MainActivity.this, "M1180629", null, 1);
       dataBaseHelper.insertDummyBoat("Boat1", "Blue");
       dataBaseHelper.insertDummyBoat("Boat2", "Red");
       dataBaseHelper.insertDummyBoat("Boat3", "White");
       dataBaseHelper.insertDummyBoat("Boat4", "Black");
       dataBaseHelper.insertDummyBoat("Boat5", "Red");
       dataBaseHelper.insertDummyBoat("Boat6", "Blue");
       dataBaseHelper.insertDummyBoat("Boat7", "Red");
       dataBaseHelper.insertDummyBoat("Boat8", "White");
       dataBaseHelper.insertDummyBoat("Boat9", "Red");
       dataBaseHelper.insertDummyBoat("Boat10", "Red");
       dataBaseHelper.insertDummyBoat("Boat11", "Black");



       dataBaseHelper.insertDummySailor("Nqaa", "Palestinian", 1);
       dataBaseHelper.insertDummySailor("Ziad", "Jordanian", 2);
       dataBaseHelper.insertDummySailor("Mohammad", "Qatari", 3);
       dataBaseHelper.insertDummySailor("Abdallah", "Palestinian", 4);
       dataBaseHelper.insertDummySailor("Yaqoub", "Jordanian", 5);
       dataBaseHelper.insertDummySailor("Shaymaa", "Qatari", 6);
       dataBaseHelper.insertDummySailor("Misk", "Palestinian", 7);
       dataBaseHelper.insertDummySailor("Ameer", "Palestinian", 8);
       dataBaseHelper.insertDummySailor("Ayham", "Palestinian", 9);
       dataBaseHelper.insertDummySailor("Yazan", "Palestinian", 10);
       dataBaseHelper.insertDummySailor("Tala", "Qatari", 11);




        SharedPreferences shPref = getSharedPreferences("shPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = shPref.edit();
        editor.putBoolean("mainPage", false);
        editor.apply();
    }
    protected void onResume() {
        super.onResume();
        DataBaseHelper dataBaseHelper =new DataBaseHelper(MainActivity.this,"M1180629", null,1);
        Cursor allBoatsCursor = dataBaseHelper.getAllBoats();
        Cursor allSailorsCursor = dataBaseHelper.getAllSailors();

        secondLinearLayout.removeAllViews();
        while (allBoatsCursor.moveToNext()){
            TextView textView =new TextView(MainActivity.this);
            textView.setText(
                    "BoatId= "+allBoatsCursor.getString(0)
                            +"\nBoatName= "+allBoatsCursor.getString(1)
                            +"\nBoatColor= "+allBoatsCursor.getString(2)
                            +"\n\n"
            );
            secondLinearLayout.addView(textView);
        }
        while (allSailorsCursor.moveToNext()) {
            TextView textView = new TextView(MainActivity.this);
            textView.setText(
                    "SailorId= " + allSailorsCursor.getString(0)
                            + "\nSailorName= " + allSailorsCursor.getString(1)
                            + "\nSailorNationality= " + allSailorsCursor.getString(2)
                            + "\nBoatId= " + allSailorsCursor.getString(3)
                            + "\n\n"
            );
            secondLinearLayout.addView(textView);

        }
    }

}
