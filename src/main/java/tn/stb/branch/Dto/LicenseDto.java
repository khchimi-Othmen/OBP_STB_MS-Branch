package tn.stb.branch.Dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class LicenseDto  implements Serializable {
    public String id;
    public String name;
}
