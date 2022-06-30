package huyvn.Lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;


public class BeverageActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatNuoc;
    CheckBox cbPepsi, cbHeineken, cbTiger, cbSaiGonDo;
    String DrinkChosen = "";
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);

        reflect();

    }

    private void reflect() {

        cbPepsi = (CheckBox) findViewById(R.id.cbPepsi);
        cbHeineken = (CheckBox) findViewById(R.id.cbHeineken);
        cbTiger = (CheckBox) findViewById(R.id.cbTiger);
        cbSaiGonDo = (CheckBox) findViewById(R.id.cbSaiGonDo);

        btnDatNuoc = (Button) findViewById(R.id.btnDatNuoc);


        btnDatNuoc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        String txtBeverage = "";
        switch (v.getId()) {
            case R.id.btnDatNuoc:
                if (cbPepsi.isChecked()) {
                    DrinkChosen += cbPepsi.getText().toString();
                }

                if (cbHeineken.isChecked()) {
                    DrinkChosen += cbHeineken.getText().toString();
                }

                if (cbTiger.isChecked()) {
                    DrinkChosen += cbTiger.getText().toString();
                }
                if (cbSaiGonDo.isChecked()) {
                    DrinkChosen += cbSaiGonDo.getText().toString();
                }
                break;
        }

        String foodChosen = getIntent().getBundleExtra("bundle_main").getString("foodChosen");
        count = getIntent().getBundleExtra("bundle_main").getInt("count");

        foodChosen += " - " + DrinkChosen;
        bundle.putString("allChosen", foodChosen);
        bundle.putInt("count", 1);


        // return main activity
        Intent intent = new Intent(BeverageActivity.this, MainActivity.class);

        intent.putExtra("BeverageChosen", bundle);
        startActivity(intent);
    }
}