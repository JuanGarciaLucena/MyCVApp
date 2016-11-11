package emebesoft.com.mycvapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.orm.SugarContext;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import objects.ExperienceObject;

public class ExperienceDetailActivity extends AppCompatActivity {

    @BindView(R.id.experienceDescriptionTextView) TextView experienceDescriptionTextView;
    @BindView(R.id.logoCompany)ImageView logoCompany;
    @BindView(R.id.experienceDetailPeriodTextView)TextView experienceDetailPeriodTextView;
    @BindView(R.id.toolbarTitle)TextView toolbarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience_detail);
        ButterKnife.bind(this);

        Toolbar experienceToolbar = (Toolbar) findViewById(R.id.experienceToolbar);
        setSupportActionBar(experienceToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        int experienceID = getIntent().getIntExtra("experienceID", -1);

        if(experienceID != -1){

            if(experienceID == 0) {
                logoCompany.setImageDrawable(getDrawable(R.drawable.logo_oneeurope));
            }else if(experienceID == 1){
                logoCompany.setImageDrawable(getDrawable(R.drawable.logo_realcom));
            }else if(experienceID == 2){
                logoCompany.setImageDrawable(getDrawable(R.drawable.logo_elitechlab));
            }else if(experienceID == 3){
                logoCompany.setImageDrawable(getDrawable(R.drawable.logo_clc));
            }else if(experienceID == 4){
                logoCompany.setImageDrawable(getDrawable(R.drawable.logo_viavansi));
            }

            SugarContext.init(ExperienceDetailActivity.this);
            String query = "Select * from experience_object where experience_id = ?";
            ExperienceObject experienceObject = ExperienceObject.findWithQuery(ExperienceObject.class, query, Integer.toString(experienceID)).get(0);
            SugarContext.terminate();

            toolbarTitle.setText(experienceObject.getCompanyName());
            experienceDetailPeriodTextView.setText(experienceObject.getDateFrom() + " - " + experienceObject.getDateTo());

            if(experienceObject != null){
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    experienceDescriptionTextView.setText(Html.fromHtml(experienceObject.getExperienceDescription(), Html.FROM_HTML_MODE_LEGACY));
                } else {
                    experienceDescriptionTextView.setText(Html.fromHtml(experienceObject.getExperienceDescription()));
                }
            }else{
                Log.e("LOG_ERROR", "Error: No existe esta experiencia en la base de datos.");
            }
        }else{
            Log.e("LOG_ERROR", "Error: Problemas al extraer el id de la experiencia.");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}
