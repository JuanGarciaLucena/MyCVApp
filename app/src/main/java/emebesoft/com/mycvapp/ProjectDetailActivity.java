package emebesoft.com.mycvapp;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.orm.SugarContext;

import butterknife.BindView;
import butterknife.ButterKnife;
import objects.ProjectObject;

public class ProjectDetailActivity extends AppCompatActivity {

    @BindView(R.id.projectLogoImageView) ImageView projectLogoImageView;
    @BindView(R.id.projectCompanyDateTextView) TextView projectCompanyDateTextView;
    @BindView(R.id.projectDetailTextView) TextView projectDetailTextView;
    @BindView(R.id.toolbarTitle) TextView toolbarTitle;
    @BindView(R.id.experienceToolbar) Toolbar experienceToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);
        ButterKnife.bind(ProjectDetailActivity.this);

        setSupportActionBar(experienceToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        int projectID = getIntent().getIntExtra("projectID", -1);

        if(projectID != -1){

            if(projectID == 0){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_appyshopper));
            }else if(projectID == 1){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_dialoga));
            }else if(projectID == 2){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_opyno));
            }else if(projectID == 3){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_tourist_tab));
            }else if(projectID == 4){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_gibelec));
            }else if(projectID == 5){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_fauna_flora));
            }else if(projectID == 6){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_viafirma));
            }else if(projectID == 7){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_directorio));
            }else if(projectID == 8){
                projectLogoImageView.setImageDrawable(ContextCompat.getDrawable(ProjectDetailActivity.this, R.drawable.ic_us));
            }

            SugarContext.init(ProjectDetailActivity.this);
            String query = "Select * from project_object where project_id = ?";
            ProjectObject projectObject = ProjectObject.findWithQuery(ProjectObject.class, query, Integer.toString(projectID)).get(0);
            SugarContext.terminate();

            if(projectObject != null){

                toolbarTitle.setText(projectObject.getProjectName());
                projectCompanyDateTextView.setText(projectObject.getProjectCompany() + " - " + projectObject.getProjectDate());

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    projectDetailTextView.setText(Html.fromHtml(projectObject.getProjectDescription(), Html.FROM_HTML_MODE_LEGACY));
                } else {
                    projectDetailTextView.setText(Html.fromHtml(projectObject.getProjectDescription()));
                }
            }
        }else{
            Log.e("LOG_ERROR", "Error: Problemas al extraer el id de los proyectos.");
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
