package io.github.chw3021.spacedefense.android;

import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import io.github.chw3021.spacedefense.SMain;

/** Launches the Android application. */
public class AndroidLauncher extends AndroidApplication {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration configuration = new AndroidApplicationConfiguration();
        //configuration.useImmersiveMode = true; // Recommended, but not required.
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initialize(new SMain(), configuration);
    }
}
