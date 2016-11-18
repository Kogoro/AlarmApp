package de.bonding.hackathon.eighthundredtwelvers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import de.bonding.hackathon.eighthundredtwelvers.model.Alarm;

/**
 * Created by csontag on 11/18/16.
 */

public class AlarmRecyclerViewAdapter extends RecyclerView.Adapter<AlarmRecyclerViewAdapter.AlarmViewHolder> {
    private Alarm[] mDataset;


    public static class AlarmViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView time;
        public Switch status;

        public AlarmViewHolder(View v) {
            super(v);
            name = (TextView) v.findViewById(R.id.item_alarm_name);
            time = (TextView) v.findViewById(R.id.item_alarm_time);
            status = (Switch) v.findViewById(R.id.item_alarm_status);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AlarmRecyclerViewAdapter(Alarm[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AlarmRecyclerViewAdapter.AlarmViewHolder onCreateViewHolder(ViewGroup parent,
                                                                  int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alarm, parent, false);

        return new AlarmViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(AlarmViewHolder holder, int position) {
        holder.name.setText(mDataset[position].name);
        holder.time.setText(getDate(mDataset[position].time));
        holder.status.setChecked(mDataset[position].status);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    public  String getDate(long timestamp) {
        try{
            long dv = Long.valueOf(timestamp)*1000;
            Date df = new java.util.Date(dv);
            return new SimpleDateFormat("HH:MM").format(df);
        }catch (Exception e) {
        }
        return "";
    }
}


