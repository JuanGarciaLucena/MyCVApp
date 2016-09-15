package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import adapters.ExperienceAdapter;
import emebesoft.com.mycvapp.R;
import objects.ExperienceObject;

/**
 * Created by juanlucena on 06/08/16.
 */
public class ExperienceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_experience, container, false);


        ArrayList<ExperienceObject> data = new ArrayList<ExperienceObject>();

        data.add(new ExperienceObject("1eEurope", "Septiembre 2015", "Agosto 2016", "Android developer"));
        data.add(new ExperienceObject("Realcom", "Junio 2015", "Junio 2015", "Android developer"));
        data.add(new ExperienceObject("Elitechlab", "Febrero 2014", "Marzo 2015", "Android developer"));
        data.add(new ExperienceObject("Cobre las Cruces", "Julio 2013", "Enero 2014", "SCADA Admin"));
        data.add(new ExperienceObject("Viavansi", "Enero 2012", "Enero 2013", "Android developer"));


        RecyclerView recView = (RecyclerView)fragmentView.findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final ExperienceAdapter experienceAdapter = new ExperienceAdapter(data);
        recView.setAdapter(experienceAdapter);
        recView.setLayoutManager(new GridLayoutManager(getContext(), 1));

        return fragmentView;
    }
}
