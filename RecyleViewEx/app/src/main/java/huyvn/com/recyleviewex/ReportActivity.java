package huyvn.com.recyleviewex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {
    ArrayList<Report> reportList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        RecyclerView rvReport = findViewById(R.id.rvReport);

        reportList = new ArrayList<>();
        reportList.add(new Report("ListView trong Android", "ListView trong android là một thành phần dùng để nhóm nhiều mục (item) bbbbbbbbbbbbbbbbbb", R.drawable.android, "Android"));
        reportList.add(new Report("Xử lí sự kiện trong iOS", "Xử lý sự kiện trong iOS. Sau khi các bạn đã biết cách thiết kế giao diện cho các ứng dụng bbbbbbbbbbbb", R.drawable.ios, "iOS"));
        reportList.add(new Report("Apple", "Apple zzzzzzzz", R.drawable.download, "Apple"));
        reportList.add(new Report("AWS", "Amazon Web Services", R.drawable.aws, "AWS"));

        ReportAdapter adapter = new ReportAdapter(reportList);

        rvReport.setAdapter(adapter);

        rvReport.setLayoutManager(new LinearLayoutManager(this));
    }
}