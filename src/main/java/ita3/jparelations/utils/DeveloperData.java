package ita3.jparelations.utils;

import ita3.jparelations.entity.Address;
import ita3.jparelations.entity.Citizen;
import ita3.jparelations.entity.Town;
import ita3.jparelations.repository.IAddressRepository;
import ita3.jparelations.repository.ICitizenRepository;
import ita3.jparelations.repository.ITownRepository;
import ita3.jparelations.service.AddressService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DeveloperData implements ApplicationRunner {

    IAddressRepository addressRepository;
    ICitizenRepository citizenRepository;
    ITownRepository townRepository;
    AddressService addressService;

    public DeveloperData(IAddressRepository address, ICitizenRepository citizen, ITownRepository town, AddressService addressService) {
        this.addressRepository = address;
        this.citizenRepository = citizen;
        this.townRepository = town;
        this.addressService = addressService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Town t1 = new Town("Lyngby", 1900, "Hans", 55);
        Address a1 = new Address("Lyngbyvej 1", "Lyngby", 2800);
        Citizen citizen1 = new Citizen("Kurt", "Wonnegut", "a@b.dk",123, a1, t1);
        Citizen citizen2 = new Citizen("Hanne", "Wonnegut", "h@b.dk", 234, a1, t1);

        a1.addCitizen(citizen1);
        a1.addCitizen(citizen2);

        System.out.println(a1.getCitizens().get(0).getTown().getName());
        addressRepository.save(a1); //Save the address
        //System.out.println(a1.getId());
        //addressService.printFullAddressInfo(a1.getId(), true);
       //List<Citizen> c1 = citizenRepository.findAll();
       // System.out.println(c1);

/*      System.out.println("------- Select statements starts here ------------");
        Address address_1 = addressRepository.findById(a1.getId()).get();
        System.out.println(address_1.getStreet());
        System.out.println("Press Enter to continue");
        System.in.read(); //This will block so you have time to read the DEBUG statements**
        System.out.println("Citizens: " + address_1.getCitizens().size());  */
    }
}
