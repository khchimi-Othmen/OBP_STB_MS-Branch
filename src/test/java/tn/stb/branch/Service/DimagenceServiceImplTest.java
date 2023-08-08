package tn.stb.branch.Service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import tn.stb.branch.Dto.BranchRoutingDto;
import tn.stb.branch.Dto.DimagenceDto;
import tn.stb.branch.Entity.Dimagence;
import tn.stb.branch.Exception.BankNotFoundException;
import tn.stb.branch.Exception.BranchNotFoundException;
import tn.stb.branch.Exception.ErrorCodes;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitConfig
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DimagenceServiceImplTest {

    @Autowired
    private DimagenceServiceImpl dimagenceService;


    @Test
    @Order(1)
    void shouldRetrieveBranchById() {
        // Create a sample branch (fake data)
        Dimagence branch = new Dimagence();
        branch.setCodeAgence("156");
        // When: Call the service method
        DimagenceDto result = dimagenceService.getBranchById("156", "10");

        // Then: Verify the result and expectations
        assertNotNull(result, "Returned branch should not be null");
        assertEquals("156", result.getId(), "Branch ID should match expected value");
//        assertEquals("SBEITLA", result.getName(), "Branch name should match expected value");
    }

    @Test
    @Order(2)
    void shouldThrowBankNotFoundException() {
        BankNotFoundException exception = assertThrows(
                BankNotFoundException.class,
                () -> dimagenceService.getBranchById("156", "20"),
                "BankNotFoundException should be thrown"
        );

        assertEquals(ErrorCodes.OBP_BANK_NOT_FOUND, exception.getErrorCode(), "Error code should match");
    }

    @Test
    @Order(3)
    void shouldHandleBranchNotFoundException() {
        BranchNotFoundException exception = assertThrows(
                BranchNotFoundException.class,
                () -> dimagenceService.getBranchById("1560", "10"),
                "BranchNotFoundException should be thrown"
        );

        assertEquals(ErrorCodes.OBP_BRANCH_NOT_FOUND, exception.getErrorCode(), "Error code should match");
    }

    @Test
    @Order(4)
    void shouldGetAllBranchesForValidBankId() {
        // When: Call the service method to get all branches with valid bank ID
        List<DimagenceDto> branches = dimagenceService.getBranches("10");

        // Then: Verify the returned list and its contents
        assertNotNull(branches, "Returned list should not be null");
        assertFalse(branches.isEmpty(), "Returned list should not be empty");

        // Verify the details of each branch DTO in the list (you can add more assertions here)
        for (DimagenceDto branchDto : branches) {
            assertNotNull(branchDto.getId(), "Branch ID should not be null");
            assertNotNull(branchDto.getName(), "Branch name should not be null");
            assertNotNull(branchDto.getAddress(), "Branch address should not be null");
            assertNotNull(branchDto.getBranch_routing(), "Branch routing should not be null");
        }
    }

    @Test
    @Order(5)
    void shouldConvertEntityToDto() {
        // Given: Create a Dimagence entity
        Dimagence dimagence = new Dimagence();
        dimagence.setCodeAgence("156");
        dimagence.setAgence("SBEITLA");
        dimagence.setGouvernerat("Gouv");
        dimagence.setCodePostal("1250");
        dimagence.setAdresse("Angle rue de Libye et de la rue Sammama cité des forêts 1250 - Sbeitla");
        dimagence.setLatitude(35.2293281);
        dimagence.setLongitude(9.1262461);

        // When: Convert entity to DTO
        DimagenceDto dto = DimagenceDto.fromEntity(dimagence);

        // Then: Verify the conversion
        assertNotNull(dto);
        assertEquals("156", dto.getId());
        assertEquals("SBEITLA", dto.getName());

        BranchRoutingDto branchRoutingDto = dto.getBranch_routing();
        assertNotNull(branchRoutingDto);
        assertEquals("Angle rue de Libye et de la rue Sammama cité des forêts 1250 - Sbeitla", branchRoutingDto.getAddress());
    }

}