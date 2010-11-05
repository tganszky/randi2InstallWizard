package tab;

import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.paneltabset.TabChangeListener;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;

import java.io.Serializable;

/**
 * The StaticTabSetBean class is a backing bean for the TabbedPane showcase
 * demonstration and is used to store the various states of the the
 * ice:panelTabSet component. These states are visibility, tab selection and tab
 * placement.
 * 
 * @since 0.3.0
 */
public class StaticTabSetBean implements TabChangeListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The demo contains three tabs and thus we need three variables to store
	 * their respective rendered states.
	 */
	private boolean tabbedPane1Visible;
	private boolean tabbedPane2Visible;
	private boolean tabbedPane3Visible;

	// selected tab index
	private String nextIndex = "1";
	private String selectedIndex = "0";
	
	/**
	 * Tabbed placement, possible values are "top" and "bottom", the default is
	 * "bottom".
	 */
	private String tabPlacement = "top";

	public boolean isTabbedPane1Visible() {
		return tabbedPane1Visible;
	}

	public void setTabbedPane1Visible(boolean tabbedPane1Visible) {
		this.tabbedPane1Visible = tabbedPane1Visible;
	}

	public boolean isTabbedPane2Visible() {
		return tabbedPane2Visible;
	}

	public void setTabbedPane2Visible(boolean tabbedPane2Visible) {
		this.tabbedPane2Visible = tabbedPane2Visible;
	}

	public boolean isTabbedPane3Visible() {
		return tabbedPane3Visible;
	}

	public void setTabbedPane3Visible(boolean tabbedPane3Visible) {
		this.tabbedPane3Visible = tabbedPane3Visible;
	}

	public String getTabPlacement() {
		return tabPlacement;
	}

	public void setTabPlacement(String tabPlacement) {
		this.tabPlacement = tabPlacement;
	}

	public String getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
		this.nextIndex = Integer
				.toString((Integer.parseInt(selectedIndex)) + 1);
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = String.valueOf(selectedIndex);
		this.nextIndex = Integer.toString(selectedIndex + 1);
	}

	public int getNextInt() {
		return getFocusIndex() + 1;
	}

	public String getNextString() {
		return Integer.toString(getFocusIndex() + 1);
	}

	public int getFocusIndex() {
		int focusIndex = 0;
		try {
			focusIndex = Integer.parseInt(selectedIndex);
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		return focusIndex;
	}

	public void setFocusIndex(int index) {
		selectedIndex = String.valueOf(index);
	}

	public void setFocusIndex() {
		selectedIndex = getNextString();
	}

	/**
	 * Called when the table binding's tab focus changes.
	 * 
	 * @param tabChangeEvent
	 *            used to set the tab focus.
	 * @throws AbortProcessingException
	 *             An exception that may be thrown by event listeners to
	 *             terminate the processing of the current event.
	 */
	public void processTabChange(TabChangeEvent tabChangeEvent)
			throws AbortProcessingException {
		// only used to show TabChangeListener usage.
	}

	public void switchGroup(ActionEvent e) {
		System.out.println("this works");
		selectedIndex = "1";
		System.out.println(getNextIndex());
	}
	
	public String getNextIndex(){
		return nextIndex;
	}
}