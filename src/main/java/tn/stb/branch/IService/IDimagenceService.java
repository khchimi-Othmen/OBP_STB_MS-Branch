package tn.stb.branch.IService;

import tn.stb.branch.Dto.DimagenceDto;

import java.util.List;

public interface IDimagenceService {

     DimagenceDto getBranchById(String branchId, String bankId) ;
     List<DimagenceDto> getBranches(String bankId) ;

}
