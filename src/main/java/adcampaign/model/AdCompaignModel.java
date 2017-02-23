package adcampaign.model;

public class AdCompaignModel {

	private String partner_id;

	private int duration;

	private String ad_ontent;
	
	
	private String  adStatus;


	public String getPartner_id() {
		return partner_id;
	}

	public void setPartner_id(String partner_id) {
		this.partner_id = partner_id;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getAd_ontent() {
		return ad_ontent;
	}

	public void setAd_ontent(String ad_ontent) {
		this.ad_ontent = ad_ontent;
	}


	public String getAdStatus() {
		return adStatus;
	}

	public void setAdStatus(String adStatus) {
		this.adStatus = adStatus;
	}

}
