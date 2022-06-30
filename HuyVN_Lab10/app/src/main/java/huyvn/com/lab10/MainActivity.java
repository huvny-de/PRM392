package huyvn.com.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import huyvn.com.lab10.Api.TraineeRepository;
import huyvn.com.lab10.Api.TraineeService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TraineeService traineeService;
    EditText etname, etemail,  etphone, etgioitinh;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etname = findViewById(R.id.txtName);
        etemail = findViewById(R.id.txtEmail);
        etphone = findViewById(R.id.txtPhone);
        etgioitinh = findViewById(R.id.txtGioiTinh);
        btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);
        traineeService = TraineeRepository.getTraineeSerice();
    }

    @Override
    public void onClick(View v) {

    }

    private void save(){
        String name = etname.getText().toString();
        String email = etemail.getText().toString();
        String phone = etphone.getText().toString();
        String gender = etgioitinh.getText().toString();

        Trainee trainee
    }

}