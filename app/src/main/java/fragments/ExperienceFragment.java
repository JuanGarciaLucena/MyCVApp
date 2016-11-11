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
import emebesoft.com.mycvapp.ExperienceDetailActivity;
import emebesoft.com.mycvapp.R;
import objects.ExperienceObject;

/**
 * Created by juanlucena on 06/08/16.
 */
public class ExperienceFragment extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_experience, container, false);

        SugarContext.init(getContext());
        List<ExperienceObject> experienceObjectList = ExperienceObject.findWithQuery(ExperienceObject.class, "Select * from experience_object");
        SugarContext.terminate();

        recyclerView = (RecyclerView)fragmentView.findViewById(R.id.RecView);
        Drawable dividerDrawable = ContextCompat.getDrawable(getContext(), R.drawable.divider_horizontal_recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(dividerDrawable));
        recyclerView.setHasFixedSize(true);

        final ExperienceAdapter experienceAdapter = new ExperienceAdapter(experienceObjectList);

        experienceAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ExperienceDetailActivity.class);
                intent.putExtra("experienceID", recyclerView.getChildAdapterPosition(v));
                startActivity(intent);

            }
        });

        recyclerView.setAdapter(experienceAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));





        return fragmentView;
    }
}
