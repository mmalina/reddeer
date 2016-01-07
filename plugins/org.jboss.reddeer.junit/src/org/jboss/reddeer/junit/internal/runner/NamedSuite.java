/******************************************************************************* 
 * Copyright (c) 2016 Red Hat, Inc. 
 * Distributed under license by Red Hat, Inc. All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 ******************************************************************************/ 
package org.jboss.reddeer.junit.internal.runner;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * Suite with custom name. 
 * 
 * @author Lucia Jelinkova
 *
 */
public class NamedSuite extends Suite {
	
	private final String suiteName;

	/**
	 * Constructor used for suites. 
	 *
	 * @param clazz the clazz
	 * @param builder the builder
	 * @param name the name
	 * @throws InitializationError the initialization error
	 */
	public NamedSuite(Class<?> clazz, RunnerBuilder builder, String name) throws InitializationError {
		super(clazz, builder);
		this.suiteName = name;
	}
	
	/**
	 * Constructor used for separate undependent classes. 
	 *
	 * @param classes the classes
	 * @param builder the builder
	 * @param name the name
	 * @throws InitializationError the initialization error
	 */
	public NamedSuite(Class<?>[] classes, RunnerBuilder builder, String name) throws InitializationError {
		super(builder, EmptySuite.class, classes);
		this.suiteName = name;
	}
	
	/* (non-Javadoc)
	 * @see org.junit.runners.ParentRunner#getName()
	 */
	@Override
	public String getName() {
		return suiteName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Suite '" + suiteName + "'";
	}
}
