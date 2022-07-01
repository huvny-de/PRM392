package huyvn.com.lab10;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import huyvn.com.lab10.Model.Trainee;

public class TraineeAdapter extends BaseAdapter {

    private ArrayList<Trainee> _listTrainee;
    private int _layout;
    Context _context;

    public TraineeAdapter(ArrayList<Trainee> listTrainee) {
        this._listTrainee = listTrainee;
    }

    public TraineeAdapter(Context context, int layout, ArrayList<Trainee> listTrainee) {
        this._context = context;
        this._layout = layout;
        this._listTrainee = listTrainee;
    }

    @Override
    public int getCount() {
        return _listTrainee.size();

    }

    @Override
    public Object getItem(int position) {
        return _listTrainee.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _listTrainee.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewTrainee;
        if (convertView == null) {
            viewTrainee = View.inflate(parent.getContext(), R.layout.list_trainee, null);
        } else {
            viewTrainee = convertView;
        }
        Trainee trainee = (Trainee) getItem(position);
        ((TextView) viewTrainee.findViewById(R.id.traineeId)).setText(String.format("Id = %d", trainee.getId()));
        ((TextView) viewTrainee.findViewById(R.id.name)).setText(String.format("Name = %s", trainee.getName()));
        ((TextView) viewTrainee.findViewById(R.id.phone)).setText(String.format("Phone = %s", trainee.getPhone()));
        ((TextView) viewTrainee.findViewById(R.id.email)).setText(String.format("Email = %s", trainee.getEmail()));
        ((TextView) viewTrainee.findViewById(R.id.gender)).setText(String.format("Gender = %s", trainee.getGender()));

        return viewTrainee;
    }
}