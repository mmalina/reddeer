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

import org.eclipse.swt.SWT;

/**
 * This class represents progress bar with style SWT.HORIZONTAL
 * 
 * @author rhopp
 *
 */

public class HorizontalProgressBar extends DeterminateProgressBar {

	/**
	 * Instantiates horizontal progressbar with given index.
	 *
	 * @param index the index
	 */
	public HorizontalProgressBar(int index) {
		super(index, SWT.HORIZONTAL);
	}
	
	/**
	 * Instantiates horizontal progressbar.
	 */
	public HorizontalProgressBar() {
		super(0, SWT.HORIZONTAL);
	}

}
