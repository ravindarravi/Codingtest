package adcampaign.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import adcampaign.dao.AdCampaignDAO;
import adcampaign.entity.AdCompaignEntity;
import adcampaign.model.AdCompaignModel;

@Service
public class AdCampignService {

	@Autowired
	public AdCampaignDAO adCampaignDAO;

	public void createAdCampign(AdCompaignModel adCampaignModel) throws Exception {


		if (partnerisExists(adCampaignModel)) {

			throw new HttpClientErrorException(HttpStatus.CONFLICT, "Partner is Exists in the System");
		}
		AdCompaignEntity adCampaign = new AdCompaignEntity();
		adCampaign.setPartner_id(adCampaignModel.getPartner_id());
		adCampaign.setDuration(adCampaignModel.getDuration());
		adCampaign.setAd_ontent(adCampaignModel.getAd_ontent());
		adCampaign.setAdCreationTime(Calendar.getInstance().getTime());
		adCampaignDAO.save(adCampaign);

	}

	public AdCompaignModel findPartnerDetails(String partnerId) throws Exception {

		AdCompaignModel adCampaignModel = null;
		AdCompaignEntity adCampaign = adCampaignDAO.findOne(partnerId);
		if (adCampaign!= null) {
			adCampaignModel = new AdCompaignModel();
			adCampaignModel.setPartner_id(adCampaign.getPartner_id());
			adCampaignModel.setDuration(adCampaign.getDuration());
			adCampaignModel.setAd_ontent(adCampaign.getAd_ontent());
			getAdStatus(adCampaign, adCampaignModel);
		}
		else{
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Partner is Not Found");
		}

		return adCampaignModel;

	}

	private boolean partnerisExists(AdCompaignModel adCampaignModel) {

		boolean isPartnerExists = false;
		AdCompaignEntity adCampaign = adCampaignDAO.findOne(adCampaignModel.getPartner_id());
		if (adCampaign != null) {
			if (adCampaignModel.getPartner_id().trim().equalsIgnoreCase(adCampaign.getPartner_id().trim())) {
				isPartnerExists = true;
			}
		}
		return isPartnerExists;
	}

	private void getAdStatus(AdCompaignEntity adCampaign, AdCompaignModel adCampaignModel) {
		Calendar cl = Calendar.getInstance();
		Date creationDate = adCampaign.getAdCreationTime();
		cl.setTime(creationDate);
		cl.add(Calendar.SECOND, adCampaign.getDuration());
		Date updatedTime = cl.getTime();
		Date presentTie = Calendar.getInstance().getTime();
		if (presentTie.after(updatedTime)) {
			adCampaignModel.setAdStatus("Ad Expired");
		} else {
			adCampaignModel.setAdStatus("Ad Active");
		}
	}

}
