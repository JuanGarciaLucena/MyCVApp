package fragments;

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
import com.orm.SugarContext;

import adapters.TechAdapter;
import butterknife.ButterKnife;
import emebesoft.com.mycvapp.R;
import objects.TechObject;

/**
 * Created by juanlucena on 06/08/16.
 */
public class TechFragment extends Fragment{

    private RecyclerView techRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_tech, container, false);
        ButterKnife.bind(getActivity());

        techRecyclerView = (RecyclerView)fragmentView.findViewById(R.id.techRecyclerView);
        Drawable horizontalDivider = ContextCompat.getDrawable(getContext(), R.drawable.divider_horizontal_recycler_view);
        Drawable verticalDivider = ContextCompat.getDrawable(getContext(), R.drawable.divider_vertical_recycler_view);
        techRecyclerView.setHasFixedSize(true);

        SugarContext.init(getContext());
        final TechAdapter techAdapter = new TechAdapter(TechObject.findWithQuery(TechObject.class, "SELECT * FROM tech_object"));
        SugarContext.terminate();

        techRecyclerView.setAdapter(techAdapter);
        techRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        techRecyclerView.addItemDecoration(new GridDividerItemDecoration(horizontalDivider, verticalDivider, 2));


        return fragmentView;
    }
}
