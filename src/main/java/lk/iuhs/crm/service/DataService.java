package lk.iuhs.crm.service;

import lk.iuhs.crm.model.DataModel;

import java.util.List;

public interface DataService {
    DataModel postdata(DataModel dataModel);

    List<DataModel> getdata();

    void deletedata(Integer id);

    void updatedata(Integer id, DataModel dataModel);
}
