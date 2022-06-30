package huyvn.lab63;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnChonMau;
    ConstraintLayout manHinh;

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menuDo:manHinh.setBackgroundColor(Color.RED);
                break;
            case R.id.menuVang:manHinh.setBackgroundColor(Color.YELLOW);
                break;
            case R.id.menuXanh:manHinh.setBackgroundColor(Color.BLUE);
                break;

        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        //Set icon nếu cho context_menu
        /* // menu.setHeaderTitle("Chọn màu");
        //menu.setHeaderIcon(R.drawable.ic_launcher_background);
         */
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChonMau= (Button) findViewById(R.id.button_Chonmau);
        manHinh = (ConstraintLayout) findViewById(R.id.manHinh);
        // đăng ký view cho context_menu
        registerForContextMenu(btnChonMau);
    }
}