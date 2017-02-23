package adcampaign.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="ad_campaign_details")
public class AdCompaignEntity {
	
	@Id
	@Column(name = "partner_id", nullable = false)
	private String partner_id;

	@Column(name = "duration", nullable = false)
	private int duration;

	@Column(name = "ad_ontent", nullable = false)
	private String ad_ontent;
	
	@Column(name = "creation_time", nullable = false)
	private Date adCreationTime;

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

	public Date getAdCreationTime() {
		return adCreationTime;
	}

	public void setAdCreationTime(Date adCreationTime) {
		this.adCreationTime = adCreationTime;
	}
	
	


}
