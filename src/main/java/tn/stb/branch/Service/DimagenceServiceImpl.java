package tn.stb.branch.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.stb.branch.Dto.DimagenceDto;
import tn.stb.branch.Entity.Dimagence;
import tn.stb.branch.Exception.BankNotFoundException;
import tn.stb.branch.Exception.BranchNotFoundException;
import tn.stb.branch.Exception.ErrorCodes;
import tn.stb.branch.Repository.DimagenceRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class DimagenceServiceImpl {

    public static final String VALID_BANK_ID = "10";

    @Autowired
    DimagenceRepository dimagenceRepository;

    public DimagenceDto getBranchById(String branchId, String bankId) {


        // Check if the bankId is valid
        if (!bankId.equals(VALID_BANK_ID)) {
            throw new BankNotFoundException(ErrorCodes.OBP_BANK_NOT_FOUND);
        }

        Optional<Dimagence> optionalBranch = dimagenceRepository.findById(branchId);
        if (optionalBranch.isPresent()) {
            return DimagenceDto.fromEntity(optionalBranch.get());
        } else {
            throw new BranchNotFoundException(ErrorCodes.OBP_BRANCH_NOT_FOUND);
        }
    }



    public List<DimagenceDto> getBranches(String bankId) {
        // Assuming BANK_ID always equals 10, you can ignore the bankId parameter and use it directly as "10".
        if (!bankId.equals(VALID_BANK_ID)) {
            throw new BankNotFoundException(ErrorCodes.OBP_BANK_NOT_FOUND);
        }

        List<Dimagence> branches = dimagenceRepository.findAll();
        if (branches.isEmpty()) {
            throw new BranchNotFoundException(ErrorCodes.OBP_BRANCH_NOT_FOUND);
        }
        // Convert the list of Dimagence entities to a list of DimagenceDto using the fromEntity method in the DTO class
        return branches.stream()
                .map(DimagenceDto::fromEntity)
                .collect(Collectors.toList());
    }


}
