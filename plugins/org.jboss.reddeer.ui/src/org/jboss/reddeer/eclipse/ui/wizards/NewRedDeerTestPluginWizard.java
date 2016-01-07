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
package org.jboss.reddeer.eclipse.ui.wizards;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.jboss.reddeer.eclipse.ui.project.ProjectCreator;

/**
 * Wizard for creating new RedDeer Test Plugin Project in workspace.
 * 
 * @author sbunciak
 * @since 0.2
 */
public class NewRedDeerTestPluginWizard extends Wizard implements INewWizard {
	
	private final NewRedDeerTestPluginWizardPage wizardPage;

	/**
	 * Creates new instance of new RedDeer Test Plugin wizard
	 */
	public NewRedDeerTestPluginWizard() {
		setWindowTitle("New RedDeer Test Plugin");
		wizardPage = new NewRedDeerTestPluginWizardPage();
	}

	/**
	 * Adds all appropriate wizard pages.
	 */
	public void addPages() {
		addPage(wizardPage);
	}

	/**
	 * Starts the project creation process.
	 * 
	 * @see {@link org.eclipse.jface.wizard.performFinish}
	 */
	@Override
	public boolean performFinish() {
		String pluginName = wizardPage.pluginName();
		String pluginId = wizardPage.pluginId();
		String pluginVersion = wizardPage.pluginVersion();
		String pluginProvider = wizardPage.pluginProvider();
		boolean generateTest = wizardPage.generateTest();

		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		ProjectCreator projectCreator = new ProjectCreator(pluginId,
				pluginName, pluginVersion, pluginProvider, generateTest, root);
		try {
			projectCreator.create();
			return true;
		} catch (CoreException e) {
			projectCreator.delete();
			return false;
		}
	}


	/**
	 * @see {@link org.eclipse.ui.iWorkbenchWizard.init}
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// intentionally left blank
	}
}
