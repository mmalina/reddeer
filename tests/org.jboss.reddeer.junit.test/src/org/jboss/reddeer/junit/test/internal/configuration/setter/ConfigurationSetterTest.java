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
package org.jboss.reddeer.junit.test.internal.configuration.setter;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.lang.annotation.Annotation;

import org.jboss.reddeer.junit.internal.configuration.entity.Property;
import org.jboss.reddeer.junit.internal.configuration.entity.PropertyBasedConfiguration;
import org.jboss.reddeer.junit.internal.configuration.setter.ConfigurationSetter;
import org.jboss.reddeer.junit.requirement.PropertyConfiguration;
import org.jboss.reddeer.junit.requirement.Requirement;
import org.junit.Test;

public class ConfigurationSetterTest {

	private ConfigurationSetter setter = new ConfigurationSetter();
	
	@Test
	public void set_propertyBasedConfiguration() {
		PropertyBasedConfiguration configuration = new PropertyBasedConfiguration();
		configuration.getProperties().add(new Property("a", "1"));
		configuration.getProperties().add(new Property("b", "2"));
		
		PropertyBasedRequirement requirement = new PropertyBasedRequirement();
		
		setter.set(requirement, configuration);
		
		assertThat(requirement.getA(), is("1"));
		assertThat(requirement.getB(), is("2"));
	}
	
	public static class PropertyBasedRequirement implements Requirement<Annotation>, PropertyConfiguration{

		private String a;
		
		private String b;
		
		public boolean canFulfill() {
			return false;
		}

		public void fulfill() {
		}
		
		public void setA(String a) {
			this.a = a;
		}
		
		public String getA() {
			return a;
		}
		
		public void setB(String b) {
			this.b = b;
		}
		
		public String getB() {
			return b;
		}
		
		@Override
		public void setDeclaration(Annotation declaration) {
		}

		@Override
		public void cleanUp() {
			// TODO Auto-generated method stub
			
		}
	}
}
