package huyvn.com.lab9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<CongViec> listCV;
    private CongViecAdapter adapter;
    private Database db;
    private ListView lvCV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listCV = new ArrayList<>();
        lvCV = (ListView) findViewById(R.id.lvCongviec);
        adapter = new CongViecAdapter(MainActivity.this, R.layout.dynamic_congviec, listCV);
        lvCV.setAdapter(adapter);

        db = new Database(MainActivity.this, "congviec.sqlite", null, 1);


        db.execSQL("create table if not exists CongViec(id integer primary key autoincrement, " +
                "congviec nvarchar(256))");


        db.execSQL("delete from CongViec");

        if (listCV.size() > 0) {
            listCV = new ArrayList<>();
        }

        getDataCongViec();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_congviec, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menuAdd) {
            showAddDialog();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showAddDialog() {


        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_add_cv);

        EditText ednTen = (EditText) dialog.findViewById(R.id.editTxtUpd);
        Button btnAdd = dialog.findViewById(R.id.btnConfirm);
        Button btnCancel = dialog.findViewById(R.id.btnCancel);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenCV = ednTen.getText().toString();
                if (tenCV.equals("")) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc !", Toast.LENGTH_SHORT).show();
                } else {
                    db.execSQL("Insert into CongViec values (null, '" + tenCV + "')");
                    Toast.makeText(MainActivity.this, "Đã Thêm", Toast.LENGTH_LONG).show();
                    dialog.dismiss();
                    getDataCongViec();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private void getDataCongViec() {
        Cursor dataCV = db.queryDataSQL("select * from CongViec");
        listCV.clear();
        while (dataCV.moveToNext()) {
            String congviec = dataCV.getString(1);
            System.out.println(congviec);
            int id = dataCV.getInt(0);
            listCV.add(new CongViec(id, congviec));
        }
        ;


        adapter.notifyDataSetChanged();
    }

    public void DialogUpdateCongViec(String congviec, int id) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_update_cv);

        EditText edtUpd = (EditText) dialog.findViewById(R.id.editTxtUpd);
        Button btnConfirm = (Button) dialog.findViewById(R.id.btnConfirm);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancel);

        edtUpd.setText(congviec);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenmoi = edtUpd.getText().toString().trim();
                String sql = "Update CongViec set congviec = "+ tenmoi + " Where id = "+ id;
                db.execSQL(sql);
                Toast.makeText(MainActivity.this, "Đã Cập Nhật", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                getDataCongViec();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void DialogXoaCongViec(String congviec, int id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage("Bạn có muốn xóa công việc " + congviec + " này không ?");
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String sql = "DELETE FROM CongViec where id = "+id;
                db.execSQL(sql);
                Toast.makeText(MainActivity.this,"Đã Xóa" + congviec,Toast.LENGTH_SHORT).show();
                getDataCongViec();
            }
        });

        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();


    }
}