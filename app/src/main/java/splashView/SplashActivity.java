package splashView;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.orm.SugarContext;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import emebesoft.com.mycvapp.MainActivity;
import emebesoft.com.mycvapp.R;
import utils.Utils;

public class SplashActivity extends AppCompatActivity implements SplashView{

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    SplashPresenter splashPresenter = new SplashPresenterImpl(this);

    @BindView(R.id.labelTitle)TextView labelTitle;
    @BindView(R.id.labelSubtitle)TextView labelSubtitle;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(SplashActivity.this);

        Typeface textViewAppTitleTypeFace = Typeface.createFromAsset(getAssets(), String.format(Locale.ENGLISH, "fonts/%s", "Lobster-Regular.ttf"));
        labelTitle.setTypeface(textViewAppTitleTypeFace);
        labelSubtitle.setTypeface(textViewAppTitleTypeFace);

        if(Utils.checkIfDbExists(SplashActivity.this)){
            goToMainActivity();
        }else{
            SugarContext.init(SplashActivity.this);
            splashPresenter.initDb(SplashActivity.this);
        }
    }

    @Override
    public void unregisterReceaver(BroadcastReceiver receiver) {
        unregisterReceiver(receiver);
        goToMainActivity();
    }

    public void goToMainActivity(){
        new Handler().postDelayed(() ->{
            Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(mainIntent);
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            finish();
        }, SPLASH_DISPLAY_LENGTH);
    }
}