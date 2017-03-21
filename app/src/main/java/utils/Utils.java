package utils;


import android.content.Context;

import java.io.File;

import emebesoft.com.mycvapp.R;

public class Utils {

    //Comprobamos si existe la base de datos
    public static boolean checkIfDbExists(Context context){
        File dbFile = context.getDatabasePath(context.getString(R.string.app_db));
        return dbFile.exists();
    }
}
