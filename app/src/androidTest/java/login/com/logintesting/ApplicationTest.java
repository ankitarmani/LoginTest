package login.com.logintesting;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.ActivityInstrumentationTestCase2;
import com.robotium.solo.Solo;


@SuppressWarnings("unchecked")
public class ApplicationTest extends ActivityInstrumentationTestCase2 {

    //storing launcher activity
    private static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "login.com.logintesting.LoginActivity";
    private static Class launcherActivityClass;
    static {
        try {
            launcherActivityClass = Class
                    .forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ApplicationTest() throws ClassNotFoundException {
        super(launcherActivityClass);
    }
    private Solo solo;

    //initialization of solo object
    @Override
    protected void setUp() throws Exception {
        solo = new Solo(getInstrumentation(), getActivity());
    }
    public void testLoginBlackBox() {

        //useranme text field
        solo.enterText(0,"ankit@a.com");

        //password text field
        solo.enterText(1, "123456");

        //login button
        solo.clickOnButton(0);

        //
        //solo.assertCurrentActivity("", "");
    }

        @Override
      public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
}