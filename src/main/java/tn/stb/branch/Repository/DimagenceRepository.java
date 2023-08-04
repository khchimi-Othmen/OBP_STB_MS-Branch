package tn.stb.branch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.stb.branch.Dto.DimagenceDto;
import tn.stb.branch.Entity.Dimagence;

public interface DimagenceRepository extends JpaRepository<Dimagence, String> {

    }