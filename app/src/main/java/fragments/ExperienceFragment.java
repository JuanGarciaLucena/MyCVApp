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

import com.dgreenhalgh.android.simpleitemdecoration.linear.DividerItemDecoration;
import com.orm.SugarContext;
import java.util.List;
import adapters.ExperienceAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;
import emebesoft.com.mycvapp.ExperienceDetailActivity;
import emebesoft.com.mycvapp.R;
import objects.ExperienceObject;

/**
 * Created by juanlucena on 06/08/16.
 */
public class ExperienceFragment extends Fragment {


    @BindView(R.id.experienceList) RecyclerView experienceList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_experience, container, false);
        ButterKnife.bind(this, fragmentView);

        SugarContext.init(getContext());
        List<ExperienceObject> experienceObjectList = ExperienceObject.findWithQuery(ExperienceObject.class, "Select * from experience_object");
        SugarContext.terminate();

        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.divider_horizontal_recycler_view);
        experienceList.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        experienceList.setHasFixedSize(true);

        final ExperienceAdapter experienceAdapter = new ExperienceAdapter(experienceObjectList);

        experienceAdapter.setOnClickListener(
            v -> {
                Intent intent = new Intent(getContext(), ExperienceDetailActivity.class);
                intent.putExtra("experienceID", experienceList.getChildAdapterPosition(v));
                startActivity(intent);
            }
        );

        experienceList.setAdapter(experienceAdapter);
        experienceList.setLayoutManager(new GridLayoutManager(getContext(), 1));





        return fragmentView;
    }
}
