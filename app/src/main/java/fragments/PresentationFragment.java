package fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import emebesoft.com.mycvapp.R;

/**
 * Created by juanlucena on 02/08/16.
 */
public class PresentationFragment extends Fragment {

    @BindView(R.id.presentationTextView) TextView presentationTextView;

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragmentView = inflater.inflate(R.layout.fragment_presentation, container, false);
        ButterKnife.bind(this, fragmentView);

        String presentationString = getContext().getResources().getString(R.string.presentation_text);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            presentationTextView.setText(Html.fromHtml(presentationString, Html.FROM_HTML_MODE_LEGACY));
        } else {
            presentationTextView.setText(Html.fromHtml(presentationString));
        }

        return fragmentView;
    }
}
