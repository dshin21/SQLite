package ca.bcit.dshin21.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    private static final String DB_NAME = "NAME_DB.sqlite";
    private static final int DB_VERSION = 1;
    private Context context;

    public DB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(db);
    }

    private String createTable() {
        String sql = "";
        sql += "CREATE TABLE People (";
        sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
        sql += "FirstName TEXT, ";
        sql += "LastName TEXT, ";
        sql += "BirthDate TEXT, ";
        sql += "Street TEXT, ";
        sql += "City TEXT, ";
        sql += "Province TEXT, ";
        sql += "PostalCode TEXT, ";
        sql += "Country TEXT, ";
        sql += "Latitude INTEGER, ";
        sql += "Longitude INTEGER, ";
        sql += "IsNaughty TEXT, ";
        sql += "DateCreated TEXT";
        sql += ");";

        return sql;
    }

    public long insertEntry(String firstName, String lastName, String birthday, String street, String city, String province,
                            String postalCode, String country, String lat, String lng, String isNaughty, String dateCreated) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("FirstName", firstName);
        values.put("LastName", lastName);
        values.put("BirthDate", birthday);
        values.put("Street", street);
        values.put("City", city);
        values.put("Province", province);
        values.put("PostalCode", postalCode);
        values.put("Country", country);
        values.put("Latitude", lat);
        values.put("Longitude", lng);
        values.put("IsNaughty", isNaughty);
        values.put("DateCreated", dateCreated);
        long id = db.insert("People", null, values);
        db.close();

        return id;
    }

    public List<String> getFirstName() {
        String selectQuery = "SELECT FirstName FROM " + "People";

        return getHelper(selectQuery, "FirstName");
    }

    public List<String> getLastName() {
        String selectQuery = "SELECT LastName FROM " + "People";

        return getHelper(selectQuery, "LastName");
    }

    public List<String> getBirthDay() {
        String selectQuery = "SELECT BirthDate FROM " + "People";

        return getHelper(selectQuery, "BirthDate");
    }

    public List<String> getStreet() {
        String selectQuery = "SELECT Street FROM " + "People";

        return getHelper(selectQuery, "Street");
    }

    public List<String> getCity() {
        String selectQuery = "SELECT City FROM " + "People";

        return getHelper(selectQuery, "City");
    }

    public List<String> getProvince() {
        String selectQuery = "SELECT Province FROM " + "People";

        return getHelper(selectQuery, "Province");
    }

    public List<String> getPostalCode() {
        String selectQuery = "SELECT PostalCode FROM " + "People";

        return getHelper(selectQuery, "PostalCode");
    }

    public List<String> getCountry() {
        String selectQuery = "SELECT Country FROM " + "People";

        return getHelper(selectQuery, "Country");
    }

    public List<String> getLatitude() {
        String selectQuery = "SELECT Latitude FROM " + "People";

        return getHelper(selectQuery, "Latitude");
    }

    public List<String> getLongitude() {
        String selectQuery = "SELECT Longitude FROM " + "People";

        return getHelper(selectQuery, "Longitude");
    }

    public List<String> getIsNaughty() {
        String selectQuery = "SELECT IsNaughty FROM " + "People";

        return getHelper(selectQuery, "IsNaughty");
    }

    public List<String> getDateCreated() {
        String selectQuery = "SELECT DateCreated FROM " + "People";

        return getHelper(selectQuery, "DateCreated");
    }

    public List<String> getHelper(String selectQuery, String columnName) {
        List<String> temp = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                temp.add(cursor.getString(cursor.getColumnIndex(columnName)));
            } while (cursor.moveToNext());
        }

        db.close();

        return temp;
    }
}
