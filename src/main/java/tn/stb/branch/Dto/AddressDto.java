package tn.stb.branch.Dto;

import lombok.*;

import java.io.Serializable;


@Builder
@Value
public class AddressDto  implements Serializable {
    public String line_1;
    public String line_2;
    public String line_3;
    public String city;
    public String state;
    public String postcode;
    public String country;
}
