import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import java.net.URI
import java.time.Duration
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class IntroScreenTest {
    private lateinit var driver: AndroidDriver

    @BeforeTest
    fun setup() {
        val uiAutomator2Options = UiAutomator2Options()
            .setApp("WikipediaSample.apk")
            .autoGrantPermissions()

        driver = AndroidDriver(URI("http://127.0.0.1:4723").toURL(), uiAutomator2Options)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5))
    }

    @Test
    fun testIntroScreenIsDisplayed() {
        val message = "Wikipedia"
        val element = driver.findElement(AppiumBy.xpath("//*[@text='$message']"))
        assert(element.isDisplayed)
    }

    @AfterTest
    fun tearDown() {
        driver.quit()
    }
}
