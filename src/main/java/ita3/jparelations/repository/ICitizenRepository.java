package ita3.jparelations.repository;

import ita3.jparelations.entity.Citizen;
import ita3.jparelations.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICitizenRepository extends JpaRepository<Citizen, Long> {
    public List<Citizen> findCitizenByTownId(Long id);
    public List<Citizen> findCitizenByTownName(String name);
}
