package com.crm.qa.util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 3;

    public boolean retry(ITestResult iTestResult) {

        if (counter < retryLimit) {
            counter = counter + 1;
            System.out.println("Method ["+iTestResult.getMethod().getMethodName()+"] from Class "+iTestResult.getTestClass().toString()+"got failed , retrying it again , retry count"+counter);
            return true;
        }

        return false;
    }
}
