import net.codestory.simplelenium.DomElement;
import net.codestory.simplelenium.PageObject;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

/**
 * Created by pivotal on 2016-06-14.
 */

//our class will extend BaseClass instead of SeleniumTest to get browser widths
public class SmokeTest extends BaseClass {
    //instantiate Home object
    Smoke smoke = new Smoke();
    //instantiate our needed pages to get where we need to be


    //declare browser width and mystery variable #2
    private int browser_width;
    private int browser_width_expected;

    //assign a constructor with both previous variables in it
    public SmokeTest(int first, int second) {
        browser_width = first;
        browser_width_expected = second;
    }

    // set URL to be our home page
    // http://stackoverflow.com/questions/24304752/how-to-handle-authentication-popup-with-selenium-webdriver-using-java
    @Override
    protected String getDefaultBaseUrl() {
        return Data.TEST_URL;
    }

    // this calls the resizing of the browser prior to every test
    @Before
    public void configureBrowserWidth() {
        configureWebDriver(driver());
    }

    //this will navigate us to our desired spot prior to each test beginning 
    @Before
    public void getToCurrentPage() {
        goTo(smoke);
    }

    // override the basic browser size to become 'browser_width' wide, and 1024 tall
    @Override
    protected void configureWebDriver(WebDriver driver) {
        driver.manage().window().setSize(new Dimension(browser_width, 1024));
    }

    @Test
    public void check_landing_page_navigation() throws Exception {
        smoke.hasNavigation();
    }

    @Test
    public void complete_questionnaire_and_see_model() throws Exception {
        smoke.completesQuestionnaire();
        smoke.seesPortfolioBar();
        smoke.seesModel();
        smoke.seesCalculator();
        smoke.seesPastPerformanceChart();
        smoke.seesPrereg();
    }

