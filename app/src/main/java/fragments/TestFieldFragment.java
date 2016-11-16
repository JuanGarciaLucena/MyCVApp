package fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import emebesoft.com.mycvapp.MapsActivity;
import emebesoft.com.mycvapp.R;

/**
 * Created by juanlucena on 06/08/16.
 */


public class TestFieldFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_test_field, container, false);

        ListView testFieldListView = (ListView)fragmentView.findViewById(R.id.testFieldListView);
        String[] data = getActivity().getResources().getStringArray(R.array.test_field_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, data);
        testFieldListView.setAdapter(adapter);

        testFieldListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    startActivity(new Intent(getContext(), MapsActivity.class));
                }
            }
        });

        return fragmentView;
    }
}
