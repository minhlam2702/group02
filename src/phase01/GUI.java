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
		FormLayout fl_container = new FormLayout();
		container.setLayout(fl_container);
		txtInput = new Text(container, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL | SWT.MULTI);
		FormData fd_txtInput = new FormData();
		fd_txtInput.bottom = new FormAttachment(0, 115);
		fd_txtInput.right = new FormAttachment(0, 907);
		fd_txtInput.top = new FormAttachment(0, 10);
		fd_txtInput.left = new FormAttachment(0, 116);
		txtInput.setLayoutData(fd_txtInput);
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
		FormData fd_btnFormatAll = new FormData();
		fd_btnFormatAll.bottom = new FormAttachment(0, 115);
		fd_btnFormatAll.right = new FormAttachment(0, 111);
		fd_btnFormatAll.top = new FormAttachment(0, 75);
		fd_btnFormatAll.left = new FormAttachment(0, 11);
		btnFormatAll.setLayoutData(fd_btnFormatAll);
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
		FormData fd_btnGetNumber = new FormData();
		fd_btnGetNumber.bottom = new FormAttachment(0, 161);
		fd_btnGetNumber.right = new FormAttachment(0, 111);
		fd_btnGetNumber.top = new FormAttachment(0, 121);
		fd_btnGetNumber.left = new FormAttachment(0, 12);
		btnGetNumber.setLayoutData(fd_btnGetNumber);
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
		FormData fd_btnReformat = new FormData();
		fd_btnReformat.bottom = new FormAttachment(0, 217);
		fd_btnReformat.right = new FormAttachment(0, 110);
		fd_btnReformat.top = new FormAttachment(0, 172);
		fd_btnReformat.left = new FormAttachment(0, 11);
		btnReformat.setLayoutData(fd_btnReformat);
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
		FormData fd_btnBreak = new FormData();
		fd_btnBreak.bottom = new FormAttachment(0, 385);
		fd_btnBreak.right = new FormAttachment(0, 110);
		fd_btnBreak.top = new FormAttachment(0, 340);
		fd_btnBreak.left = new FormAttachment(0, 11);
		btnBreak.setLayoutData(fd_btnBreak);
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
		FormData fd_btnSort = new FormData();
		fd_btnSort.bottom = new FormAttachment(0, 489);
		fd_btnSort.right = new FormAttachment(0, 110);
		fd_btnSort.top = new FormAttachment(0, 444);
		fd_btnSort.left = new FormAttachment(0, 11);
		btnSort.setLayoutData(fd_btnSort);
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
		FormData fd_btnAdvanceFormat = new FormData();
		fd_btnAdvanceFormat.bottom = new FormAttachment(0, 297);
		fd_btnAdvanceFormat.top = new FormAttachment(0, 252);
		fd_btnAdvanceFormat.left = new FormAttachment(0, 11);
		btnAdvanceFormat.setLayoutData(fd_btnAdvanceFormat);
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
		FormData fd_btnAddLine = new FormData();
		fd_btnAddLine.bottom = new FormAttachment(0, 601);
		fd_btnAddLine.right = new FormAttachment(0, 109);
		fd_btnAddLine.top = new FormAttachment(0, 556);
		fd_btnAddLine.left = new FormAttachment(0, 10);
		btnAddLine.setLayoutData(fd_btnAddLine);
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
		FormData fd_btnClear = new FormData();
		fd_btnClear.bottom = new FormAttachment(0, 71);
		fd_btnClear.right = new FormAttachment(0, 111);
		fd_btnClear.top = new FormAttachment(0, 31);
		fd_btnClear.left = new FormAttachment(0, 11);
		btnClear.setLayoutData(fd_btnClear);
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
		FormData fd_lblInput = new FormData();
		fd_lblInput.bottom = new FormAttachment(0, 31);
		fd_lblInput.right = new FormAttachment(0, 109);
		fd_lblInput.top = new FormAttachment(0, 7);
		fd_lblInput.left = new FormAttachment(0, 9);
		lblInput.setLayoutData(fd_lblInput);
		lblInput.setAlignment(SWT.CENTER);
		lblInput.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD));
		lblInput.setText("User Input");
		
		/********************* Number of Characters Label **********************/
		lblNumberCharacters = new Label(container, SWT.NONE);
		FormData fd_lblNumberCharacters = new FormData();
		fd_lblNumberCharacters.right = new FormAttachment(0, 43);
		fd_lblNumberCharacters.top = new FormAttachment(0, 617);
		fd_lblNumberCharacters.left = new FormAttachment(0, 10);
		lblNumberCharacters.setLayoutData(fd_lblNumberCharacters);
		lblNumberCharacters.setText("0");
		lblNumberCharacters.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		lblCharacters = new Label(container, SWT.NONE);
		FormData fd_lblCharacters = new FormData();
		fd_lblCharacters.right = new FormAttachment(0, 106);
		fd_lblCharacters.top = new FormAttachment(0, 617);
		fd_lblCharacters.left = new FormAttachment(0, 43);
		lblCharacters.setLayoutData(fd_lblCharacters);
		lblCharacters.setText("Characters");
		lblCharacters.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/*********************** Number of Words Label ************************/
		lblNumberWords = new Label(container, SWT.NONE);
		FormData fd_lblNumberWords = new FormData();
		fd_lblNumberWords.right = new FormAttachment(0, 43);
		fd_lblNumberWords.top = new FormAttachment(0, 638);
		fd_lblNumberWords.left = new FormAttachment(0, 10);
		lblNumberWords.setLayoutData(fd_lblNumberWords);
		lblNumberWords.setText("0");
		lblNumberWords.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		lblWords = new Label(container, SWT.NONE);
		FormData fd_lblWords = new FormData();
		fd_lblWords.right = new FormAttachment(0, 98);
		fd_lblWords.top = new FormAttachment(0, 638);
		fd_lblWords.left = new FormAttachment(0, 43);
		lblWords.setLayoutData(fd_lblWords);
		lblWords.setText("Words");
		lblWords.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		
		/************************ Text to show results ************************/
		txtNumberResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		FormData fd_txtNumberResult = new FormData();
		fd_txtNumberResult.bottom = new FormAttachment(0, 166);
		fd_txtNumberResult.right = new FormAttachment(0, 907);
		fd_txtNumberResult.top = new FormAttachment(0, 121);
		fd_txtNumberResult.left = new FormAttachment(0, 116);
		txtNumberResult.setLayoutData(fd_txtNumberResult);
		txtNumberResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtReformatResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		FormData fd_txtReformatResult = new FormData();
		fd_txtReformatResult.bottom = new FormAttachment(0, 246);
		fd_txtReformatResult.right = new FormAttachment(0, 907);
		fd_txtReformatResult.top = new FormAttachment(0, 172);
		fd_txtReformatResult.left = new FormAttachment(0, 116);
		txtReformatResult.setLayoutData(fd_txtReformatResult);
		txtReformatResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtBreakResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL | SWT.RIGHT);
		FormData fd_txtBreakResult = new FormData();
		fd_txtBreakResult.bottom = new FormAttachment(0, 440);
		fd_txtBreakResult.right = new FormAttachment(0, 907);
		fd_txtBreakResult.top = new FormAttachment(0, 340);
		fd_txtBreakResult.left = new FormAttachment(0, 116);
		txtBreakResult.setLayoutData(fd_txtBreakResult);
		txtBreakResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtSortResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		FormData fd_txtSortResult = new FormData();
		fd_txtSortResult.bottom = new FormAttachment(0, 550);
		fd_txtSortResult.right = new FormAttachment(0, 907);
		fd_txtSortResult.top = new FormAttachment(0, 445);
		fd_txtSortResult.left = new FormAttachment(0, 116);
		txtSortResult.setLayoutData(fd_txtSortResult);
		txtSortResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtCaseFResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		FormData fd_txtCaseFResult = new FormData();
		fd_txtCaseFResult.bottom = new FormAttachment(0, 334);
		fd_txtCaseFResult.right = new FormAttachment(0, 907);
		fd_txtCaseFResult.top = new FormAttachment(0, 252);
		fd_txtCaseFResult.left = new FormAttachment(0, 116);
		txtCaseFResult.setLayoutData(fd_txtCaseFResult);
		txtCaseFResult.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		
		txtAddLineResult = new Text(container, SWT.BORDER | SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		FormData fd_txtAddLineResult = new FormData();
		fd_txtAddLineResult.bottom = new FormAttachment(0, 661);
		fd_txtAddLineResult.right = new FormAttachment(0, 907);
		fd_txtAddLineResult.top = new FormAttachment(0, 556);
		fd_txtAddLineResult.left = new FormAttachment(0, 116);
		txtAddLineResult.setLayoutData(fd_txtAddLineResult);
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
