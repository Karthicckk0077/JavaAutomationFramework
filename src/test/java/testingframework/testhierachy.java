package testingframework;


import org.testng.annotations.*;

public class testhierachy {
    @BeforeSuite
    // executes before the start
    public void beforeSuiteMethod(){
        System.out.println("Before Suite Gets Triggered");
    }

    @AfterSuite
    // executes after the end
    public void afterSuiteMethod(){
        System.out.println("After Suite gets triggered");
    }

    @BeforeTest
    // before the execution of test run
    public void beforeTestRun(){
        System.out.println("Before Test Runs method gets triggered");
    }

    @AfterTest
    // after the execution of test run
    public void afterTestRunMethod(){
        System.out.println("After Test Runs method gets triggered");

    }

    @BeforeClass
//    before execution of class inside it
    public void beforeClassMethod(){
        System.out.println("Before Class method gets triggered");
    }

    @AfterClass
    public void afterClassMethod(){
        System.out.println("After Class method gets triggered");
    }

    @BeforeMethod
    public void beforeTestMethod(){
        System.out.println("Before Test method gets triggered");
    }

    @AfterMethod
    public void afterTestMethod(){
        System.out.println("After Test method gets triggered");
    }

    @Test
    public void TESTCASEONE(){
        System.out.println("Test case one");
    }

    @Test
    public void TESTCASETWO(){
        System.out.println("Test case two");
    }
}

