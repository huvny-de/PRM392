package huyvn.com.signinformwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUpActivity extends Activity implements View.OnClickListener {
    private EditText txtUsernameSU;
    private EditText txtPasswordSU;
    private EditText txtConfirmPasswordSU;
    private TextView txtAlreadyAcc;
    private Button btnSignUp;

    //Notify
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup
        );

        //Reference to layout
        txtUsernameSU = (EditText) findViewById(R.id.txtUserNameSU);
        txtPasswordSU = (EditText) findViewById(R.id.txtPasswordSU);
        txtAlreadyAcc = (TextView) findViewById(R.id.txtAlreadyAcc);

        btnSignUp = (Button) findViewById(R.id.btnSignUp);

        // Register Event
        txtAlreadyAcc.setOnClickListener(this);

        btnSignUp.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(txtUsernameSU.getText())) {
            txtUsernameSU.setText(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(txtPasswordSU.getText())) {
            txtPasswordSU.setText(REQUIRE);
            return false;
        }

        if (TextUtils.isEmpty(txtConfirmPasswordSU.getText())) {
            txtConfirmPasswordSU.setText(REQUIRE);
            return false;
        }

        if (!TextUtils.equals(txtPasswordSU.getText().toString(), txtConfirmPasswordSU.getText().toString())) {
            Toast.makeText(this, "Password are not match", Toast.LENGTH_LONG).show();
        }

        return true;
    }

    private void signInForm() {
        Intent intent = new Intent(this, SignInActivity.class);
        startActivity(intent);
        finish();
    }


    private void signUp() {
        if (!checkInput()) {
            return;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp:
                signUp();
                break;

            case R.id.txtAlreadyAcc:
                signInForm();
                break;
        }
    }
}