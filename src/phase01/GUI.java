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

public class GUI extends ApplicationWindow {
	private Text txtInput;
	private Label lblNumberCharacters;
	private BasicFormat format;

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
		Composite container = new Composite(parent, SWT.NONE);
		
		Label lblInput = new Label(container, SWT.NONE);
		lblInput.setBounds(30, 7, 34, 15);
		lblInput.setText("Input");
		
		txtInput = new Text(container, SWT.BORDER);
		
		txtInput.setBounds(101, 4, 395, 25);
		
		Button btnFormatAll = new Button(container, SWT.NONE);
		btnFormatAll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFormatAll.setBounds(502, 2, 75, 25);
		btnFormatAll.setText("Format All");
		
		Button btnGetNumber = new Button(container, SWT.NONE);
		btnGetNumber.setBounds(10, 40, 85, 25);
		btnGetNumber.setText("Get Number");
		
		Button btnRemoveHTML = new Button(container, SWT.NONE);
		btnRemoveHTML.setText("Remove HTML");
		btnRemoveHTML.setBounds(10, 80, 85, 25);
		
		Button btnReformat = new Button(container, SWT.NONE);
		btnReformat.setText("Re-Format");
		btnReformat.setBounds(10, 124, 85, 25);
		
		Button btnBreak = new Button(container, SWT.NONE);
		btnBreak.setText("Break");
		btnBreak.setBounds(10, 170, 85, 25);
		
		Button btnSort = new Button(container, SWT.NONE);
		btnSort.setText("Sort");
		btnSort.setBounds(10, 249, 85, 25);
		
		Button btnCaseF = new Button(container, SWT.NONE);
		btnCaseF.setText("CaseF");
		btnCaseF.setBounds(10, 330, 85, 25);
		
		Button btnAddLine = new Button(container, SWT.NONE);
		btnAddLine.setText("Add line");
		btnAddLine.setBounds(10, 414, 85, 25);
		
		Label lblNumberCharacters = new Label(container, SWT.NONE);
		lblNumberCharacters.setBounds(10, 489, 17, 15);
		lblNumberCharacters.setText("0");
		
		Label lblCharacters = new Label(container, SWT.NONE);
		lblCharacters.setBounds(30, 489, 63, 15);
		lblCharacters.setText("Characters");
		
		Label lblNumberWords = new Label(container, SWT.NONE);
		lblNumberWords.setBounds(104, 489, 17, 15);
		lblNumberWords.setText("0");
		
		Label lblWords = new Label(container, SWT.NONE);
		lblWords.setBounds(127, 489, 55, 15);
		lblWords.setText("Words");
		
		List listBreakLines = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listBreakLines.setBounds(101, 170, 395, 68);
		
		List listSort = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listSort.setBounds(101, 249, 395, 68);
		
		List listCaseF = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listCaseF.setBounds(101, 330, 395, 68);
		
		List listLineNumber = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listLineNumber.setBounds(101, 415, 395, 68);
		
		List listNumbers = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listNumbers.setBounds(101, 40, 395, 25);
		
		List listNonHTML = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listNonHTML.setBounds(101, 80, 395, 25);
		
		List listReformat = new List(container, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		listReformat.setBounds(101, 124, 395, 25);

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
		return new Point(605, 600);
	}
}
