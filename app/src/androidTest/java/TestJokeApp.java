import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.jokegetter.JokeGetter;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author Édouard WILLISSECK
 */

@RunWith(AndroidJUnit4.class)
public class TestJokeApp {

    @Rule
    public ActivityTestRule<MainActivity> mActivtyRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testDisplayJoke() {
        JokeGetter jokeGetter = new JokeGetter();
        String joke = jokeGetter.getJoke();
        onView(withId(R.id.joke_button)).perform(click());
        onView(withId(R.id.joke_text_view)).check(matches(withText(joke)));
    }
}
