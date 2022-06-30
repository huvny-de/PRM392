package huyvn.com.signinformwork;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUsernameSI;
    private EditText txtPasswordSI;
    private TextView txtNonAccYet;
    private Button btnSignIn;

    //Notify
    private final String REQUIRE = "Require";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        //Reference to layout
        txtUsernameSI = (EditText) findViewById(R.id.txtUsernameSI);
        txtPasswordSI = (EditText) findViewById(R.id.txtPasswordSI);
        txtNonAccYet = (TextView) findViewById(R.id.txtNonAccYet);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);

        // Register Event
        txtNonAccYet.setOnClickListener(this);

        btnSignIn.setOnClickListener(this);
    }

    private boolean checkInput() {
        if (TextUtils.isEmpty(txtUsernameSI.getText())) {
            txtUsernameSI.setText(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(txtPasswordSI.getText())) {
            txtPasswordSI.setText(REQUIRE);
            return false;
        }

        return true;
    }

    private void signIn() {
        if(!checkInput()) {
            return;
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
        finish();
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                signIn();
                break;

            case R.id.txtNonAccYet:
                signUpForm();
                break;
        }
    }
}
