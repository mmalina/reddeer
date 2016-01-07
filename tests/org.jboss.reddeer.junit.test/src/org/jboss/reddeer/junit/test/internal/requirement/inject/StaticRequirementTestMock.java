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
package org.jboss.reddeer.junit.test.internal.requirement.inject;

import org.jboss.reddeer.junit.requirement.inject.InjectRequirement;

public class StaticRequirementTestMock {

	@InjectRequirement
	private static RequirementA requirementA;

	public static RequirementA getRequirementA() {
		return requirementA;
	}

}
