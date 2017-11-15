package cc.somkiat.basicunittesting;

import android.os.SystemClock;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestEmpty(){
        Espresso.closeSoftKeyboard();
        SystemClock.sleep(1500);

        onView(withId(R.id.revertButton)).perform(scrollTo(), click());

//        onView(allOf(withId(R.id.nameError), isDisplayed())).check(matches(withText("Name must not empty")));
//        onView(allOf(withId(R.id.emailError), isDisplayed())).check(matches(withText("email must not empty")));
    }
}
