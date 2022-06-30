package huyvn.com.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView txtResult;
    Button btnPlus, btnMinus, btnMul, btnDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.txtNum1);
        number2 = (EditText) findViewById(R.id.txtNum2);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnPlus = (Button) findViewById(R.id.btnCong);
        btnMinus = (Button) findViewById(R.id.btnTru);
        btnMul = (Button) findViewById(R.id.btnNhan);
        btnDivide = (Button) findViewById(R.id.btnChia);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = number1.getText().toString();
                String n2 = number2.getText().toString();
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);
                txtResult.setText(String.valueOf(num1 + num2));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = number1.getText().toString();
                String n2 = number2.getText().toString();
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);
                txtResult.setText(String.valueOf(num1 - num2));
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = number1.getText().toString();
                String n2 = number2.getText().toString();
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);
                txtResult.setText(String.valueOf(num1 * num2));
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n1 = number1.getText().toString();
                String n2 = number2.getText().toString();
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);
                if (num2 != 0 && num1 != 0) {
                    txtResult.setText(String.valueOf(num1 / num2));
                } else {
                    txtResult.setText("Can not divide a number to 0");
                }
            }
        });
    }
}