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
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void TestRevertEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    @Test
    public void TestRevertNotEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Nice"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("email@email.com"));
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    @Test
    public void TestRevertNameEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("email@email.com"));
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    @Test
    public void TestRevertEmailEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("Nice"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.revertButton)).perform(scrollTo(), click());
        onView(withId(R.id.userNameInput)).check(matches(withText("")));
        onView(withId(R.id.emailInput)).check(matches(withText("")));
    }

    @Test
    public void TestSaveEmpty(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText(""));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText(""));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withId(R.id.nameError)).check(matches(withText("Name must not empty")));
        onView(withId(R.id.emailError)).check(matches(withText("email must not empty")));
    }

    @Test
    public void TestSaveSpace(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("ni ce"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("ema il@email.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withId(R.id.nameError)).check(matches(withText("Name must not have space")));
        onView(withId(R.id.emailError)).check(matches(withText("email must not have space")));
    }

    @Test
    public void TestSaveEmailNotPattern(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("nice"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("email@@email.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withId(R.id.emailError)).check(matches(withText("email must has one @")));
    }

    @Test
    public void TestSaveSpecialName(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("nice!@"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("email@email.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withId(R.id.nameError)).check(matches(withText("Name must contain only alphabet")));
    }

    @Test
    public void TestSaveIntegerName(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("nice123"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("email@email.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withId(R.id.nameError)).check(matches(withText("Name must not have number")));
    }

    @Test
    public void TestSaveLessThanTwoName(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("n"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("email@email.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withId(R.id.nameError)).check(matches(withText("Name must more than 2")));
    }

    @Test
    public void TestSaveMoreThanTwentyName(){
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.userNameInput)).perform(scrollTo() ,replaceText("nicenicenicenicenicenice"));
        onView(withId(R.id.emailInput)).perform(scrollTo(), replaceText("email@email.com"));
        onView(withId(R.id.saveButton)).perform(scrollTo(), click());
        onView(withId(R.id.nameError)).check(matches(withText("Name must less than 20")));
    }
}
