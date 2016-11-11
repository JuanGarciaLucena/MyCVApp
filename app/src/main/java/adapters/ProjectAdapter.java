package adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import emebesoft.com.mycvapp.R;
import objects.ProjectObject;

/**
 * Created by Juan Lucena on 11/11/2016.
 */

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectObjectViewHolder> implements View.OnClickListener{

    private List<ProjectObject> projectObjectList;
    private View.OnClickListener listener;

    public ProjectAdapter(List<ProjectObject> projectObjectList){
        this.projectObjectList = projectObjectList;
    }

    public static class ProjectObjectViewHolder extends RecyclerView.ViewHolder {
        public ProjectObjectViewHolder(View itemView) {
            super(itemView);
        }

        public void bindTitular(ProjectObject projectObject) {
        }
    }

    @Override
    public ProjectAdapter.ProjectObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_project, parent, false);
        itemView.setOnClickListener(this);
        ProjectAdapter.ProjectObjectViewHolder projectObjectViewHolder = new ProjectAdapter.ProjectObjectViewHolder(itemView);

        return projectObjectViewHolder;
    }

    @Override
    public void onBindViewHolder(ProjectAdapter.ProjectObjectViewHolder holder, int position) {
        Context context = holder.itemView.getContext();

        ProjectObject item = projectObjectList.get(position);
        holder.bindTitular(item);

        ImageView projectLogoImageView = (ImageView)holder.itemView.findViewById(R.id.projectLogoImageView);
        TextView projectNameTextView = (TextView)holder.itemView.findViewById(R.id.projectNameTextView);
        projectNameTextView.setText(item.getProjectName());

        if(position == 0){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_appyshopper));
        }else if(position == 1){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_dialoga));
        }else if(position == 2){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_opyno));
        }else if(position == 3){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_tourist_tab));
        }else if(position == 4){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_gibelec));
        }else if(position == 5){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_fauna_flora));
        }else if(position == 6){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_viafirma));
        }else if(position == 7){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_directorio));
        }else if(position == 8){
            projectLogoImageView.setImageDrawable(context.getDrawable(R.drawable.ic_us));
        }
    }

    @Override
    public int getItemCount() {
        return projectObjectList.size();
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
