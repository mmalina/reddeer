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
package org.jboss.reddeer.core.exception;

/**
 * Thrower throws exceptions when condition is met.
 * 
 * @author Jiri Peterka
 *
 */
public class Thrower {

	/**
	 * Throws CoreLayerException with specified message if specified object is null.
	 * 
	 * @param object object to check its existence
	 * @param message message to throw if object is null
	 */
	public static void objectIsNull(Object object, String message) {
		if (object == null) {
			throw new CoreLayerException(message);
		}
	}

	/**
	 * Throws CoreLayerException if specified object is not an instance of specified class.
	 * 
	 * @param object object to check its type
	 * @param clazz matching class
	 */
	public static void typeIsWrong(Object object, Class<?> clazz) {
		if (!object.getClass().isInstance(object)) {
			throw new CoreLayerException("Unexpected type, expected "
					+ clazz.getName() + " actual " + object.getClass().getName());
		}
	}
}
