package huyvn.com.lab10;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

import huyvn.com.lab10.Api.TraineeRepository;
import huyvn.com.lab10.Api.TraineeService;
import huyvn.com.lab10.Model.Trainee;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TraineeService traineeService;
    Button btnCreate, btnUpdate, btnView, btnDelete;

    ArrayList<Trainee> listTrainee;
    TraineeAdapter traineeAdapter;
    ListView listViewTrainee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(v -> create());

        btnUpdate = findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(v -> update());

        btnView = findViewById(R.id.btnView);
        btnView.setOnClickListener(v -> view());

        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(v -> delete());

        traineeService = TraineeRepository.getTraineeSerice();
    }

    @Override
    protected void onStart() {
        super.onStart();
        view();
    }

    private void view() {
        try {
            Call<Trainee[]> call = traineeService.getAllTrainees();
            call.enqueue(new Callback<Trainee[]>() {
                @Override
                public void onResponse(Call<Trainee[]> call, Response<Trainee[]> response) {
                    Trainee[] trainees = response.body();
                    if (trainees == null || trainees.length == 0) {
                        setTraineeAdapter(trainees);
                        Toast.makeText(MainActivity.this, "No record", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    setTraineeAdapter(trainees);
                    Toast.makeText(MainActivity.this, "Get latest data successfully", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Trainee[]> call, Throwable t) {
                }
            });
        } catch (Exception e) {
            Log.d("Error on view :", e.getMessage());
        }
    }

    private void create() {
        Trainee trainee = getTraineeFromLayout();
        try {
            Call<Trainee> call = traineeService.createTrainees(trainee);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.body() != null) {
                        if (response.body() != null) {
                            Toast.makeText(MainActivity.this, "Create successfully", Toast.LENGTH_LONG).show();
                            view();
                        } else if (response.code() == 404) {
                            Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Unknown Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Create fail", Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            Log.d("Error on create :", e.getMessage());
        }
    }

    private void update() {
        String id = ((EditText) findViewById(R.id.txtId)).getText().toString();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "Update required Id", Toast.LENGTH_SHORT).show();
            return;
        }
        Trainee trainee = getTraineeFromLayout();
        try {
            Call<Trainee> call = traineeService.updateTrainees(id, trainee);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.body() != null) {
                        Toast.makeText(MainActivity.this, "Update successfully", Toast.LENGTH_LONG).show();
                        traineeAdapter.notifyDataSetChanged();
                        view();
                    } else if (response.code() == 404) {
                        Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Unknown Error", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Not Found", Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            Log.d("Error on update :", e.getMessage());
        }
    }

    private void delete() {
        String id = ((EditText) findViewById(R.id.txtId)).getText().toString();
        if (TextUtils.isEmpty(id)) {
            Toast.makeText(this, "Delete required Id", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            Call<Trainee> call = traineeService.deleteTrainees(id);
            call.enqueue(new Callback<Trainee>() {
                @Override
                public void onResponse(Call<Trainee> call, Response<Trainee> response) {
                    if (response.body() != null) {
                        Toast.makeText(MainActivity.this, "Delete successfully", Toast.LENGTH_LONG).show();
                        view();
                    } else if (response.code() == 404) {
                        Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Unknown Error", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Trainee> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Delete fail", Toast.LENGTH_LONG).show();
                }
            });
        } catch (Exception e) {
            Log.d("Error on delete :", e.getMessage());
        }
    }

    private void setTraineeAdapter(Trainee[] trainees) {
        listTrainee = new ArrayList<>();
        Collections.addAll(listTrainee, trainees);
        listViewTrainee = findViewById(R.id.listTrainee);
        traineeAdapter = new TraineeAdapter(MainActivity.this, listViewTrainee.getId(), listTrainee);
        traineeAdapter.notifyDataSetChanged();
        listViewTrainee.setAdapter(traineeAdapter);
    }

    private Trainee getTraineeFromLayout() {
        String name = ((EditText) findViewById(R.id.txtName)).getText().toString();
        String email = ((EditText) findViewById(R.id.txtEmail)).getText().toString();
        String phone = ((EditText) findViewById(R.id.txtPhone)).getText().toString();
        String gender = ((EditText) findViewById(R.id.txtGender)).getText().toString();
        return new Trainee(name, email, phone, gender);
    }

}