package tp.kafka.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tp.kafka.bdd.SummaryRepository;
import tp.kafka.consumer.Summary;

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
