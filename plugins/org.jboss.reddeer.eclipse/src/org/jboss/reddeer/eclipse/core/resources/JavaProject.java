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
package org.jboss.reddeer.eclipse.core.resources;

import org.jboss.reddeer.swt.api.TreeItem;

/**
 * Represents Java project inside Project explorer, Package explorer or Resource Navigator.
 * 
 * @author mlabuda@redhat.com
 *
 */
public class JavaProject extends Project {

	/**
	 * Creates object representing java project.
	 *
	 * @param item the item
	 */
	public JavaProject(TreeItem item) {
		super(item);
	}
	
	/* (non-Javadoc)
	 * @see org.jboss.reddeer.eclipse.core.resources.Project#getNatureIds()
	 */
	@Override
	public String[] getNatureIds() {
		return new String[] {"org.eclipse.jdt.core.javanature"};
	}
}
