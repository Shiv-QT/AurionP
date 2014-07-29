package com;

import net.sf.sahi.client.Browser;
import net.sf.sahi.client.ElementStub;
import net.sf.sahi.client.ExecutionException;
import net.sf.sahi.config.Configuration;

public class ElementOperations {
	
	private Browser browser = new Browser();
	
	//###################################Keywords Starts##############################
	

	/**
	 * Returns true if the element exists on the browser
	 * Retries a few times if the return value is false. This can be controlled with script.max_reattempts_on_error in sahi.properties. 
	 * Use exists(el, true) to return in a single try.
	 * 
	 * @param elementStub
	 * @return
	 * @author Sushma Karanth
	 */
	
	public boolean verifyElementExists(ElementStub element) {
		return browser.exists(element, false);
	}

	
	//###################################Keywords Ends##############################

	
	//###################################Keywords Starts##############################
	
	/**
	 * Returns true if the element is visible on the browser<br/>
	 * Retries a few times if optimistic is false. Retry count can be controlled with script.max_reattempts_on_error in sahi.properties.<br/> 
	 * @param element
	 * @param optimistic boolean. If true returns in a single try. If false, retries a few times. 
	 * @return
	 * @author Sushma Karanth
	 */
	public boolean isVisible(ElementStub element, boolean optimistic) throws ExecutionException {
		if (optimistic)
			return browser.isVisible(element);
		else {
			for (int i=0; i<Configuration.getMaxReAttemptsOnError(); i++){
				if (browser.isVisible(element)) 
					return true;
			}
			return false;
		}
	}
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Navigates to the given URL
	 * 
	 * @param url
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public void navigateToUrl(String url) throws ExecutionException
	{
		try{
			browser.navigateTo(url);
		}catch(Exception e)
		{
			throw new ExecutionException("Could not navigate to the specified URL");
		}
		
	}
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Sets the value in a form element
	 * 
	 * @param element
	 * @param value
	 * @author Sushma Karanth
	 * @throws ExecutionException 
	 */
	
	public void setTextBoxValue(ElementStub element, String value) throws ExecutionException 
	{
			if(!verifyElementExists(element))
			{
				throw new ExecutionException("The text box'" + element
						+ "' is not displayed. '");
			}
			try {
				browser.setValue(element, value);
			} catch (Exception e) {
				throw new ExecutionException("The text '" + value
						+ "' could not be entered in the textbox '" + element
						+ "'.");
			}
	}
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Fetches the string value of an element stub by performing an eval on the browser
	 * 
	 * @param element
	 * @return
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public String fetch(ElementStub element) throws ExecutionException
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The string'" + element
					+ "' is not displayed. '");
		}
		try {	
		return browser.fetch(element.toString());
		} catch (Exception e) {
			throw new ExecutionException("The string'" + element
					+ "' could not be evaluated. '");
		}
	}

	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Returns the inner text of given element from the browser
	 * 
	 * @param element
	 * @return
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public String getText(ElementStub element) throws ExecutionException 
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The text'" + element
					+ "' is not displayed. '");
		}
		try {	
		return browser.getText(element);
		} catch (Exception e) {
			throw new ExecutionException("The text'" + element
					+ "' could not be evaluated. '");
		}
	}

	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Returns the value of given form element from the browser
	 * 
	 * @param element
	 * @return
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */	
	public String getValue(ElementStub element) throws ExecutionException
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The value'" + element
					+ "' is not displayed. '");
		}
		try {
		return browser.fetch(element);
		} catch (Exception e) {
			throw new ExecutionException("The value'" + element
					+ "' could not be evaluated. '");
		}
	}
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Simulates a mouse over on the given element
	 * 
	 * @param link
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public void mouseOverElement(ElementStub element) throws ExecutionException
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The element'" + element
					+ "' is not displayed. '");
		}
		try {
		browser.mouseOver(element);	
		} catch (Exception e) {
			throw new ExecutionException("The element'" + element
					+ "' is not known to the automation suite. '");
		}
	}

	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Checks the given checkbox or radio only if it is unchecked. 
	 * 
	 * @param element
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public void checkValue(ElementStub element) throws ExecutionException
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The checkbox'" + element
					+ "' is not displayed. '");
		}
		try {
		browser.check(element);	
		}catch (Exception e) {
			throw new ExecutionException("The checkbox value'" + element
					+ "' could not be checked '");
		}
	}	

	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Unchecks the given checkbox only if it is checked. 
	 * 
	 * @param element
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public void uncheckValue(ElementStub element) throws ExecutionException 
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The checkbox'" + element
					+ "' is not displayed. '");
		}
		try {
		browser.uncheck(element);	
		}catch (Exception e) {
			throw new ExecutionException("The checkbox value'" + element
					+ "' could not be unchecked '");
		}
	}	
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Double clicks the given element
	 * 
	 * @param element
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public void dbClickElement(ElementStub element) throws ExecutionException 
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The element'" + element
					+ "' is not displayed to double click. '");
		}
		try {
		browser.doubleClick(element);
		}catch (Exception e) {
			throw new ExecutionException("The element'" + element
					+ "' could not be double clicked. '");
		}
	}
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Clicks the given element
	 * 
	 * @param element
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public void clickElement(ElementStub element) throws ExecutionException
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The element'" + element
					+ "' is not displayed to click. '");
		}
		try {
		browser.click(element);	
		}catch (Exception e) {
			throw new ExecutionException("The element'" + element
					+ "' could not be clicked. '");
		}
	}
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Chooses the given option in a select box (&lt;select&gt; tag).
	 * 
	 * @param selectElement
	 * @param value
	 * @param append: if true, option is selected without unselecting previous option in multi-select box
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */
	public void setListBox(ElementStub element, String value, boolean append) throws ExecutionException 
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The list box'" + element
					+ "' is not displayed. '");
		}
		try {
		browser.choose(element, value, append);
		}catch (Exception e) {
			throw new ExecutionException("The value'" + element
					+ "' could not be selected from the listbox. '");
		}
	}
	
	//###################################Keywords Ends##############################
	
	//###################################Keywords Starts##############################
	
	/**
	 * Returns true if the element is checked. Is meaningful only for radio buttons and checkboxes<br/>
	 * 
	 * @param element
	 * @return
	 * @throws ExecutionException
	 * @author Sushma Karanth
	 */	
	
	public boolean isChecked(ElementStub element) throws ExecutionException
	{
		if(!verifyElementExists(element))
		{
			throw new ExecutionException("The checkbox'" + element
					+ "' is not displayed. '");
		}
		try {
		return browser.checked(element);
		}catch (Exception e) {
			throw new ExecutionException("The status of the checkbox could not be checked. '");
		}

	}
	
	
	//###################################Keywords Ends##############################
	
}