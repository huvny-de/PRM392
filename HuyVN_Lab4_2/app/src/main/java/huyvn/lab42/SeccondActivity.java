package huyvn.lab42;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SeccondActivity extends AppCompatActivity {

    TextView txtInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccond);

        txtInfo = findViewById(R.id.txtInformation);

        Intent intent = getIntent();

        Student student = (Student) intent.getSerializableExtra("student");

        txtInfo.setText(student.getHoten()+ "\n"+ student.getEmail() + "\n" + student.getNamsinh());
    }
}