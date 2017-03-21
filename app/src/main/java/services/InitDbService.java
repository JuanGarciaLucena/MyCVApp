package services;

import android.app.IntentService;
import android.content.Intent;
import com.orm.SugarContext;
import java.util.ArrayList;
import java.util.List;
import emebesoft.com.mycvapp.R;
import objects.ExperienceObject;
import objects.ProjectObject;
import objects.TechObject;

public class InitDbService extends IntentService{

    public static final String DB_INTIALIZED = "emebesoft.com.intent.action.DB_INITIALIZED";

    public InitDbService() {
        super("InitDbService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        initDB();
    }

    public void initDB(){

        List<ExperienceObject> experienceObjectList = new ArrayList<>();
        List<TechObject> techObjectList = new ArrayList<>();
        List<ProjectObject> projectObjectList = new ArrayList<>();

        experienceObjectList.add(new ExperienceObject(0, "1eEurope", "Septiembre 2015", "Agosto 2016", "Android developer", getResources().getString(R.string.experience_detail_oneeurope)));
        experienceObjectList.add(new ExperienceObject(1, "Realcom", "Junio 2015", "Junio 2015", "Android developer", getResources().getString(R.string.experience_detail_realcom)));
        experienceObjectList.add(new ExperienceObject(2, "Elitech Lab", "Febrero 2014", "Marzo 2015", "Android developer", getResources().getString(R.string.experience_detail_elitechlab)));
        experienceObjectList.add(new ExperienceObject(3, "Cobre las Cruces", "Julio 2013", "Enero 2014", "SCADA Admin", getResources().getString(R.string.experience_detail_clc)));
        experienceObjectList.add(new ExperienceObject(4, "Viavansi", "Enero 2012", "Enero 2013", "Android developer", getResources().getString(R.string.experience_detail_viavansi)));

        techObjectList.add(new TechObject("Android"));
        techObjectList.add(new TechObject("Android Studio"));
        techObjectList.add(new TechObject("Appcelerator"));
        techObjectList.add(new TechObject("CSS3"));
        techObjectList.add(new TechObject("Eclipse"));
        techObjectList.add(new TechObject("HTML5"));
        techObjectList.add(new TechObject("Java"));
        techObjectList.add(new TechObject("Javascript"));
        techObjectList.add(new TechObject("PhoneGap"));
        techObjectList.add(new TechObject("Sencha"));

        projectObjectList.add(new ProjectObject(0, "Appyshopper", getResources().getString(R.string.project_appyshopper), "2016", "1eEurope"));
        projectObjectList.add(new ProjectObject(1, "Dialoga D3", getResources().getString(R.string.project_dialoga), "2015", "Realcom"));
        projectObjectList.add(new ProjectObject(2, "Opyno", getResources().getString(R.string.project_opyno), "2015", "Elitech Lab"));
        projectObjectList.add(new ProjectObject(3, "Smart Hospitality Solution", getResources().getString(R.string.project_smart_hospitality_solution), "2015", "Elitech Lab"));
        projectObjectList.add(new ProjectObject(4, "Gibelec", getResources().getString(R.string.project_gibelec), "2014", "Elitech Lab"));
        projectObjectList.add(new ProjectObject(5, "Gibraltar Fauna & Flora", getResources().getString(R.string.project_flora_fauna), "2014", "Elitech Lab"));
        projectObjectList.add(new ProjectObject(6, "Viafirma Inbox Mobile", getResources().getString(R.string.project_viafirma), "2012", "Viavansi"));
        projectObjectList.add(new ProjectObject(7, "Directorio Corporativo", getResources().getString(R.string.project_directorio_corporativo), "2012", "Viavansi"));
        projectObjectList.add(new ProjectObject(8, "Proyecto de Fin de Carrera", getResources().getString(R.string.project_pfc), "2012", "Universidad de Sevilla"));

        for(ExperienceObject item: experienceObjectList){
            item.save();
        }

        for(TechObject item: techObjectList){
            item.save();
        }

        for(ProjectObject item: projectObjectList){
            item.save();
        }

        SugarContext.terminate();
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction(InitDbService.DB_INTIALIZED);
        broadcastIntent.addCategory(Intent.CATEGORY_DEFAULT);
        sendBroadcast(broadcastIntent);
    }
}