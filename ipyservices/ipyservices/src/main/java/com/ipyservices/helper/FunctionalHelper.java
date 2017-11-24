package com.ipyservices.helper;

import com.ipyservices.helper.interfaces.IFunctionalHelper;
import org.apache.commons.validator.routines.UrlValidator;

public class FunctionalHelper implements IFunctionalHelper {

	public boolean IsWebsite(String webAddress) {
		UrlValidator validate = new UrlValidator();
		return validate.isValid(webAddress);	
	}

}
