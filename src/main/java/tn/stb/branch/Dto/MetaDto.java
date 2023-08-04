package tn.stb.branch.Dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class MetaDto  implements Serializable {
     LicenseDto license;


}
