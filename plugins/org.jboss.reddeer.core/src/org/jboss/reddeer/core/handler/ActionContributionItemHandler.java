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
package org.jboss.reddeer.core.handler;

import org.eclipse.jface.action.ActionContributionItem;
import org.jboss.reddeer.core.util.Display;
import org.jboss.reddeer.core.util.ResultRunnable;

/**
 * Contains methods for handling UI operations on {@link ActionContributionItem}
 * widgets.
 * 
 * @author rawagner
 *
 */
public class ActionContributionItemHandler {

	private static ActionContributionItemHandler handler;

	private ActionContributionItemHandler() {

	}

	/**
	 * Gets instance of ActionContributionHandler.
	 * 
	 * @return instance of ActionContributionHandler
	 */
	public static ActionContributionItemHandler getInstance() {
		if (handler == null) {
			handler = new ActionContributionItemHandler();
		}
		return handler;
	}

	/**
	 * Finds out whether specified {@link ActionContributionItem} is enabled or
	 * not.
	 * 
	 * @param item item to handle
	 * @return true if specified item is enabled, false otherwise
	 */
	public boolean isEnabled(final ActionContributionItem item) {
		return Display.syncExec(new ResultRunnable<Boolean>() {

			@Override
			public Boolean run() {
				return item.isEnabled();
			}
		});
	}
}
