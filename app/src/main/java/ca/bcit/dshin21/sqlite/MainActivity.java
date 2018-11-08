package ca.bcit.dshin21.sqlite;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteOpenHelper helper = new DB(this);
        ((DB) helper).insertName("John");
        ((DB) helper).insertName("Jane");
        ((DB) helper).insertName("Mary");
        ((DB) helper).insertName("Dave");
        ((DB) helper).insertName("Bob");

        List<String> names = ((DB) helper).getNames();

        TextView one = findViewById(R.id.one);
        one.setText(names.get(0));

        TextView two = findViewById(R.id.two);
        two.setText(names.get(1));

        TextView three = findViewById(R.id.three);
        three.setText(names.get(2));

        TextView four = findViewById(R.id.four);
        four.setText(names.get(3));

        TextView five = findViewById(R.id.five);
        five.setText(names.get(4));
    }
}
