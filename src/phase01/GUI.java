package phase01;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.sun.glass.ui.Pixels.Format;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class GUI extends ApplicationWindow {
	private Text txtInput;
	private Label lblNumberCharacters;
	private Label lblNumberWords;
	private Text txtNumberResult;
	private Text txtReformatResult;
	private Text txtBreakResult;
	private Text txtSortResult;
	private Text txtCaseFResult;
	private Text txtAddLineResult;
	private TextUtilities format = new TextUtilities("");

	/**
	 * Create the application window.
	 */
	public GUI() {
		super(null);
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window.
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		parent.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		parent.setEnabled(false);
		Composite container = new Composite(parent, SWT.NO_BACKGROUND);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		container.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));
		
		Label lblInput = new Label(container, SWT.WRAP | SWT.SHADOW_IN | SWT.CENTER);
		lblInput.setAlignment(SWT.CENTER);
		lblInput.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblInput.setBounds(24, 31, 86, 46);
		lblInput.setText("User Input");
		
		txtInput = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		// modifyText Event of txtInput
		txtInput.addModifyListener(new ModifyListener() {
			@Override
		    public void modifyText(ModifyEvent e) {
		    	int dumb = txtInput.getText().length();
		    	// set current number of characters into lblNumberCharacters 
		    	lblNumberCharacters.setText(Integer.toString(dumb));
		    }
		});
		txtInput.setBounds(116, 18, 606, 59);
		
		Button btnFormatAll = new Button(container, SWT.NONE);
		btnFormatAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFormatAll.setBounds(728, 18, 75, 59);
		btnFormatAll.setText("Format All");
		
		/************************* Get Number Button ****************************/
		Button btnGetNumber = new Button(container, SWT.NONE);
		btnGetNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		btnGetNumber.addSelectionListener(new SelectionAdapter() {
			// Click to Get Number button
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Call method get number list from Basic Format class
				txtNumberResult.setText(format.getNumberList(txtInput.getText()));
			}
		});
		btnGetNumber.setBounds(10, 91, 99, 46);
		btnGetNumber.setText("Get Number");
		
		/************************* Re-Format Button ****************************/
		Button btnReformat = new Button(container, SWT.NONE);
		btnReformat.addSelectionListener(new SelectionAdapter() {
			// Click to Re-Format button
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Call method Re-Format from Basic Format class
				txtNumberResult.setText(format.reformatText(txtInput.getText()));
			}
		});
		btnReformat.setText("Re-Format");
		btnReformat.setBounds(10, 156, 99, 46);
		
		/*************************** Break Button ******************************/
		Button btnBreak = new Button(container, SWT.NONE);
		btnBreak.setText("Break");
		btnBreak.setBounds(10, 221, 99, 46);
		
		
		/**************************** Sort Button ******************************/
		Button btnSort = new Button(container, SWT.NONE);
		btnSort.setText("Sort");
		btnSort.setBounds(10, 340, 99, 46);
		
		/***************************** CaseF Button ****************************/
		Button btnAdvanceFormat = new Button(container, SWT.NONE);
		btnAdvanceFormat.setText("Advance Format");
		btnAdvanceFormat.setBounds(10, 461, 99, 46);
		
		/*************************** Add line Button ***************************/
		Button btnAddLine = new Button(container, SWT.NONE);
		btnAddLine.setText("Add line");
		btnAddLine.setBounds(10, 581, 99, 46);
		
		/********************* Number of Characters Label **********************/
		lblNumberCharacters = new Label(container, SWT.NONE);
		lblNumberCharacters.setBounds(10, 656, 17, 15);
		lblNumberCharacters.setText("0");
		
		Label lblCharacters = new Label(container, SWT.NONE);
		lblCharacters.setBounds(32, 656, 63, 15);
		lblCharacters.setText("Characters");
		
		/*********************** Number of Words Label ************************/
		lblNumberWords = new Label(container, SWT.NONE);
		lblNumberWords.setBounds(10, 677, 17, 15);
		lblNumberWords.setText("0");
		
		Label lblWords = new Label(container, SWT.NONE);
		lblWords.setBounds(33, 677, 55, 15);
		lblWords.setText("Words");
		
		/************************ Text to show results ************************/
		txtNumberResult = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtNumberResult.setBounds(116, 91, 606, 59);
		
		txtReformatResult = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtReformatResult.setBounds(116, 156, 606, 59);
		
		txtBreakResult = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtBreakResult.setBounds(116, 221, 606, 113);
		
		txtSortResult = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtSortResult.setBounds(116, 340, 606, 115);
		
		txtCaseFResult = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtCaseFResult.setBounds(116, 461, 606, 114);
		
		txtAddLineResult = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
		txtAddLineResult.setBounds(116, 581, 606, 111);
		
		Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 83, 793, 2);

		return container;
	}

	/**
	 * Create the menu manager.
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");
		return menuManager;
	}

	/**
	 * Create the status line manager.
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		return statusLineManager;
	}

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			GUI window = new GUI();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell.
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("GROUP 02");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(836, 793);
	}
}
