package org.jboss.reddeer.junit.runner;

import java.util.ArrayList;
import java.util.List;

import org.jboss.reddeer.junit.internal.configuration.SuiteConfiguration;
import org.jboss.reddeer.junit.internal.configuration.TestRunConfiguration;
import org.jboss.reddeer.junit.internal.runner.EmptySuite;
import org.jboss.reddeer.junit.internal.runner.NamedSuite;
import org.jboss.reddeer.junit.internal.runner.RequirementsRunnerBuilder;
import org.junit.runner.Runner;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * 
 * Allows to run the tests (single or a suite) for each configuration file provided. 
 * 
 * @author Lucia Jelinkova
 *
 */
public class RedDeerSuite extends Suite {
	
	/**
	 * Called by the JUnit framework. 
	 * 
	 * @param clazz
	 * @param builder
	 * @throws InitializationError
	 */
	public RedDeerSuite(Class<?> clazz, RunnerBuilder builder) throws InitializationError {
		this(clazz, builder, new SuiteConfiguration());
	}

	/**
	 * The {@link EmptySuite} makes sure that the @BeforeClass and @AfterClass are not called
	 * on the suite class too often. 
	 * 
	 * @param clazz
	 * @param builder
	 * @param config
	 * @throws InitializationError
	 */
	protected RedDeerSuite(Class<?> clazz, RunnerBuilder builder, SuiteConfiguration config) throws InitializationError {
		super(EmptySuite.class, createSuite(clazz, config));
	}
	
	/**
	 * Creates a new suite for each configuration file found. 
	 * 
	 * @param clazz
	 * @param config
	 * @return
	 * @throws InitializationError
	 */
	protected static List<Runner> createSuite(Class<?> clazz, SuiteConfiguration config) throws InitializationError{
		List<Runner> configuredSuites = new ArrayList<Runner>();
		boolean isSuite = isSuite(clazz);
		
		for (TestRunConfiguration testRunConfig : config.getTestRunConfigurations()){
			if (isSuite){
				configuredSuites.add(new NamedSuite(clazz, new RequirementsRunnerBuilder(testRunConfig), testRunConfig.getId()));
			} else {
				configuredSuites.add(new NamedSuite(new Class[]{clazz}, new RequirementsRunnerBuilder(testRunConfig), testRunConfig.getId()));				
			}
		}
		
		return configuredSuites;
	}
	
	private static boolean isSuite(Class<?> clazz) {
		SuiteClasses annotation = clazz.getAnnotation(SuiteClasses.class);
		return annotation != null;
	}
	
	@Override
	protected String getName() {
		return "Red Deer Suite";
	}
}
