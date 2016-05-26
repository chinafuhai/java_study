package org.springframework.test.context.junit4;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.springframework.test.context.TestContextManager;

public class SpringBlockJUnit4ClassRunner extends BlockJUnit4ClassRunner {

	private static final Log logger = LogFactory.getLog(SpringBlockJUnit4ClassRunner.class);

	private final TestContextManager testContextManager;

	public SpringBlockJUnit4ClassRunner(Class<?> clazz) throws InitializationError {
		super(clazz);
		if (logger.isDebugEnabled()) {
			logger.debug("SpringBlockJUnit4ClassRunner constructor called with [" + clazz + "].");
		}
		this.testContextManager = createTestContextManager(clazz);
	}

	protected Object createTest() throws Exception {
		Object testInstance = super.createTest();
		getTestContextManager().prepareTestInstance(testInstance);
		return testInstance;
	}

	protected TestContextManager createTestContextManager(Class<?> clazz) {
		return new TestContextManager(clazz);
	}

	protected final TestContextManager getTestContextManager() {
		return this.testContextManager;
	}

}

