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
package org.jboss.reddeer.common.properties;

import static org.junit.Assert.fail;

import org.jboss.reddeer.common.logging.Logger;
import org.junit.Test;

/**
 * Simple RedDeer logger test
 * @author Jiri Peterka
 *
 */

public class LoggerTest {

	
	private static final Logger log = Logger.getLogger(LoggerTest.class);
			
	@Test
	public void testLoggerMessageTypes() {
		
		final String message = " testing RedDeer logger message"; 
		
		try {
			log.debug("DEBUG" + message);
			log.dump("DUMP" + message);
			log.error("ERROR" + message);
			log.fatal("FATAL" + message);
			log.info("INFO" + message);
			log.step("STEP" + message);
			log.trace("TRACE" + message);
			
			
		} catch(Exception e) {
			fail("Logger error:" + e.getMessage());
		}
	}
}
