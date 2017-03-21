package splashView;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.util.Log;

public class SplashPresenterImpl implements SplashPresenter, SplashInteractor.OnDBInitialized{

    private SplashView splashView;

    public SplashPresenterImpl(SplashView splashView){
        this.splashView = splashView;
    }

    SplashInteractor splashInteractor = new SplashInteractorImpl(this);

    @Override
    public void initDb(Context context) {
        splashInteractor.doInitDb(context);
    }

    @Override
    public void onDBInitialized(BroadcastReceiver receiver) {
        splashView.unregisterReceaver(receiver);
    }
}