    //make a page object so that we can give it items to look for on the screen to test
    static class Smoke implements PageObject {
        //find elements on screen for testing
        // home page stuff
        DomElement startInvestingButton = find(By.xpath("//a[@aria-label='Start Investing']"));
        //risk assessment stuff
        DomElement buyHome = find("HOME");
        DomElement goalsNext = find("goalsNext");
        DomElement ageField = find("currentAge");
        DomElement investmentYears = find("investmentYears");
        DomElement questionOneSubmitButton = find("investmentTimeQuestionNext");
        DomElement knowledgeDescLittle = find("radio-button-5");
        DomElement questionTwoSubmitButton = find("investmentKnowledgeQuestionNext");
        DomElement annualIncomeOptionOne = find("radio-button-15");
        DomElement questionThreeSubmitButton = find("incomeQuestionNext");
        DomElement degreeRiskVerySmall = find("radio-button-20");
        DomElement questionFourSubmitButton = find("degreeOfRiskQuestionNext");
        DomElement wordAssocationDanger = find("radio-button-25");
        DomElement questionFiveSubmitButton = find("riskDefinitionQuestionNext");
        DomElement moreDebtThanAssets = find("radio-button-33");
        DomElement questionSixSubmitButton = find("assetDebtQuestionNext");
        DomElement reactionOptionOne = find("radio-button-29");
        DomElement questionSevenSubmitButton = find("investmentLossQuestionNext");
        DomElement showPlan = find(By.xpath("//button[@ng-click='startInvesting.goToResults()']"));
        //prereg stuff
        DomElement preregContainer = find(By.className("preRegistrationContainer"));
        DomElement preregGreeting = find(By.className("greeting"));
        DomElement preregInstructions = find(By.className("instructions"));
        DomElement preregEmailField = find("email");
        DomElement preregSubmitButton = find(By.xpath("//button[@translate='preRegistration.register']"));
        DomElement termsOfService = find(By.className("termsOfService"));
        DomElement disclaimer = find(By.className("disclaimer"));
        DomElement missingEmailError = find("preRegistrationEmailRequiredError");
        DomElement invalidEmailError = find("preRegistrationInvalidEmailError");
        DomElement successMessage = find(By.className("title"));
        DomElement gotItButton = find(By.xpath("//button[@ng-click='preRegistrationConfirmation.cancel()']"));
        // model stuff
        DomElement projectionGraph = find("futureValueGraph");
        DomElement closeDetails = find(By.xpath("//button[@aria-label='Close']"));
        DomElement chart = find(By.className("chartContainer"));
        DomElement equityLegend = find(By.className("ng-binding")).withText("Equity (");
        DomElement equityLegendDescription = find(By.xpath("//div[@translate='portfolioAllocationInformation.equityText']"));
        DomElement fixedIncomeLegend = find(By.className("ng-binding")).withText("Fixed Income (");
        DomElement fixedIncomeLegendDescription = find(By.xpath("//div[@translate='portfolioAllocationInformation.fixedIncomeText']"));
        DomElement portfolioTitle = find(By.className("chartTitle"));
        DomElement portfolioTypeTitle = find(By.className("portfolioTitle"));
        DomElement portfolioDetails = find(By.className("portfolioDetails"));
        DomElement viewDetailsButton = find(By.xpath("//button[@translate='portfolioAllocationInformation.viewDetails']"));
        DomElement assetBreakdownTitle = find(By.className("portfolioBreakdownHeader"));
        // calculator stuff
        DomElement calcTitle = find(By.className("layout-align-center-stretch")).withText().startingWith("Let's create a financial plan");
        DomElement recurringContributionField = find("ongoingInvestment");
        DomElement initialInvestmentField = find("initialInvestment");
        DomElement initialInvestmentLabel = find("initialInvestmentLabel");
        DomElement recurringContributionLabel = find("ongoingInvestmentLabel");
        DomElement frequencyDropdown = find(By.xpath("//md-select-value[@id='select_value_label_1']"));
        DomElement frequencyOptions = find("md-content");
        DomElement monthly = find("select_option_9");
        // past performance stuff
        DomElement performanceTitle = find(By.xpath("//h2[@translate='portfolioPastPerformance.title']"));
        DomElement pastPerformanceContainer = find(By.className("pastPerformanceContainer"));
        DomElement rorSelected = find(By.xpath("//button[@ng-click='portfolioPastPerformance.showRateOfReturn=true']"));
        DomElement dollarValueDeselected = find(By.xpath("//button[@ng-click='portfolioPastPerformance.showRateOfReturn=false']"));
        //portfolio bar stuff
        DomElement RecommendationTitle = find(By.className("layout-align-center-stretch")).withText().startingWith("Now that we understand you");
        DomElement portfolioBarTitle = find(By.className("ng-scope")).withText("Now that we understand you better, we've crafted a portfolio recommendation for you");
        DomElement conservativePortfolioButton = find(By.xpath("//md-radio-button[@aria-label='Conservative Portfolio']"));
        DomElement conservativeBalancedPortfolioButton = find(By.xpath("//md-radio-button[@aria-label='Conservative Balanced Portfolio']"));
        DomElement balancedPortfolioButton = find(By.xpath("//md-radio-button[@aria-label='Balanced Portfolio']"));
        DomElement balancedGrowthPortfolioButton = find(By.xpath("//md-radio-button[@aria-label='Balanced Growth Portfolio']"));
        DomElement growthPortfolioButton = find(By.xpath("//md-radio-button[@aria-label='Growth Portfolio']"));
        //landing page stuff
        DomElement howItWorksButton = find(By.xpath("//button[@aria-label='How It Works']"));
        DomElement commonQuestions = find(By.xpath("//button[@aria-label='Common Questions']"));
        DomElement costButton = find(By.xpath("//button[@aria-label='Costs']"));
        DomElement contactButton = find(By.xpath("//button[@aria-label='Contact Us']"));
        DomElement howTitle = find(By.xpath("//h2[@translate='landingPage.howWeMakeItHappen.header']"));
        DomElement commonQuestionsTitle = find(By.xpath("//h2[@translate='landingPage.investmentEducation.header']"));
        DomElement costsTitle = find(By.xpath("//h2[@translate='landingPage.investmentCost.howMuchHeadline']"));
        DomElement contactDescription = find(By.xpath("//div[@translate='landingPage.startInvesting.contactDescription']"));
        DomElement contactNumber = find(By.className("contactNumber"));


        public String url() {
            return "";
        }


        void hasNavigation() {
            howItWorksButton.click();
            howTitle.should().beDisplayed().contain("Here's how we make it happen");
            commonQuestions.click();
            commonQuestionsTitle.should().beDisplayed().contain("Common questions from people like you");
            costButton.click();
            costsTitle.should().beDisplayed().contain("How much does it cost?");
            contactButton.click();
            contactDescription.should().beDisplayed().contain("Have questions? Talk to one of our investment specialists. Give us a call at");
            contactNumber.should().beDisplayed().contain("1-800-123-4567");

        }

        void seesPortfolioBar() {
            RecommendationTitle.should().beDisplayed();
            portfolioBarTitle.should().beDisplayed();
            conservativePortfolioButton.should().beDisplayed();
            conservativeBalancedPortfolioButton.should().beDisplayed().contain("Conservative Balanced Portfolio");
            balancedPortfolioButton.should().beDisplayed().contain("Balanced Portfolio");
            balancedGrowthPortfolioButton.should().beDisplayed().contain("Balanced Growth Portfolio");
            growthPortfolioButton.should().beDisplayed().contain("Growth Portfolio");
        }

