package tn.stb.branch.Dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class LocationDto  implements Serializable {
    public double latitude;
    public double longitude;
}
