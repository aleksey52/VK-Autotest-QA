package org.vkeducation.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("All Auto Tests Test Suite")
@SelectPackages("org.vkeducation.tests")
@IncludeTags("AutoTest")
public class AllAutoTestsTestSuite {
}
