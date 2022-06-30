package huyvn.com.lab9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CongViecAdapter extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private ArrayList<CongViec> listCongViec;

    public CongViecAdapter(MainActivity context, int layout, ArrayList<CongViec> listCongViec) {
        this.context = context;
        this.layout = layout;
        this.listCongViec = listCongViec;
    }

    @Override
    public int getCount() {
        return listCongViec.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        TextView txtCongViec;
        ImageView iconEdit, iconDelete;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.dynamic_congviec, null);

            viewHolder.txtCongViec = (TextView) convertView.findViewById(R.id.txtcongViec);
            viewHolder.iconEdit = (ImageView) convertView.findViewById(R.id.iconEdit);
            viewHolder.iconDelete = (ImageView) convertView.findViewById(R.id.iconDelete);

            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CongViec congViec = listCongViec.get(position);
        viewHolder.txtCongViec.setText(congViec.getCongviec());

        viewHolder.iconEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogUpdateCongViec(congViec.getCongviec(), congViec.getId());
            }
        });

        viewHolder.iconDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.DialogXoaCongViec(congViec.getCongviec(), congViec.getId());
            }
        });


        return convertView;
    }


}
