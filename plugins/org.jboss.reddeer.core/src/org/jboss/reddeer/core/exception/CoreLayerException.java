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

import org.jboss.reddeer.common.exception.RedDeerException;
/**
 * RedDeer CoreLayerException indicates exceptional situation at RedDeer core layer.
 * 
 * @author Jiri Peterka
 *
 */
public class CoreLayerException extends RedDeerException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs a new CoreLayerException with the specified detail message.
	 * 
	 * @param message the detail message
	 */
	public CoreLayerException(String message) {
		super(message);
	}

	/**
	 * Constructs a new CoreLayerException with the specified detail
	 * message and cause.
	 * 
	 * @param message the detail message
	 * @param cause the cause of exception
	 */
	public CoreLayerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a new CoreLayerException with the specified detail
	 * message, cause and messageDetails.
	 * 
	 * @param message the detail message
	 * @param cause the cause of exception
	 * @param messageDetails details of message
	 */
	public CoreLayerException(String message, Throwable cause,
			String[] messageDetails) {
		super(message, cause);
		if (messageDetails != null) {
			for (String messageDetail : messageDetails) {
				addMessageDetail(messageDetail);
			}
		}
	}

	/**
	 * Constructs a new CoreLayerException with the specified detail
	 * message and messageDetails.
	 * 
	 * @param message the detail message
	 * @param messageDetails details of message
	 */
	public CoreLayerException(String message, String[] messageDetails) {
		super(message);
		if (messageDetails != null) {
			for (String messageDetail : messageDetails) {
				addMessageDetail(messageDetail);
			}
		}
	}
}
