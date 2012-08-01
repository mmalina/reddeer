package org.jboss.reddeer.swt.impl.shell;

import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.ui.PlatformUI;
import org.jboss.reddeer.swt.api.Shell;
import org.jboss.reddeer.swt.util.Display;

/**
 * WorkbenchShell is Shell implementation for WorkbenchShell
 * @author Jiri Peterka
 *
 */
public class WorkbenchShell extends BasicShell implements Shell {

	/**
	 * Default Constructor for a WorkbenchShell
	 */
	public WorkbenchShell() {
		
		Display.syncExec(new Runnable() {

			@Override
			public void run() {
				org.eclipse.swt.widgets.Shell swtShell;
				swtShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				shell = new SWTBotShell(swtShell);
			}			
		});
	}
}
