import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.GetJokeAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.matcher.ViewMatchers.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Édouard WILLISSECK
 */

@RunWith(AndroidJUnit4.class)
public class TestAsyncTask  {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<MainActivity>(
            MainActivity.class);

    @Test
    public void testJokeRetrieval() {
        GetJokeAsyncTask getJokeAsyncTask = new GetJokeAsyncTask();
        getJokeAsyncTask.execute(activityTestRule.getActivity());
        try {
            String response = getJokeAsyncTask.get(5, TimeUnit.SECONDS);
            assertThat(response.isEmpty(), is(false));
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }
}
