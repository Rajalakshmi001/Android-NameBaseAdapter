package com.example.somasur.namebaseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class NameAdapter extends BaseAdapter {

    private Context mContext;
    final ArrayList<String> mNames = new ArrayList<>();
    private Random mRandom = new Random();

    public NameAdapter(Context context) {
        mContext = context;
        for (int i = 0; i < 5; i++) {
            mNames.add(getRandomName());
        }
    }

    private String getRandomName() {
        String[] names = new String[]{
                "Hannah", "Emily", "Sarah", "Madison", "Brianna",
                "Kaylee", "Kaitlyn", "Hailey", "Alexis", "Elizabeth",
                "Michael", "Jacob", "Matthew", "Nicholas", "Christopher",
                "Joseph", "Zachary", "Joshua", "Andrew", "William"
        };
        return names[mRandom.nextInt(names.length)];
    }

    @Override
    public int getCount() {
        return mNames.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if(convertView == null) {
            //Make a view
            view = LayoutInflater.from(mContext).inflate(R.layout.name_view, parent, false);
        } else {
            view = convertView;
        }
        //customize it
        String name = mNames.get(position);
        TextView nameTextView = view.findViewById(R.id.name_view);
        nameTextView.setText(name);
        TextView positionTextView = view.findViewById(R.id.position_view);
        positionTextView.setText(String.format("I'm in %d", (position + 1)));

        return view;
    }

    public void addName() {
        mNames.add(getRandomName());
        notifyDataSetChanged();
    }

    public void removeName(int position){
        mNames.remove(position);
        notifyDataSetChanged();
    }

}
