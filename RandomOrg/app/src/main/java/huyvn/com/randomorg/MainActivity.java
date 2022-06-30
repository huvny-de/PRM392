package huyvn.com.randomorg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText minNum, maxNum;
    Button btnGenerate;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        minNum = (EditText) findViewById(R.id.txtNumMin);
        maxNum = (EditText) findViewById(R.id.txtNumMax);
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        txtResult = (TextView) findViewById(R.id.txtResult);


        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (minNum.getText().toString().trim().length() == 0 || maxNum.getText().toString().trim().length() == 0) {
                    Toast.makeText(MainActivity.this, "Please enter the value for the missing input", Toast.LENGTH_LONG).show();
                    return;
                } else {

                    int minNumVal = Integer.parseInt(minNum.getText().toString());
                    int maxNumVal = Integer.parseInt(maxNum.getText().toString());


                    Random random = new Random();
                    int randomNum = random.nextInt(maxNumVal - minNumVal + 1) + minNumVal;

                    txtResult.setText("Your result : " + String.valueOf(randomNum));
                }
            }
        });
    }

}