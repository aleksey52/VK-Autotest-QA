package org.vkeducation.suites;

import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Login Page Test Suite")
@SelectPackages("org.vkeducation.tests")
@IncludeTags("LoginPage")
public class LoginPageTestSuite {
}
