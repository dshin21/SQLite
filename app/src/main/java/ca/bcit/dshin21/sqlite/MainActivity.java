package ca.bcit.dshin21.sqlite;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

//    sql += "CREATE TABLE NAME (";
//    sql += "_id INTEGER PRIMARY KEY AUTOINCREMENT, ";
//    sql += "FirstName TEXT, ";
//    sql += "LastName TEXT, ";
//    sql += "BirthDate NUMERIC, ";
//    sql += "Street TEXT, ";
//    sql += "City TEXT, ";
//    sql += "Province TEXT, ";
//    sql += "PostalCode TEXT, ";
//    sql += "Country TEXT, ";
//    sql += "Latitude INTEGER, ";
//    sql += "Longitude INTEGER, ";
//    sql += "IsNaughty TEXT, ";
//    sql += "DateCreated NUMERIC";
//    sql += ");";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteOpenHelper helper = new DB(this);
        ((DB) helper).insertEntry("John",
                "Doe",
                "2018-11-01",
                "randomStreet",
                "Vancouver",
                "BC",
                "V2Y 111",
                "Canada",
                "120.2",
                "49.0",
                "Y",
                "2018-11-01");

        ((DB) helper).insertEntry("Jane",
                "Doe",
                "2018-11-01",
                "randomStreet",
                "Vancouver",
                "BC",
                "V2Y 111",
                "Canada",
                "120.2",
                "49.0",
                "Y",
                "2018-11-01");

        ((DB) helper).insertEntry("Will",
                "Doe",
                "2018-11-01",
                "randomStreet",
                "Vancouver",
                "BC",
                "V2Y 111",
                "Canada",
                "120.2",
                "49.0",
                "Y",
                "2018-11-01");

        ((DB) helper).insertEntry("Mary",
                "Doe",
                "2018-11-01",
                "randomStreet",
                "Vancouver",
                "BC",
                "V2Y 111",
                "Canada",
                "120.2",
                "49.0",
                "Y",
                "2018-11-01");

        ((DB) helper).insertEntry("Sam",
                "Doe",
                "2018-11-01",
                "randomStreet",
                "Vancouver",
                "BC",
                "V2Y 111",
                "Canada",
                "120.2",
                "49.0",
                "Y",
                "2018-11-01");


        List<String> FirstName = ((DB) helper).getFirstName();
        List<String> LastName = ((DB) helper).getLastName();
        List<String> BirthDate = ((DB) helper).getBirthDay();
        List<String> Street = ((DB) helper).getStreet();
        List<String> City = ((DB) helper).getCity();
        List<String> Province = ((DB) helper).getProvince();
        List<String> PostalCode = ((DB) helper).getPostalCode();
        List<String> Country = ((DB) helper).getCountry();
        List<String> Latitude = ((DB) helper).getLatitude();
        List<String> Longitude = ((DB) helper).getLongitude();
        List<String> IsNaughty = ((DB) helper).getIsNaughty();
        List<String> DateCreated = ((DB) helper).getDateCreated();

        TextView one = findViewById(R.id.one);
        TextView two = findViewById(R.id.two);
        TextView three = findViewById(R.id.three);
        TextView four = findViewById(R.id.four);
        TextView five = findViewById(R.id.five);


        String temp1 = "";
        String temp2 = "";
        String temp3 = "";
        String temp4 = "";
        String temp5 = "";
        String[] temps = new String[]{temp1, temp2, temp3, temp4, temp5};


        for (int i = 0; i < 5; ++i) {
            temps[i] += FirstName.get(i) + " ";
            temps[i] += LastName.get(i) + " ";
            temps[i] += BirthDate.get(i) + " ";
            temps[i] += Street.get(i) + " ";
            temps[i] += City.get(i) + " ";
            temps[i] += Province.get(i) + " ";
            temps[i] += PostalCode.get(i) + " ";
            temps[i] += Country.get(i) + " ";
            temps[i] += Latitude.get(i) + " ";
            temps[i] += Longitude.get(i) + " ";
            temps[i] += IsNaughty.get(i) + " ";
            temps[i] += DateCreated.get(i) + " ";
        }

        one.setText(temps[0]);
        two.setText(temps[1]);
        three.setText(temps[2]);
        four.setText(temps[3]);
        five.setText(temps[4]);

    }
}
