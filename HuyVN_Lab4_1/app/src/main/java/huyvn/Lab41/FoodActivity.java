package huyvn.Lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class FoodActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDatMon;
    CheckBox cbPho, cbBunBo, cbMiQuang, cbHuTiu;
    String foodChosen = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        reflect();
    }

    public void reflect() {
        cbPho = (CheckBox) findViewById(R.id.cbPho);
        cbBunBo = (CheckBox) findViewById(R.id.cbBunBo);
        cbMiQuang = (CheckBox) findViewById(R.id.cbMiQuang);
        cbHuTiu = (CheckBox) findViewById(R.id.cbHuTiu);
        btnDatMon = (Button) findViewById(R.id.btnDatMon);
        btnDatMon.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        String txtFood = "";
        switch (v.getId()) {
            case R.id.btnDatMon:
                if (cbPho.isChecked()) {
                    foodChosen += cbPho.getText().toString();
                }

                if (cbBunBo.isChecked()) {
                    foodChosen += cbBunBo.getText().toString();
                }
                if (cbMiQuang.isChecked()) {
                    foodChosen += cbMiQuang.getText().toString();
                }
                if (cbHuTiu.isChecked()) {
                    foodChosen += cbHuTiu.getText().toString();
                }
                break;
        }


        bundle.putString("food", foodChosen);
        // return main activity
        Intent intent = new Intent(FoodActivity.this, MainActivity.class);

        intent.putExtra("FoodChosen", bundle);
        startActivity(intent);
    }
}