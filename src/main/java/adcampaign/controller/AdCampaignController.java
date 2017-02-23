package adcampaign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import adcampaign.model.AdCompaignModel;
import adcampaign.services.AdCampignService;

@RestController
public class AdCampaignController {

	@Autowired
	public AdCampignService adCampaignService;

	@RequestMapping(value = "/ad/createcampaign", method = RequestMethod.POST, headers = "Accept=application/json")
	public void createAdCampaign(@RequestBody AdCompaignModel adCampaign) throws Exception {
		adCampaignService.createAdCampign(adCampaign);
	}

	@RequestMapping(value = "/ad/{partner_id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public AdCompaignModel findPartnerDetails(@PathVariable("partner_id") String partner_id) throws Exception {
		return adCampaignService.findPartnerDetails(partner_id);
	}

}
