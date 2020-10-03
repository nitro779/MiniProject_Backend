package basicauth.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basicauth.demo.models.CardDetails;

@Repository
public interface CardDetailsRepository extends JpaRepository<CardDetails, Integer>{
	
	public CardDetails findCardDetailsBycardnumber(long cardnumber);
}
