package adcampaign.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import adcampaign.entity.AdCompaignEntity;

@Repository
@Transactional
public interface AdCampaignDAO  extends CrudRepository<AdCompaignEntity, String>{
	
	

}
