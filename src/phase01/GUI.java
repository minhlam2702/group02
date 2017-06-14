package phase01;

import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class GUI extends ApplicationWindow {
	private Text txtInput;
	private Label lblCharacters;
	private Label lblNumberCharacters;
	private Label lblWords;
	private Label lblNumberWords;
	private Text txtNumberResult;
	private Text txtReformatResult;
	private Text txtBreakResult;
	private Text txtSortResult;
	private Text txtCaseFResult;
	private Text txtAddLineResult;
	private RichText rt = new RichText();
	private Number number = new Number();

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
		parent.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		Composite container = new Composite(parent, SWT.NONE);
		container.setEnabled(true);
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 12, SWT.NORMAL));
		container.setLayout(null);

		
		/****************************** Input Textbox ************************************/
		Label lblInput = new Label(container, SWT.WRAP | SWT.SHADOW_IN | SWT.CENTER);
		lblInput.setBounds(10, 18, 100, 46);
		lblInput.setAlignment(SWT.CENTER);
		lblInput.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblInput.setText("User Input");
		
		txtInput = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtInput.setBounds(116, 18, 606, 46);
		// modifyText Event of txtInput
		txtInput.addModifyListener(new ModifyListener() {
			@Override
		    public void modifyText(ModifyEvent e) {
		    	int dumb = txtInput.getText().length();
		    	// Set current number of characters into lblNumberCharacters 
		    	lblNumberCharacters.setText(Integer.toString(dumb));
		    	if (dumb == 1) {
		    		lblCharacters.setText("Character");
		    	} else {
		    		lblCharacters.setText("Characters");
		    	}
		    	// Set current number of words into lblNumberWords
		    	lblNumberWords.setText(Integer.toString(rt.countWords(txtInput.getText())));
		    	if (rt.countWords(txtInput.getText()) == 1) {
		    		lblWords.setText("Word");
		    	} else {
		    		lblWords.setText("Words");
		    	}
		    	
		    }
		});
		
		/************************* Format All Button ****************************/
		Button btnFormatAll = new Button(container, SWT.NONE);
		btnFormatAll.setBounds(728, 18, 75, 46);
		btnFormatAll.addSelectionListener(new SelectionAdapter() {
			// Click to format all button
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Click to get number button
				try {
					txtNumberResult.setText(number.printArrayNumber(number.getArrayNumber(txtInput.getText())));
				} catch (Exception ex){
					txtNumberResult.setText("");
				}
				
				// Click to Re-Format button
				txtReformatResult.setText(rt.reformatText(txtInput.getText()));

				// Click to break button
				txtBreakResult.setText(rt.printArrayString(rt.breakLines(txtInput.getText())));
				
				// Click to sort button
				txtSortResult.setText(rt.printArrayString(rt.sortText(txtInput.getText())));
				
				// Click to CaseF button
				txtCaseFResult.setText(rt.printArrayString(rt.advanceFormatText(txtInput.getText())));
				
				// Click to add line button
				txtAddLineResult.setText(rt.printArrayString(rt.addLine(txtInput.getText())));
			}
		});
		btnFormatAll.setText("Format All");
		
		/************************* Get Number Button ****************************/
		Button btnGetNumber = new Button(container, SWT.NONE);
		btnGetNumber.setBounds(10, 91, 99, 46);
		btnGetNumber.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		btnGetNumber.addSelectionListener(new SelectionAdapter() {
			// Click to Get Number button
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Call method get number list from Formatting class
				try {
					txtNumberResult.setText(number.printArrayNumber(number.getArrayNumber(txtInput.getText())));
				} catch (Exception ex){
					txtNumberResult.setText("");
				}
			}
		});
		btnGetNumber.setText("Get Number");
		
		/************************* Re-Format Button ****************************/
		Button btnReformat = new Button(container, SWT.NONE);
		btnReformat.setBounds(11, 143, 99, 46);
		btnReformat.addSelectionListener(new SelectionAdapter() {
			// Click to Re-Format button
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Call method Re-Format from Formatting class
				txtReformatResult.setText(rt.reformatText(txtInput.getText()));
			}
		});
		btnReformat.setText("Re-Format");
		
		/*************************** Break Button ******************************/
		Button btnBreak = new Button(container, SWT.NONE);
		btnBreak.addSelectionListener(new SelectionAdapter() {
			// Click to break button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtBreakResult.setText(rt.printArrayString(rt.breakLines(txtInput.getText())));
			}
		});
		btnBreak.setBounds(11, 195, 99, 46);
		btnBreak.setText("Break");
		
		
		/**************************** Sort Button ******************************/
		Button btnSort = new Button(container, SWT.NONE);
		btnSort.addSelectionListener(new SelectionAdapter() {
			// Click to sort button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtSortResult.setText(rt.printArrayString(rt.sortText(txtInput.getText())));
			}
		});
		btnSort.setBounds(10, 292, 99, 46);
		btnSort.setText("Sort");
		
		/***************************** CaseF Button ****************************/
		Button btnAdvanceFormat = new Button(container, SWT.NONE);
		btnAdvanceFormat.addSelectionListener(new SelectionAdapter() {
			// Click to advance format text button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtCaseFResult.setText(rt.printArrayString(rt.advanceFormatText(txtInput.getText())));
			}
		});
		btnAdvanceFormat.setBounds(11, 389, 99, 46);
		btnAdvanceFormat.setText("Advance Format");
		
		/*************************** Add line Button ***************************/
		Button btnAddLine = new Button(container, SWT.NONE);
		btnAddLine.addSelectionListener(new SelectionAdapter() {
			// Click to add line button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtAddLineResult.setText(rt.printArrayString(rt.addLine(txtInput.getText())));
			}
		});
		btnAddLine.setBounds(11, 486, 99, 46);
		btnAddLine.setText("Add line");
		
		/********************* Number of Characters Label **********************/
		lblNumberCharacters = new Label(container, SWT.NONE);
		lblNumberCharacters.setBounds(21, 538, 17, 15);
		lblNumberCharacters.setText("0");
		
		lblCharacters = new Label(container, SWT.NONE);
		lblCharacters.setBounds(44, 538, 63, 15);
		lblCharacters.setText("Characters");
		
		/*********************** Number of Words Label ************************/
		lblNumberWords = new Label(container, SWT.NONE);
		lblNumberWords.setBounds(21, 559, 17, 15);
		lblNumberWords.setText("0");
		
		lblWords = new Label(container, SWT.NONE);
		lblWords.setBounds(44, 559, 55, 15);
		lblWords.setText("Words");
		
		/************************ Text to show results ************************/
		txtNumberResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtNumberResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		txtNumberResult.setBounds(116, 91, 606, 46);
		
		txtReformatResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtReformatResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		txtReformatResult.setBounds(116, 143, 606, 46);
		
		txtBreakResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtBreakResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		txtBreakResult.setBounds(116, 195, 606, 91);
		
		txtSortResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtSortResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		txtSortResult.setBounds(116, 292, 606, 91);
		
		txtCaseFResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtCaseFResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		txtCaseFResult.setBounds(116, 389, 606, 91);
		
		txtAddLineResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtAddLineResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		txtAddLineResult.setBounds(116, 486, 606, 91);
		
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
		newShell.setText("GROUP 02 - FORMAT TEXT");
	}

	/**
	 * Return the initial size of the window.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(828, 664);
	}
}
