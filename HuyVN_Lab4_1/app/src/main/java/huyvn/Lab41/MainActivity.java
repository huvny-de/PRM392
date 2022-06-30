package huyvn.Lab41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnFood, btnBeverage, btnExit;
    TextView txtResult;
    int count = 0;
    String foodChosen = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reflect();
    }

    public void reflect(){
        btnFood = (Button) findViewById(R.id.btnFood);
        btnBeverage = (Button) findViewById(R.id.btnBeverage);
        btnExit = (Button) findViewById(R.id.btnExit);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnFood.setOnClickListener(this);
        btnBeverage.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFood:
                Intent food_intent = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(food_intent);
                break;
            case R.id.btnBeverage:
                Intent beverage_intent = new Intent(MainActivity.this, BeverageActivity.class);
                Bundle food_bundle = getIntent().getBundleExtra("FoodChosen");
                Bundle bundle = new Bundle();
                if (food_bundle != null) {
                    foodChosen = food_bundle.getString("food");
                    bundle.putString("foodChosen", foodChosen);
                    bundle.putInt("count", 1);
                    beverage_intent.putExtra("bundle_main", bundle);
                }
                count = 1;
                startActivity(beverage_intent);
                break;
            case R.id.btnExit:
                MainActivity.this.finish();
                System.exit(0);
                break;
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Bundle beverage_bundle = getIntent().getBundleExtra("BeverageChosen");
        Bundle food_bundle = getIntent().getBundleExtra("FoodChosen");
        if (food_bundle != null) {
            foodChosen = food_bundle.getString("food");
        }
        if (beverage_bundle != null) {
            count = beverage_bundle.getInt("count");
        }
        if (count == 0) {
            txtResult.setText(foodChosen);
        } else {
            if (beverage_bundle != null) {
                String allChosen = "";
                allChosen = beverage_bundle.getString("allChosen");
                txtResult.setText(allChosen);
            }
        }
    }
}