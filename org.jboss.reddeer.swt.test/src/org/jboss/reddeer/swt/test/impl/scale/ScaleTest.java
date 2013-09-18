package org.jboss.reddeer.swt.test.impl.scale;

import static org.junit.Assert.assertTrue;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.jboss.reddeer.swt.api.Scale;
import org.jboss.reddeer.swt.api.Text;
import org.jboss.reddeer.swt.exception.SWTLayerException;
import org.jboss.reddeer.swt.impl.scale.DefaultScale;
import org.jboss.reddeer.swt.impl.text.DefaultText;
import org.jboss.reddeer.swt.test.RedDeerTest;
import org.jboss.reddeer.swt.util.Display;
import org.junit.After;
import org.junit.Test;
/**
 * Tests Scale implementation
 * @author vlado pakan
 *
 */
public class ScaleTest extends RedDeerTest{
	private static final int[] SCALE_MAXIMUM = new int[]{100,200};
	private static final int[] SCALE_MINIMUM = new int[]{10,110};
	private static final int[] SCALE_INIT_VALUE = new int[]{50,150};
	private Text selectionText = null;
	private SelectionListener selectionListener;
	@Override
	public void setUp() {
		super.setUp();
		Display.syncExec(new Runnable() {
			@Override
			public void run() {
				Shell shell = new Shell( Display.getDisplay());
				shell.setText("Testing shell");
				createControls(shell);
				shell.open();
				shell.setFocus();
			}
		});
	}
	
	private void createControls(Shell shell){
		shell.setLayout(new FillLayout());
		this.selectionListener = new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				org.eclipse.swt.widgets.Scale selectedScale = (org.eclipse.swt.widgets.Scale)arg0.widget;
				getSelectionText().setText(String.valueOf(selectedScale.getSelection()));
			}
			
			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {
				// do nothing
			}
		};
		for (int index = 0 ; index < ScaleTest.SCALE_INIT_VALUE.length ; index++){
			org.eclipse.swt.widgets.Scale scale = new org.eclipse.swt.widgets.Scale(shell, SWT.BORDER);
			scale.setMaximum(ScaleTest.SCALE_MAXIMUM[index]);
			scale.setMinimum(ScaleTest.SCALE_MINIMUM[index]);
			scale.setIncrement(1);
			scale.setSelection(ScaleTest.SCALE_INIT_VALUE[index]);
			scale.addSelectionListener(selectionListener);
		}
		org.eclipse.swt.widgets.Text txSelection = new org.eclipse.swt.widgets.Text(shell,SWT.BORDER);
		txSelection.setText("<value of selected scale>");
	}
	@After
	public void cleanup() {
		Display.syncExec(new Runnable() {
			@Override
			public void run() {
				for (Shell shell : org.jboss.reddeer.swt.
						util.Display.getDisplay().getShells()) {
					if (shell.getText().equals("Testing shell")) {
						shell.dispose();
						break;
					}
				}
			}
		});
	}
	@Test
	public void findScaleByIndex(){
		int index = 1;
		Scale scale = new DefaultScale(index);
		assertTrue("Wrong scale widget was found",
			scale.getMinimum() == ScaleTest.SCALE_MINIMUM[index]);
	}
	@Test(expected=SWTLayerException.class)
	public void findNonExistingScaleByIndex(){
		int index = 4;
		new DefaultScale(index);
	}
	@Test
	public void getMinimum(){
		int index = 0;
		Scale scale = new DefaultScale(index);
		int minimum = scale.getMinimum();
		assertTrue("Wrong scale minimum value. Was " + minimum
				+ " expected was " + ScaleTest.SCALE_MINIMUM[index],
			minimum == ScaleTest.SCALE_MINIMUM[index]);
	}
	@Test
	public void getMaximum(){
		int index = 1;
		Scale scale = new DefaultScale(index);
		int maximum = scale.getMaximum();
		assertTrue("Wrong scale maximum value. Was " + maximum
				+ " expected was " + ScaleTest.SCALE_MINIMUM[index],
			maximum == ScaleTest.SCALE_MAXIMUM[index]);
	}
	@Test
	public void getSelection(){
		int index = 1;
		Scale scale = new DefaultScale(index);
		int selection = scale.getSelection();
		assertTrue("Wrong scale selection value. Was " + selection
				+ " expected was " + ScaleTest.SCALE_INIT_VALUE[index],
			selection == ScaleTest.SCALE_INIT_VALUE[index]);
	}
	@Test
	public void setSelection(){
		Scale scale = new DefaultScale();
		int newSelection = 80;
		scale.setSelection(newSelection);
		int selection = scale.getSelection();
		assertTrue("Scale selection value was not set. It was " + selection
				+ " expected was " + newSelection,
			selection == newSelection);
		// Check if selection event was fired
		assertTrue("Selection Event was not fired properly",
				getSelectionText().getText().equals(String.valueOf(newSelection)));
	}
	private Text getSelectionText(){
		if (this.selectionText == null){
			this.selectionText = new DefaultText(0);
		}
		return this.selectionText;
	}
}
