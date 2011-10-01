package nl.whitehorses.bpel.unit;

import java.util.Hashtable;
import java.util.UUID;
import java.util.List;

import javax.naming.Context;

import oracle.soa.management.facade.Locator;
import oracle.soa.management.facade.LocatorFactory;

import oracle.soa.management.util.TestSuiteFilter;
import oracle.soa.management.util.TestRunOptions;

import oracle.soa.management.facade.tst.TestSuite;
import oracle.soa.management.facade.tst.TestCase;
import oracle.soa.management.facade.tst.TestRunResults;
import oracle.soa.management.facade.tst.TestSuiteResult;
import oracle.soa.management.facade.tst.TestCaseResult;


public class StartUnitProcess {
    public StartUnitProcess() {
        super();

        Hashtable jndiProps = new Hashtable();
        jndiProps.put(Context.PROVIDER_URL, "t3://soaps3.alfa.local:8001/soa-infra");
        jndiProps.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
        jndiProps.put(Context.SECURITY_PRINCIPAL, "weblogic");
        jndiProps.put(Context.SECURITY_CREDENTIALS, "weblogic1");
        jndiProps.put("dedicated.connection", "true");

        Locator locator = null;
        try {
            // connect to the soa server
            locator = LocatorFactory.createLocator(jndiProps);

            TestSuiteFilter testFilter = new TestSuiteFilter();
            testFilter.addSuiteName("test");
            String compositeDN = "default/Helloworld!1.0";
            List<TestSuite> testSuites = locator.getTestSuites(compositeDN,testFilter);
            
            for (TestSuite testSuite : testSuites) { 
                System.out.println("Found TestSuite name: "+testSuite.getName()+" description: "+testSuite.getDescription());
                
                List<TestCase> testcases = testSuite.getTestCases();
                System.out.println("Total TestCases: " +testcases.size());
               
                for (TestCase testCase : testcases) {
                    System.out.println("Contains TestCase: " +testCase.getName());
                }
                
                TestRunOptions testRunOptions = new TestRunOptions();
                testRunOptions.setTestRunId("123");
                testRunOptions.setTestRunName("name123");
                
                TestRunResults result =  locator.executeTestCases(compositeDN,testRunOptions,testcases);
                System.out.println("total errors: "+ result.getNumErrors() + 
                                   " status: "+ result.getStatus());

                List<TestSuiteResult> testSuiteResults = result.getTestSuiteResults() ;
                for (TestSuiteResult testSuiteResult : testSuiteResults) {
                    System.out.println("TestSuite name: "+testSuiteResult.getSuiteName()+
                                       " success: "+testSuiteResult.getNumSuccesses()  + 
                                       " errors: "+ testSuiteResult.getNumErrors() );
                    List<TestCaseResult> testCaseResults = testSuiteResult.getTestResults() ;   
                    for (TestCaseResult testCaseResult : testCaseResults) {
                        System.out.println("TestCase name: "+testCaseResult.getTestName()+
                                           " status: "+testCaseResult.getStatus()   );
                    }                    
                }                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void main(String[] args) {
        StartUnitProcess startUnitProcess = new StartUnitProcess();
    }
}
