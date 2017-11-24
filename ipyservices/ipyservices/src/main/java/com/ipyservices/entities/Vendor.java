package com.ipyservices.entities;

import java.util.List;

/*import com.ipyservices.helper.FunctionalHelper;
import com.ipyservices.helper.interfaces.IFunctionalHelper;*/

public class Vendor {
	
	//IFunctionalHelper _helper = new FunctionalHelper();
	
	public int Id;
	public String Message;
	public List<Offering> Offerings;
	public String Specials;
	public String Yelp;
	public String Google;
	public String Facebook;
	/*public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	public List<Offering> getOfferings() {
		return Offerings;
	}
	public void setOfferings(List<Offering> offerings) {
		Offerings = offerings;
	}
	public String getSpecials() {
		return Specials;
	}
	public void setSpecials(String specials) {
		Specials = specials;
	}
	public String getYelp() {
		return Yelp;
	}
	public void setYelp(String yelp) {
		if(_helper.IsWebsite(yelp))
			Yelp = yelp;
	}
	public String getGoogle() {
		return Google;
	}
	public void setGoogle(String google) {
		if(_helper.IsWebsite(google))
			Google = google;
	}
	public String getFacebook() {
		return Facebook;
	}
	public void setFacebook(String facebook) {
		if(_helper.IsWebsite(facebook))
			Facebook = facebook;
	}
	*/
}
