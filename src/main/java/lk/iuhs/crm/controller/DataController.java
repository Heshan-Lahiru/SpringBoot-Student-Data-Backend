package lk.iuhs.crm.controller;


import lk.iuhs.crm.model.DataModel;
import lk.iuhs.crm.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DataController {

    @Autowired
    DataService dataService;

    @PostMapping("/postdata")
    public DataModel postdata(@RequestBody DataModel dataModel){
        return dataService.postdata(dataModel);
    }

    @GetMapping("/postdata")
    public List<DataModel> getdata(){
        return dataService.getdata();
    }

    @DeleteMapping("/postdata/{id}")
    public void deletedata(@PathVariable Integer id){
         dataService.deletedata(id);
    }

    @PutMapping("/postdata/{id}")
    public void updatedata(@PathVariable Integer id ,@RequestBody DataModel dataModel){
         dataService.updatedata(id,dataModel);
    }

}
