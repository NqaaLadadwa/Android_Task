package com.todo.a1180629nqaaziadladadwa;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE BOAT(ID INTEGER PRIMARY KEY AUTOINCREMENT,BOAT_NAME TEXT, COLOR TEXT)");
        sqLiteDatabase.execSQL("CREATE TABLE SAILOR(ID INTEGER PRIMARY KEY AUTOINCREMENT,SAILOR_NAME TEXT, NATIONALITY TEXT,BOAT_ID INTEGER, FOREIGN KEY(BOAT_ID) REFERENCES BOAT(_ID))");

    }
    public void insertBoat(Boat boat) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("BOAT_NAME", boat.getmBoatName());
        contentValues.put("COLOR", boat.getmColor());
        sqLiteDatabase.insert("BOAT", null, contentValues);
    }
    public void insertSailor(Sailor sailor) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SAILOR_NAME", sailor.getmSailorName());
        contentValues.put("NATIONALITY", sailor.getmNationality());
        contentValues.put("BOAT_ID", sailor.getmBoatId());
        sqLiteDatabase.insert("SAILOR", null, contentValues);
    }
    public Cursor getAllBoats() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM BOAT", null);
    }

    public Cursor getAllSailors() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM SAILOR", null);
    }
    public Cursor getNumOfPalestinianSailors() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        return sqLiteDatabase.rawQuery("select COUNT (*) from SAILOR WHERE NATIONALITY='Palestinian'", null);
    }
    public Cursor getNumOfJordanianSailors() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("select COUNT (*) from SAILOR WHERE NATIONALITY='Jordanian'", null);

    }
    public Cursor getNumOfQatariSailors() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        return sqLiteDatabase.rawQuery("select COUNT (*) from SAILOR WHERE NATIONALITY='Qatari'", null);
    }


    public Cursor getRedBoats() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT BOAT_NAME FROM BOAT WHERE COLOR='Red'", null);
    }


    public Cursor getPalestinianAndRedBoats() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT SAILOR_NAME, BOAT.ID FROM SAILOR, BOAT WHERE SAILOR.BOAT_ID = BOAT.ID AND NATIONALITY='Palestinian' AND COLOR='Red'", null);
    }


    public void insertDummyBoat(String mBoatName,String mColor ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("BOAT_NAME", mBoatName);
        contentValues.put("COLOR", mColor);
        sqLiteDatabase.insert("BOAT", null, contentValues);
    }
    public void insertDummySailor(String mSailorName,String mNationality, int mBoatId ) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("SAILOR_NAME", mSailorName);
        contentValues.put("NATIONALITY", mNationality);
        contentValues.put("BOAT_ID", mBoatId);
        sqLiteDatabase.insert("SAILOR", null, contentValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase,  int oldVersion, int newVersion) {

    }


}
