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
package org.jboss.reddeer.swt.impl.progressbar;

import org.eclipse.swt.widgets.ProgressBar;
import org.jboss.reddeer.core.util.Display;
import org.jboss.reddeer.core.util.ResultRunnable;

/**
 *	Contains methods that handle UI operations on {@link ProgressBar} widgets. 
 * 
 * @author rhopp
 *
 */
public class ProgressBarHandler {
	
	private static ProgressBarHandler instance;
	
	private ProgressBarHandler() { }
	
	/**
	 * Creates and returns instance of ProgressBarHandler class.
	 *
	 * @return single instance of ProgressBarHandler
	 */
	public static ProgressBarHandler getInstance(){
		if (instance == null){
			instance = new ProgressBarHandler();
		}
		return instance;
	}
	
	
	/**
	 * Returns state of {@link ProgressBar}.
	 *
	 * @param widget the widget
	 * @return the state
	 */
	
	public int getState(final ProgressBar widget){
		return Display.syncExec(new ResultRunnable<Integer>() {
			@Override
			public Integer run() {
				return widget.getState();
			}
		});
	}
	
	/**
	 * Returns maximum of {@link ProgressBar}.
	 *
	 * @param widget the widget
	 * @return the maximum
	 */
	
	public int getMaximum(final ProgressBar widget){
		return Display.syncExec(new ResultRunnable<Integer>() {
			@Override
			public Integer run() {
				return widget.getMaximum();
			}
		});
	}
	
	/**
	 * Returns minimum of {@link ProgressBar}.
	 *
	 * @param widget the widget
	 * @return the minimum
	 */
	
	public int getMinimum(final ProgressBar widget){
		return Display.syncExec(new ResultRunnable<Integer>() {
			@Override
			public Integer run() {
				return widget.getMinimum();
			}
		});
	}
	
	/**
	 * Returns selection of {@link ProgressBar}.
	 *
	 * @param widget the widget
	 * @return the selection
	 */
	
	public int getSelection(final ProgressBar widget){
		return Display.syncExec(new ResultRunnable<Integer>() {
			@Override
			public Integer run() {
				return widget.getSelection();
			}
		});
	}

}
