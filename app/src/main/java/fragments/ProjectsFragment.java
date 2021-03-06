package fragments;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dgreenhalgh.android.simpleitemdecoration.grid.GridDividerItemDecoration;
import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.orm.SugarContext;

import adapters.ProjectAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import emebesoft.com.mycvapp.ProjectDetailActivity;
import emebesoft.com.mycvapp.R;
import objects.ProjectObject;

/**
 * Created by juanlucena on 06/08/16.
 */
public class ProjectsFragment extends Fragment{

    @BindView(R.id.projectRecyclerView) RecyclerView projectRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_projects, container, false);
        ButterKnife.bind(this, fragmentView);

        projectRecyclerView.setHasFixedSize(true);

        SugarContext.init(getContext());
        final ProjectAdapter projectAdapter = new ProjectAdapter(ProjectObject.findWithQuery(ProjectObject.class, "SELECT * FROM project_object"));
        SugarContext.terminate();

        projectRecyclerView.setAdapter(projectAdapter);
        projectRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        projectAdapter.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), ProjectDetailActivity.class);
                intent.putExtra("projectID", projectRecyclerView.getChildAdapterPosition(v));
                startActivity(intent);
            }
        );


        return fragmentView;
    }
}
