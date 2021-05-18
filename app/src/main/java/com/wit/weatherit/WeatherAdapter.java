package com.wit.weatherit;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {
    private List<WeatherModel> weatherList;
    private View itemView;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView day, time, temp, tempMin, tempMax, description;
        CardView card;
        ImageView icon;

        MyViewHolder(View view) {
            super(view);
            day = view.findViewById(R.id.fday);
            time = view.findViewById(R.id.ftime);
            icon = view.findViewById(R.id.forecastIcon);
            temp = view.findViewById(R.id.ftemp);
            tempMin = view.findViewById(R.id.ftempMin);
            tempMax = view.findViewById(R.id.ftempMax);
            description = view.findViewById(R.id.fdescription);
            card = view.findViewById(R.id.forecastCard);
        }
    }
    public WeatherAdapter(List<WeatherModel> weatherList) {
        this.weatherList = weatherList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_forecast_list, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        WeatherModel weather = weatherList.get(position);
        holder.day.setText(weather.getDay());
        String dayColor = holder.day.getText().toString();
        switch (dayColor)
        {
            case "Monday":
                holder.card.setCardBackgroundColor(Color.parseColor("#7E00649A"));
                break;
            case "Tuesday":
                holder.card.setCardBackgroundColor(Color.parseColor("#7E9A0055"));
                break;
            case "Wednesday":
                holder.card.setCardBackgroundColor(Color.parseColor("#7E0A009A"));
                break;
            case "Thursday":
                holder.card.setCardBackgroundColor(Color.parseColor("#7E90009A"));
                break;
            case "Friday":
                holder.card.setCardBackgroundColor(Color.parseColor("#7E243F5C"));
                break;
            case "Saturday":
                holder.card.setCardBackgroundColor(Color.parseColor("#7E5E2451"));
                break;
            case "Sunday":
                holder.card.setCardBackgroundColor(Color.parseColor("#7E9A0067"));
                break;
            default:
                holder.card.setCardBackgroundColor(Color.BLACK);
                break;
        }

        holder.time.setText(weather.getTime());
        int resourceID=itemView.getResources().getIdentifier(weather.getIcon(),"drawable", MainActivity.PACKAGE_NAME);
        holder.icon.setImageResource(resourceID);
        holder.temp.setText(weather.getTemp());
        holder.tempMin.setText(weather.getTempMin());
        holder.tempMax.setText(weather.getTempMax());
        holder.description.setText(weather.getDescription());
    }
    @Override
    public int getItemCount() {
        return weatherList.size();
    }
}