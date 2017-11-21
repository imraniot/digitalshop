package io.left.core.digitalshop.ui.splash;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Created by W3E04 on 11/21/2017.
 */

@RunWith(AndroidJUnit4.class)
public class SplashTest {

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("io.left.core.digitalshop", appContext.getPackageName());
    }
}
