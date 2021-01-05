package intergiciel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import intergiciel.bdd.SummaryRepository;
import intergiciel.consumer.Summary;

@Service
public class SummaryServiceImpl implements SummaryService{
	
	@Autowired
	SummaryRepository summaryRepository;
	
	@Transactional
	public Summary createSummary(Summary s)
	{
		System.out.println("g");
		if (s != null)
		{
			System.out.println("g");
			return summaryRepository.save(s);
		}
		return null;
		
	}

}
