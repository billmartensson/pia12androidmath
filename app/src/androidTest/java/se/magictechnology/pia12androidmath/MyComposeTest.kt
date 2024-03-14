package se.magictechnology.pia12androidmath

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import se.magictechnology.pia12androidmath.ui.theme.Pia12androidmathTheme

class MyComposeTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    // use createAndroidComposeRule<YourActivity>() if you need access to
    // an activity

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            Pia12androidmathTheme {
                Mathscreen()
            }
        }


        //composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()

        composeTestRule.onNodeWithContentDescription("textfield1").performTextInput("7")
        composeTestRule.onNodeWithContentDescription("textfield2").performTextInput("2")

        composeTestRule.onNodeWithText("Add").performClick()

        composeTestRule.onNodeWithText("9").assertIsDisplayed()

        composeTestRule.waitUntil(5000) { false }
    }
}