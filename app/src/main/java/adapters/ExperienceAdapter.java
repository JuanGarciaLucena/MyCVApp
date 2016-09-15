package adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import emebesoft.com.mycvapp.R;
import objects.ExperienceObject;

/**
 * Created by juanlucena on 07/08/16.
 */
public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ExperienceObjectViewHolder> implements View.OnClickListener{

    private View.OnClickListener listener;
    private ArrayList<ExperienceObject> data;

    public ExperienceAdapter(ArrayList<ExperienceObject> data){
        this.data = data;
    }


    public static class ExperienceObjectViewHolder extends RecyclerView.ViewHolder {

        //private TextView tvCompanyName;

        public ExperienceObjectViewHolder(View itemView) {
            super(itemView);
            //tvCompanyName = (TextView)itemView.findViewById(R.id.tvCompanyName);

        }

        public void bindTitular(ExperienceObject experienceObject) {
            //tvCompanyName.setText(experienceObject.getCompanyName());
        }
    }


    @Override
    public ExperienceAdapter.ExperienceObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_experience, parent, false);

        ExperienceObjectViewHolder experienceObjectViewHolder = new ExperienceObjectViewHolder(itemView);

        return experienceObjectViewHolder;
    }

    @Override
    public void onBindViewHolder(ExperienceAdapter.ExperienceObjectViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        ExperienceObject item = data.get(position);
        holder.bindTitular(item);

        ImageView logoCompany = (ImageView)holder.itemView.findViewById(R.id.logoCompany);

        if(position == 0) {
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_oneeurope));
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.demo_color_blue));
        }else if(position == 1){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_realcom));
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.demo_color_purple));
        }else if(position == 2){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_elitechlab));
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.demo_color_yellow));
        }else if(position == 3){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_clc));
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.demo_color_green));
        }else if(position == 4){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_viavansi));
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.demo_color_red));
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View view) {

    }
}