        void seesCalculator() {
            calcTitle.should().beDisplayed();
            // check that the initial investment field is visible and has a label which contains the correct text
            initialInvestmentField.should().beDisplayed().contain("100");
            initialInvestmentLabel.should().beDisplayed().contain("I can start investing with ($):");
            // check that recurring contribution field is visible and contains a 25 as the default value
            recurringContributionField.should().beDisplayed().contain("25");
            //check that the label for the field contains the correct text
            recurringContributionLabel.should().beDisplayed().contain("I plan to continue saving ($):");
            //check that the frequency dropdown field is visible and is defaulting to Monthly
            frequencyDropdown.should().beDisplayed().contain("Monthly");
            //verify the field options
            frequencyDropdown.click();
            frequencyOptions.should().contain("Weekly", "Bi-Weekly", "Monthly", "Annually");
            monthly.click();
        }

        void seesPastPerformanceChart() {
            performanceTitle.should().beDisplayed().contain("How has the", "Portfolio performed in the last 10 years?");
            pastPerformanceContainer.should().beDisplayed();
            rorSelected.should().beDisplayed();
            dollarValueDeselected.should().beDisplayed();
            projectionGraph.should().beDisplayed();
        }

        void seesPrereg() {
            //check visible
            preregContainer.should().beDisplayed();
            preregGreeting.should().beDisplayed();
            preregInstructions.should().beDisplayed();
            preregEmailField.should().beDisplayed();
            preregSubmitButton.should().beDisplayed();
            termsOfService.should().beDisplayed();
            disclaimer.should().beDisplayed();
            //uses prereg
            //clicks right away without entering any data
            preregSubmitButton.click();
            missingEmailError.should().beDisplayed();
            //check that @ is required
            preregEmailField.clear().sendKeys("klowrie.com");
            preregSubmitButton.click();
            invalidEmailError.should().beDisplayed();
            //check that period is required
            preregEmailField.clear().sendKeys("klowrie@atbcom");
            preregSubmitButton.click();
            invalidEmailError.should().beDisplayed();
            //check that symbols need to be in the correct order
            preregEmailField.clear().sendKeys("klworieatbcom.@");
            preregSubmitButton.click();
            invalidEmailError.should().beDisplayed();
            //enter valid stuff
            preregEmailField.clear().sendKeys("klowrie@atb.com");
            preregSubmitButton.click();
            successMessage.should().beDisplayed().contain("Email Sent Successfully");
            gotItButton.click();
        }

        void seesModel() {
            chart.should().beDisplayed();
            equityLegend.should().beDisplayed();
            fixedIncomeLegend.should().beDisplayed();
            equityLegendDescription.should().beDisplayed();
            fixedIncomeLegendDescription.should().beDisplayed();
            portfolioTitle.should().beDisplayed().contain("What's included in the portfolio?");
            portfolioDetails.should().beDisplayed();
            //using the selenium easy link to make sure model type matches selection
            //www.seleniumeasy.com/selenium-tutorials/how-to-get-attribute-values-using-webdriver
            WebElement selectedModel = driver().findElement(By.xpath("//md-radio-button[@class='md-checked']"));
            String portfolioTypeSelected = selectedModel.getAttribute("aria-label");
            portfolioTypeTitle.should().beDisplayed().contain(portfolioTypeSelected);
            viewDetailsButton.click();
            assetBreakdownTitle.should().beDisplayed().contain("Portfolio Asset Breakdown");
            closeDetails.click();
        }

        void completesQuestionnaire() {
            startInvestingButton.click();
            buyHome.click();
            goalsNext.click();
            try {
                Thread.sleep(Data.SLEEP_SHORT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ageField.clear().sendKeys(Data.CURRENT_AGE);
            investmentYears.clear().sendKeys("22");
            questionOneSubmitButton.click();
            try {
                Thread.sleep(Data.SLEEP_SHORT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            knowledgeDescLittle.click();
            questionTwoSubmitButton.click();
            try {
                //added 50 more cuz flaky. FLAKY!!!!
                Thread.sleep(Data.SLEEP_SHORT+50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            annualIncomeOptionOne.click();
            questionThreeSubmitButton.click();
            try {
                Thread.sleep(Data.SLEEP_SHORT+50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            degreeRiskVerySmall.click();
            questionFourSubmitButton.click();
            try {
                Thread.sleep(Data.SLEEP_SHORT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            wordAssocationDanger.click();
            questionFiveSubmitButton.click();
            try {
                Thread.sleep(Data.SLEEP_SHORT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moreDebtThanAssets.click();
            questionSixSubmitButton.click();
            try {
                Thread.sleep(Data.SLEEP_SHORT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reactionOptionOne.click();
            questionSevenSubmitButton.click();
            try {
                //added 50 more cuz flaky. FLAKY!!!!
                Thread.sleep(Data.SLEEP_SHORT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            showPlan.click();
            try {
                //added 50 more cuz flaky. FLAKY!!!!
                Thread.sleep(Data.SLEEP_SHORT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } // end completesQuestionnaire

    } // end of page object
}