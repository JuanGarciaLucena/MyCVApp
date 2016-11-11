package adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import emebesoft.com.mycvapp.R;
import objects.ExperienceObject;

/**
 * Created by juanlucena on 07/08/16.
 */
public class ExperienceAdapter extends RecyclerView.Adapter<ExperienceAdapter.ExperienceObjectViewHolder> implements View.OnClickListener{

    private View.OnClickListener listener;
    private List<ExperienceObject> data;

    public ExperienceAdapter(List<ExperienceObject> data){
        this.data = data;
    }


    public static class ExperienceObjectViewHolder extends RecyclerView.ViewHolder {

        public ExperienceObjectViewHolder(View itemView) {
            super(itemView);
        }

        public void bindTitular(ExperienceObject experienceObject) {
        }
    }


    @Override
    public ExperienceAdapter.ExperienceObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_experience, parent, false);
        itemView.setOnClickListener(this);
        ExperienceObjectViewHolder experienceObjectViewHolder = new ExperienceObjectViewHolder(itemView);

        return experienceObjectViewHolder;
    }

    @Override
    public void onBindViewHolder(ExperienceAdapter.ExperienceObjectViewHolder holder, int position) {

        Context context = holder.itemView.getContext();

        ExperienceObject item = data.get(position);
        holder.bindTitular(item);

        ImageView logoCompany = (ImageView)holder.itemView.findViewById(R.id.logoCompany);
        TextView nameCompany = (TextView)holder.itemView.findViewById(R.id.nameCompany);
        nameCompany.setText(item.getCompanyName());

        if(position == 0) {
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_oneeurope));
        }else if(position == 1){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_realcom));
        }else if(position == 2){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_elitechlab));
        }else if(position == 3){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_clc));
        }else if(position == 4){
            logoCompany.setImageDrawable(context.getDrawable(R.drawable.logo_viavansi));
        }



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
