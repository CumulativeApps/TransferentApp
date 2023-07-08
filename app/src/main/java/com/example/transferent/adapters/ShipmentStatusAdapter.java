package com.example.transferent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.example.transferent.R;
import com.example.transferent.models.ShipmentStatus;

import java.util.ArrayList;

public class ShipmentStatusAdapter extends ArrayAdapter<ShipmentStatus> {

    public ShipmentStatusAdapter(Context context, ArrayList<ShipmentStatus> shipmentStatusList) {
        super(context, 0, shipmentStatusList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.spinner_form_type, parent, false);
        }

        TextView statusTextView = view.findViewById(R.id.tvFormType);
        ShipmentStatus status = getItem(position);
        statusTextView.setText(status.getStatusName());

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.spinner_form_type, parent, false);
        }

        TextView statusTextView = view.findViewById(R.id.tvFormType);
        ShipmentStatus status = getItem(position);
        statusTextView.setText(status.getStatusName());

        return view;
    }
}
