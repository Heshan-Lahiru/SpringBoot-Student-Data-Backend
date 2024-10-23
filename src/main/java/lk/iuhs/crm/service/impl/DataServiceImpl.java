package lk.iuhs.crm.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lk.iuhs.crm.entity.DataEntity;
import lk.iuhs.crm.model.DataModel;
import lk.iuhs.crm.repository.DataRepository;
import lk.iuhs.crm.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DataServiceImpl implements DataService {

   @Autowired
    DataRepository dataRepository;

   @Autowired
    ObjectMapper objectMapper;

    @Override
    public DataModel postdata(DataModel dataModel) {
        DataEntity dataEntity = objectMapper.convertValue(dataModel, DataEntity.class);
        dataRepository.save(dataEntity);
         return objectMapper.convertValue(dataEntity,DataModel.class);
    }

    @Override
    public List<DataModel> getdata() {
        Iterable<DataEntity> all = dataRepository.findAll();
        List<DataModel> datalist = new ArrayList<>();
        all.forEach(dataEntity -> {
            datalist.add(objectMapper.convertValue(dataEntity,DataModel.class));
        });
        return datalist;

    }

    @Override
    public void deletedata(Integer id) {
        Optional<DataEntity> byId = dataRepository.findById(id);
        dataRepository.delete(byId.get());

    }

    @Override
    public void updatedata(Integer id, DataModel dataModel) {
        Optional<DataEntity> byId = dataRepository.findById(id);
        DataEntity dataEntity = byId.get();

        dataEntity.setProfile_image(dataModel.getName());
        dataEntity.setName(dataModel.getName());
        dataEntity.setAge(dataModel.getAge());
        dataEntity.setContact(dataModel.getContact());
        dataEntity.setGuardian_name(dataModel.getGuardian_name());
        dataEntity.setGuardian_address(dataModel.getGuardian_address());
        dataEntity.setGuardian_contact(dataModel.getGuardian_contact());

         dataRepository.save(dataEntity);
    }

}
