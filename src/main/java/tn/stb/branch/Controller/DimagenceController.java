package tn.stb.branch.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.stb.branch.Dto.DimagenceDto;
import tn.stb.branch.Exception.BankNotFoundException;
import tn.stb.branch.Exception.BranchNotFoundException;
import tn.stb.branch.Exception.ErrorCodes;
import tn.stb.branch.Exception.UnknownError;
import tn.stb.branch.Service.DimagenceServiceImpl;

import java.util.List;

import static tn.stb.branch.Service.DimagenceServiceImpl.VALID_BANK_ID;


@RestController
@RequestMapping("/obp/v2.1.0/banks")
@CrossOrigin("*")
public class DimagenceController {


    private final DimagenceServiceImpl dimagenceService;

    public DimagenceController(DimagenceServiceImpl dimagenceService) {
        this.dimagenceService = dimagenceService;
    }



    @GetMapping("/{BANK_ID}/branches/{BRANCH_ID}")
    public ResponseEntity<?> getBranchById(@PathVariable String BANK_ID, @PathVariable String BRANCH_ID) {
        try {
            DimagenceDto branch = dimagenceService.getBranchById(BRANCH_ID, BANK_ID);
            return ResponseEntity.ok(branch);
        } catch (BankNotFoundException e) {
            return ResponseEntity.status(e.getErrorCode().getErrorCode()).body(e.getErrorCode().getErrorMessage());
        } catch (BranchNotFoundException e) {
            return ResponseEntity.status(e.getErrorCode().getErrorCode()).body(e.getErrorCode().getErrorMessage());
        } catch (UnknownError e) {
            return ResponseEntity.status(e.getErrorCode().getErrorCode()).body(e.getErrorCode().getErrorMessage());
        }
    }





    @GetMapping("/{BANK_ID}/branches")
    public ResponseEntity<?> getAllBranches(@PathVariable String BANK_ID) {
        try {
            List<DimagenceDto> branches = dimagenceService.getBranches(BANK_ID);
            return ResponseEntity.ok(branches);
        } catch (BankNotFoundException e) {
            return ResponseEntity.status(e.getErrorCode().getErrorCode()).body(e.getErrorCode().getErrorMessage());
        } catch (BranchNotFoundException e) {
            return ResponseEntity.status(e.getErrorCode().getErrorCode()).body(e.getErrorCode().getErrorMessage());
        } catch (UnknownError e) {
            return ResponseEntity.status(e.getErrorCode().getErrorCode()).body(e.getErrorCode().getErrorMessage());
        }
    }

}

