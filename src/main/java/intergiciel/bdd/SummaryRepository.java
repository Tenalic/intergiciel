package intergiciel.bdd;

import org.springframework.data.repository.CrudRepository;

import intergiciel.consumer.Summary;

public interface SummaryRepository extends CrudRepository<Summary, Integer>, SummaryRepositoryCustom{

}
