package phase01;

import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

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
		setStatus("");
		parent.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_LIGHT_SHADOW));
		Composite container = new Composite(parent, SWT.MAX);
		container.setEnabled(true);
		container.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		container.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setFont(SWTResourceManager.getFont("Segoe UI Semibold", 13, SWT.NORMAL));
		container.setBounds(0, 0, 0, 0);
		container.setLayout(null);
		txtInput = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		txtInput.setBounds(116, 10, 549, 232);
		txtInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.stateMask == SWT.CTRL && e.keyCode == 'a') {
					txtInput.selectAll();
		            e.doit = false;
		        }
			}
		});
		// modifyText Event of txtInput
		txtInput.addModifyListener(new ModifyListener() {
			@Override
		    public void modifyText(ModifyEvent e) {
		    	int dumb = rt.countCharacters(txtInput.getText());
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
		btnFormatAll.setBounds(10, 94, 100, 40);
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
				
				// Click to format button
				txtReformatResult.setText(rt.printArrayString(rt.reformatText(rt.splitStringByNewLine(txtInput.getText()))));
				
				// Click to Re-Format button
				txtReformatResult.setText(rt.printArrayString(rt.reformatText(rt.splitStringByNewLine(txtInput.getText()))));

				// Click to break button
				txtBreakResult.setText(rt.printArrayString(rt.breakLines(rt.splitStringByNewLine(txtInput.getText()))));
				
				// Click to sort button
				txtSortResult.setText(rt.printArrayString(rt.sortText(rt.splitStringByNewLine(txtInput.getText()))));
				
				// Click to advance format button
				txtCaseFResult.setText(rt.printArrayString(rt.advanceFormatText(rt.splitStringByNewLine(txtInput.getText()))));
				
				// Click to add line button
				txtAddLineResult.setText(rt.printArrayString(rt.addLine(rt.splitStringByNewLine(txtInput.getText()))));
			}
		});
		btnFormatAll.setText("Format All");
		btnFormatAll.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/************************* Get Number Button ****************************/
		Button btnGetNumber = new Button(container, SWT.NONE);
		btnGetNumber.setBounds(690, 718, 99, 40);
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
		btnGetNumber.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/************************* Format Button ****************************/
		Button btnReformat = new Button(container, SWT.NONE);
		btnReformat.setBounds(11, 248, 99, 45);
		btnReformat.addSelectionListener(new SelectionAdapter() {
			// Click to Re-Format button
			@Override
			public void widgetSelected(SelectionEvent e) {
				// Call method Re-Format from Formatting class
				txtReformatResult.setText(rt.printArrayString(rt.reformatText(rt.splitStringByNewLine(txtInput.getText()))));
			}
		});
		btnReformat.setText("Format");
		btnReformat.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/*************************** Break Button ******************************/
		Button btnBreak = new Button(container, SWT.NONE);
		btnBreak.setBounds(690, 8, 99, 45);
		btnBreak.addSelectionListener(new SelectionAdapter() {
			// Click to break button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtBreakResult.setText(rt.printArrayString(rt.breakLines(rt.splitStringByNewLine(txtInput.getText()))));
			}
		});
		btnBreak.setText("Break");
		btnBreak.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/**************************** Sort Button ******************************/
		Button btnSort = new Button(container, SWT.NONE);
		btnSort.setBounds(690, 248, 99, 45);
		btnSort.addSelectionListener(new SelectionAdapter() {
			// Click to sort button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtSortResult.setText(rt.printArrayString(rt.sortText(rt.splitStringByNewLine(txtInput.getText()))));
			}
		});
		btnSort.setText("Sort");
		btnSort.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/***************************** CaseF Button ****************************/
		Button btnAdvanceFormat = new Button(container, SWT.NONE);
		btnAdvanceFormat.setBounds(10, 491, 100, 45);
		btnAdvanceFormat.addSelectionListener(new SelectionAdapter() {
			// Click to advance format text button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtCaseFResult.setText(rt.printArrayString(rt.advanceFormatText(rt.splitStringByNewLine(txtInput.getText()))));
			}
		});
		btnAdvanceFormat.setText("Advance Format");
		btnAdvanceFormat.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/*************************** Add line Button ***************************/
		Button btnAddLine = new Button(container, SWT.NONE);
		btnAddLine.setBounds(689, 491, 100, 45);
		btnAddLine.addSelectionListener(new SelectionAdapter() {
			// Click to add line button
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtAddLineResult.setText(rt.printArrayString(rt.addLine(rt.splitStringByNewLine(txtInput.getText()))));
			}
		});
		btnAddLine.setText("Add line");
		btnAddLine.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/*********************** Clear Button ************************/
		Button btnClear = new Button(container, SWT.NONE);
		btnClear.setBounds(10, 48, 100, 40);
		btnClear.setForeground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		btnClear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				txtInput.setText("");
				txtAddLineResult.setText("");
				txtBreakResult.setText("");
				txtCaseFResult.setText("");
				txtNumberResult.setText("");
				txtReformatResult.setText("");
				txtSortResult.setText("");
			}
		});
		btnClear.setText("Clear");
		btnClear.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/****************************** Input Label ************************************/
		Label lblInput = new Label(container, SWT.WRAP | SWT.SHADOW_IN | SWT.CENTER);
		lblInput.setBounds(10, 21, 100, 17);
		lblInput.setAlignment(SWT.CENTER);
		lblInput.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblInput.setText("User Input");
		
		/********************* Number of Characters Label **********************/
		lblNumberCharacters = new Label(container, SWT.NONE);
		lblNumberCharacters.setBounds(10, 710, 33, 15);
		lblNumberCharacters.setText("0");
		lblNumberCharacters.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		lblCharacters = new Label(container, SWT.NONE);
		lblCharacters.setBounds(43, 710, 63, 15);
		lblCharacters.setText("Characters");
		lblCharacters.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/*********************** Number of Words Label ************************/
		lblNumberWords = new Label(container, SWT.NONE);
		lblNumberWords.setBounds(10, 731, 33, 15);
		lblNumberWords.setText("0");
		lblNumberWords.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		lblWords = new Label(container, SWT.NONE);
		lblWords.setBounds(43, 731, 42, 15);
		lblWords.setText("Words");
		lblWords.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/************************ Text to show results ************************/
		txtNumberResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtNumberResult.setBounds(795, 718, 494, 40);
		txtNumberResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtReformatResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtReformatResult.setBounds(116, 248, 549, 237);
		txtReformatResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtBreakResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtBreakResult.setBounds(795, 10, 494, 233);
		txtBreakResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtSortResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtSortResult.setBounds(795, 248, 494, 237);
		txtSortResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtCaseFResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtCaseFResult.setBounds(116, 491, 549, 267);
		txtCaseFResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtAddLineResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		txtAddLineResult.setBounds(795, 491, 494, 221);
		txtAddLineResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));

		return container;
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
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText("GROUP 02 - FORMAT TEXT");
		shell.setFont(new Font(shell.getDisplay(), "Arial", 15, 0));
		final Image small = new Image(shell.getDisplay(), "images/icon.png");
		final Image[] images = new Image[] { small };
		shell.setImages(images);
	}
}
