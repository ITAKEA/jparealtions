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

        townRepository.save(t1);    // Save the city
        addressRepository.save(a1); //Save the address

        List<Citizen> citizensInLyngbyId = citizenRepository.findCitizenByTownId(t1.getId());
        List<Citizen> citizensInLyngbyName = citizenRepository.findCitizenByTownName(t1.getName());

        System.out.println(citizensInLyngbyId);
        System.out.println(citizensInLyngbyName);
    }
}
