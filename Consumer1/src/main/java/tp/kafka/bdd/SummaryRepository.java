package tp.kafka.bdd;

import tp.kafka.consumer.*;
import org.springframework.data.repository.CrudRepository;

public interface SummaryRepository extends CrudRepository<Summary, Integer>, SummaryRepositoryCustom{

}
