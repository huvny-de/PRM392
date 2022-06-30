package huyvn.com.arraylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvSubject;
    ArrayList<String> arrCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvSubject = (ListView) findViewById(R.id.listView1);
        arrCourse = new ArrayList<>();
        arrCourse.add("Android");
        arrCourse.add("IOS");
        arrCourse.add("PHP");
        arrCourse.add("Cocos2dx");
        arrCourse.add("Unity3d");
        arrCourse.add("Wordpress");
        arrCourse.add("Asp .net");
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrCourse);
        lvSubject.setAdapter(adapter);

        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
              //  Toast.makeText(MainActivity.this, arrCourse.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtNewCourse.setText(listCourse.get(position));
                indexUpdate = position;
            }
        });
    }
}