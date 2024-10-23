package lk.iuhs.crm.repository;

import lk.iuhs.crm.entity.DataEntity;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<DataEntity,Integer> {
}
