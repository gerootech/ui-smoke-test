
import net.codestory.simplelenium.SeleniumTest;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

// tells the script to run with 'Parametized' class, which helps us customize what we can do beofre running the tests.
@RunWith(Parameterized.class)
public abstract class BaseClass extends SeleniumTest {
    // Defines the following as parameters according to Junit
    @Parameterized.Parameters
    // Our object has 8 indexes which correlate to the array we have in the 'com.lennox.test.Data' class. We dont know what the second number means but it works so...
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Data.BROWSER_WIDTH[0], 0},
                {Data.BROWSER_WIDTH[1], 1},
                {Data.BROWSER_WIDTH[2], 2},
                {Data.BROWSER_WIDTH[3], 3},
                {Data.BROWSER_WIDTH[4], 4},
                {Data.BROWSER_WIDTH[5], 5},
                {Data.BROWSER_WIDTH[6], 6},
                {Data.BROWSER_WIDTH[7], 7},
        });
    }
}