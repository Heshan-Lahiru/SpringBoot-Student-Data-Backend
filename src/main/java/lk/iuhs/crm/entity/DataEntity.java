package lk.iuhs.crm.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "datatable")
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private  String profile_image;
    private  String name;
    private  String age;
    private  String contact;
    private  String guardian_name;
    private  String guardian_address;
    private  String guardian_contact;
}
