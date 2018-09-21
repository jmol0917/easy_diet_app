package comp5216.sydney.edu.au.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        final EditText etUserName = (EditText) findViewById(R.id.edUserName);
        final EditText etAge = (EditText) findViewById(R.id.edAge);
        final EditText etWeight = (EditText) findViewById(R.id.edWeight);
        final EditText etHeight = (EditText) findViewById(R.id.edHeight);
        //fill this line with a value for ACTIVITY

        final TextView welcome = (TextView) findViewById(R.id.welcomeTxt);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);
        double weight = intent.getDoubleExtra("weight", -1);
        double height = intent.getDoubleExtra("height", -1);

        String message = name + " welcome to your user area";
        welcome.setText(message);
        etUserName.setText(username);
        etAge.setText(age + "");
        etWeight.setText(weight + "");
        etHeight.setText(height + "");
    }
}
