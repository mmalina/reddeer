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
package org.jboss.reddeer.junit.test.integration.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.jboss.reddeer.junit.requirement.CustomConfiguration;
import org.jboss.reddeer.junit.requirement.Requirement;
import org.jboss.reddeer.junit.test.integration.configuration.JavaRequirement.CustomConfigJavaRequirementAAnnotation;

public class JavaRequirement implements Requirement<CustomConfigJavaRequirementAAnnotation>, CustomConfiguration<JavaRequirementConfig> {

	private JavaRequirementConfig config;
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.TYPE)
	public @interface CustomConfigJavaRequirementAAnnotation {
		
	}
	
	public boolean canFulfill() {
		return true;
	}

	public void fulfill() {
	}

	public Class<JavaRequirementConfig> getConfigurationClass() {
		return JavaRequirementConfig.class;
	}

	public void setConfiguration(JavaRequirementConfig config) {
		this.config = config;
	}
	
	public JavaRequirementConfig getConfig() {
		return config;
	}

	@Override
	public void setDeclaration(CustomConfigJavaRequirementAAnnotation a) {
		
	}

	@Override
	public void cleanUp() {
		// TODO Auto-generated method stub
		
	}
}
