package emebesoft.com.mycvapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.orm.SugarContext;

import java.util.List;

import objects.ExperienceObject;
import objects.ProjectObject;
import objects.TechObject;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);

        initDB();

        // Old code without lambdas
        /*new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
        */

        new Handler().postDelayed(
        () ->{
                Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                SplashActivity.this.finish();
            }, SPLASH_DISPLAY_LENGTH);
    }

    public void initDB(){


        SugarContext.init(SplashActivity.this);

        List<ExperienceObject> experienceObjectList = ExperienceObject.findWithQuery(ExperienceObject.class, "SELECT * FROM experience_object");
        if(experienceObjectList.isEmpty()){

            ExperienceObject experienceObject1 = new ExperienceObject(0, "1eEurope", "Septiembre 2015", "Agosto 2016", "Android developer", getResources().getString(R.string.experience_detail_oneeurope));
            ExperienceObject experienceObject2 = new ExperienceObject(1, "Realcom", "Junio 2015", "Junio 2015", "Android developer", getResources().getString(R.string.experience_detail_realcom));
            ExperienceObject experienceObject3 = new ExperienceObject(2, "Elitech Lab", "Febrero 2014", "Marzo 2015", "Android developer", getResources().getString(R.string.experience_detail_elitechlab));
            ExperienceObject experienceObject4 = new ExperienceObject(3, "Cobre las Cruces", "Julio 2013", "Enero 2014", "SCADA Admin", getResources().getString(R.string.experience_detail_clc));
            ExperienceObject experienceObject5 = new ExperienceObject(4, "Viavansi", "Enero 2012", "Enero 2013", "Android developer", getResources().getString(R.string.experience_detail_viavansi));

            experienceObject1.save();
            experienceObject2.save();
            experienceObject3.save();
            experienceObject4.save();
            experienceObject5.save();
        }

        List<TechObject> techObjectList = TechObject.findWithQuery(TechObject.class, "SELECT * FROM tech_object");
        if(techObjectList.isEmpty()){
            TechObject techObject1 = new TechObject("Android");
            TechObject techObject2 = new TechObject("Android Studio");
            TechObject techObject3 = new TechObject("Appcelerator");
            TechObject techObject4 = new TechObject("CSS3");
            TechObject techObject5 = new TechObject("Eclipse");
            TechObject techObject6 = new TechObject("HTML5");
            TechObject techObject7 = new TechObject("Java");
            TechObject techObject8 = new TechObject("Javascript");
            TechObject techObject9 = new TechObject("PhoneGap");
            TechObject techObject10 = new TechObject("Sencha");

            techObject1.save();
            techObject2.save();
            techObject3.save();
            techObject4.save();
            techObject5.save();
            techObject6.save();
            techObject7.save();
            techObject8.save();
            techObject9.save();
            techObject10.save();
        }

        List<ProjectObject> projectObjectList = TechObject.findWithQuery(ProjectObject.class, "SELECT * FROM project_object");
        if(projectObjectList.isEmpty()){
            ProjectObject projectObject1 = new ProjectObject(0, "Appyshopper", getResources().getString(R.string.project_appyshopper), "2016", "1eEurope");
            ProjectObject projectObject2 = new ProjectObject(1, "Dialoga D3", getResources().getString(R.string.project_dialoga), "2015", "Realcom");
            ProjectObject projectObject3 = new ProjectObject(2, "Opyno", getResources().getString(R.string.project_opyno), "2015", "Elitech Lab");
            ProjectObject projectObject4 = new ProjectObject(3, "Smart Hospitality Solution", getResources().getString(R.string.project_smart_hospitality_solution), "2015", "Elitech Lab");
            ProjectObject projectObject5 = new ProjectObject(4, "Gibelec", getResources().getString(R.string.project_gibelec), "2014", "Elitech Lab");
            ProjectObject projectObject6 = new ProjectObject(5, "Gibraltar Fauna & Flora", getResources().getString(R.string.project_flora_fauna), "2014", "Elitech Lab");
            ProjectObject projectObject7 = new ProjectObject(6, "Viafirma Inbox Mobile", getResources().getString(R.string.project_viafirma), "2012", "Viavansi");
            ProjectObject projectObject8 = new ProjectObject(7, "Directorio Corporativo", getResources().getString(R.string.project_directorio_corporativo), "2012", "Viavansi");
            ProjectObject projectObject9 = new ProjectObject(8, "Proyecto de Fin de Carrera", getResources().getString(R.string.project_pfc), "2012", "Universidad de Sevilla");

            projectObject1.save();
            projectObject2.save();
            projectObject3.save();
            projectObject4.save();
            projectObject5.save();
            projectObject6.save();
            projectObject7.save();
            projectObject8.save();
            projectObject9.save();
        }

        SugarContext.terminate();
    }
}
