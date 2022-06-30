package huyvn.com.demopassingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceivedData extends AppCompatActivity {
    TextView txtKetQua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_received_data);
        txtKetQua = (TextView) findViewById(R.id.txtData);
        //
        Intent intent = getIntent();
        String nd = intent.getStringExtra("Du lieu");
        txtKetQua.setText(nd);
    }
}