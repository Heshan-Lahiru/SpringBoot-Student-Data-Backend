package lk.iuhs.crm.controller;


import lk.iuhs.crm.exception.StudentException;
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
        String stdimage = dataModel.getProfile_image();
        String stdname = dataModel.getName();
        String stdage = dataModel.getAge();
        String stdcontact = dataModel.getContact();
        String atdgurdianname = dataModel.getGuardian_name();
        String stdguardianaddress = dataModel.getGuardian_address();
        String stdguardiancontact = dataModel.getGuardian_contact();


        if(stdimage.equalsIgnoreCase("") ||
                stdname.equalsIgnoreCase("") ||
                stdage.equalsIgnoreCase("") ||
                stdcontact.equalsIgnoreCase("") ||
                atdgurdianname.equalsIgnoreCase("") ||
                stdguardianaddress.equalsIgnoreCase("") ||
                stdguardiancontact.equalsIgnoreCase(""))
        {
            throw new StudentException("Null value");
        }

            return dataService.postdata(dataModel);
    }

    @GetMapping("/postdata")
    public List<DataModel> getdata(){
        List<DataModel> getdata = dataService.getdata();

        if(getdata.isEmpty()){
            throw  new StudentException("null data");
        }
        return getdata;
    }



    @DeleteMapping("/postdata/{id}")
    public void deletedata(@PathVariable Integer id){
         dataService.deletedata(id);
    }

    @PutMapping("/postdata/{id}")
    public void updatedata(@PathVariable Integer id ,@RequestBody DataModel dataModel){

        String stdimage = dataModel.getProfile_image();
        String stdname = dataModel.getName();
        String stdage = dataModel.getAge();
        String stdcontact = dataModel.getContact();
        String atdgurdianname = dataModel.getGuardian_name();
        String stdguardianaddress = dataModel.getGuardian_address();
        String stdguardiancontact = dataModel.getGuardian_contact();

        if(stdimage.equalsIgnoreCase("") ||
                stdname.equalsIgnoreCase("") ||
                stdage.equalsIgnoreCase("") ||
                stdcontact.equalsIgnoreCase("") ||
                atdgurdianname.equalsIgnoreCase("") ||
                stdguardianaddress.equalsIgnoreCase("") ||
                stdguardiancontact.equalsIgnoreCase(""))
        {
            throw new StudentException("Null value");
        }

         dataService.updatedata(id,dataModel);

    }

}
