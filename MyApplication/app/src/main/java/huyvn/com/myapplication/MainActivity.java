package huyvn.com.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText username, fullname, email;
    Button btnConfirm;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.textView);
        fullname = (EditText) findViewById(R.id.textView2);
        email = (EditText) findViewById(R.id.textView3);
        btnConfirm = (Button) findViewById(R.id.button);
        txtResult = (TextView) findViewById(R.id.textView4);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String em = email.getText().toString();
                String fname = fullname.getText().toString();

                txtResult.setText("Username: " + uname + "\nEmail: " + em + "\nFullname: " + fname);

            }
        });

    }
}