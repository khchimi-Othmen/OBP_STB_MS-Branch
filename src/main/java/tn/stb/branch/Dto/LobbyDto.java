package tn.stb.branch.Dto;

import lombok.*;

import java.io.Serializable;

@Builder
@Value
public class LobbyDto  implements Serializable {
    public String hours;
}
