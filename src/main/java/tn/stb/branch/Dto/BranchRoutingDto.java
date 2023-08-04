package tn.stb.branch.Dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class BranchRoutingDto  implements Serializable {
    public String scheme = "10";
    public String address;
}
