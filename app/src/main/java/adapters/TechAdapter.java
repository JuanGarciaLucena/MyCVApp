package adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import emebesoft.com.mycvapp.R;
import objects.ExperienceObject;
import objects.TechObject;

/**
 * Created by Juan Lucena on 11/11/2016.
 */

public class TechAdapter extends RecyclerView.Adapter<TechAdapter.TechObjectViewHolder> {

    private List<TechObject> techObjectList;

    public TechAdapter(List<TechObject> techObjectList){
        this.techObjectList = techObjectList;
    }

    public static class TechObjectViewHolder extends RecyclerView.ViewHolder {
        public TechObjectViewHolder(View itemView) {
            super(itemView);
        }

        public void bindTitular(TechObject techObject) {
        }
    }

    @Override
    public TechAdapter.TechObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_tech, parent, false);
        TechAdapter.TechObjectViewHolder techObjectViewHolder = new TechAdapter.TechObjectViewHolder(itemView);

        return techObjectViewHolder;
    }

    @Override
    public void onBindViewHolder(TechAdapter.TechObjectViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        TechObject item = techObjectList.get(position);
        holder.bindTitular(item);

        ImageView techLogoImageView = (ImageView)holder.itemView.findViewById(R.id.techLogoImageView);

        if(position == 0) {
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_android));
        }else if(position == 1){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_android_studio));
        }else if(position == 2){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_appcelerator));
        }else if(position == 3){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_css));
        }else if(position == 4){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_eclipse));
        }else if(position == 5){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_html));
        }else if(position == 6){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_java));
        }else if(position == 7){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_javascript));
        }else if(position == 8){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_phonegap));
        }else if(position == 9){
            techLogoImageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_sencha));
        }

    }

    @Override
    public int getItemCount() {
        return techObjectList.size();
    }

}
