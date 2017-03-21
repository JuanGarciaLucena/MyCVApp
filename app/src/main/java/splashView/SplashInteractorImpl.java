package splashView;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

import services.InitDbService;

public class SplashInteractorImpl extends BroadcastReceiver implements SplashInteractor{

    private OnDBInitialized listener;

    public SplashInteractorImpl(OnDBInitialized listener){
        this.listener = listener;
    }


    @Override
    public void doInitDb(Context context) {
        IntentFilter filter = new IntentFilter(InitDbService.DB_INTIALIZED);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        context.registerReceiver(this, filter);

        Intent msgIntent = new Intent(context, InitDbService.class);
        context.startService(msgIntent);
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        listener.onDBInitialized(this);
    }
}
