package splashView;


import android.content.BroadcastReceiver;
import android.content.Context;

public interface SplashInteractor {

    void doInitDb(Context context);

    interface OnDBInitialized{
        void onDBInitialized(BroadcastReceiver receiver);
    }
}
