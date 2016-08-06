package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import emebesoft.com.mycvapp.R;

/**
 * Created by juanlucena on 06/08/16.
 */
public class ExperienceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_experience, container, false);

        return fragmentView;
    }
}
