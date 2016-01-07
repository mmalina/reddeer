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
package org.jboss.reddeer.eclipse.test.ui.wizards.newresource;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.jboss.reddeer.eclipse.exception.EclipseLayerException;
import org.jboss.reddeer.eclipse.jdt.ui.packageexplorer.PackageExplorer;
import org.jboss.reddeer.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.jboss.reddeer.eclipse.ui.dialogs.WizardNewProjectReferencePage;
import org.jboss.reddeer.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.jboss.reddeer.eclipse.utils.DeleteUtils;
import org.jboss.reddeer.junit.runner.RedDeerSuite;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(RedDeerSuite.class)
public class BasicNewProjectResourceWizardTest {

	private static final String DEFAULT_PROJECT_NAME = "defaultGeneralProject";
	private static final String CUSTOMIZED_PROJECT_NAME = "customizedGeneralProject";
	private PackageExplorer packageExplorer;
	private static final String CUSTOM_PROJECT_LOCATION = System
			.getProperty("java.io.tmpdir")
			+ File.separator
			+ "rdcustomprojectlocation" + System.currentTimeMillis();

	@Before
	public void setUp() {
		packageExplorer = new PackageExplorer();
	}

	@Test
	public void createGeneralProjectsWithReferences() {
		// create defult project
		packageExplorer.open();
		BasicNewProjectResourceWizard wizardDialog = new BasicNewProjectResourceWizard();
		wizardDialog.open();
		WizardNewProjectCreationPage projectPage = new WizardNewProjectCreationPage();
		projectPage
				.setProjectName(BasicNewProjectResourceWizardTest.DEFAULT_PROJECT_NAME);
		wizardDialog.finish();
		// create customized project
		wizardDialog.open();
		projectPage
				.setProjectName(BasicNewProjectResourceWizardTest.CUSTOMIZED_PROJECT_NAME);
		File customProjectDir = new File(
				BasicNewProjectResourceWizardTest.CUSTOM_PROJECT_LOCATION);
		if (customProjectDir.exists()) {
			customProjectDir.delete();
		}
		customProjectDir.mkdir();
		projectPage
				.setProjectLocation(BasicNewProjectResourceWizardTest.CUSTOM_PROJECT_LOCATION);
		try {
			projectPage.addProjectToWorkingSet("dummyws");
		} catch (EclipseLayerException wnee) {
			// do nothing this exception means there is no Working set
			// defined but all widgets were found
		}
		wizardDialog.next();
		new WizardNewProjectReferencePage()
				.setProjectReferences(BasicNewProjectResourceWizardTest.DEFAULT_PROJECT_NAME);
		wizardDialog.finish();
		assertTrue(
				"Package Explorer has to contain project "
						+ BasicNewProjectResourceWizardTest.CUSTOMIZED_PROJECT_NAME
						+ " but it doesn't",
				packageExplorer
						.containsProject(BasicNewProjectResourceWizardTest.CUSTOMIZED_PROJECT_NAME));
	}

	@Test
	public void createGeneralProjects() {
		// create default project
		BasicNewProjectResourceWizard wizardDialog = new BasicNewProjectResourceWizard();
		wizardDialog.open();
		WizardNewProjectCreationPage projectPage = new WizardNewProjectCreationPage();
		projectPage
				.setProjectName(BasicNewProjectResourceWizardTest.DEFAULT_PROJECT_NAME);
		wizardDialog.finish();
		packageExplorer.open();
		assertTrue(
				"Package Explorer has to contain project "
						+ BasicNewProjectResourceWizardTest.DEFAULT_PROJECT_NAME
						+ " but it doesn't",
				packageExplorer
						.containsProject(BasicNewProjectResourceWizardTest.DEFAULT_PROJECT_NAME));
	}

	@After
	public void tearDown() {
		packageExplorer.open();
		if (packageExplorer.containsProject(BasicNewProjectResourceWizardTest.CUSTOMIZED_PROJECT_NAME)){
			DeleteUtils.forceProjectDeletion(packageExplorer.getProject(
					BasicNewProjectResourceWizardTest.CUSTOMIZED_PROJECT_NAME),
				true);
		}
		if (packageExplorer.containsProject(BasicNewProjectResourceWizardTest.DEFAULT_PROJECT_NAME)){
			DeleteUtils.forceProjectDeletion(packageExplorer.getProject(
					BasicNewProjectResourceWizardTest.DEFAULT_PROJECT_NAME),
				true);
		}
		File customProjectDir = new File(
				BasicNewProjectResourceWizardTest.CUSTOM_PROJECT_LOCATION);
		if (customProjectDir.exists()) {
			customProjectDir.delete();
		}
	}
}
