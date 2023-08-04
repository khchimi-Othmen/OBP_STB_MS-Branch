package tn.stb.branch.Dto;

import lombok.*;
import tn.stb.branch.Entity.Dimagence;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * DTO for {@link tn.stb.branch.Entity.Dimagence}
 */

@Builder
@Value
public class DimagenceDto implements Serializable {
    String id;
    String name;
    AddressDto address;
    LocationDto location;
    LobbyDto lobby;
    DriveUpDto drive_up;
    MetaDto meta;
    BranchRoutingDto branch_routing;


    public static DimagenceDto fromEntity(Dimagence dimagence) {
        if (dimagence == null) {
            return null;
        }

        AddressDto addressDto = AddressDto.builder()
                .line_1("")
                .line_2("")
                .line_3("")
                .city(dimagence.getGouvernerat())
                .country(dimagence.getGouvernerat())
                .state(dimagence.getGouvernerat())
                .postcode(dimagence.getCodePostal())
                .build();

//By initializing locationDto to null and constructing it only when both latitude and longitude are non-null,
// we are ensuring that the resulting DimagenceDto object has meaningful and valid location information.
        LocationDto locationDto = null;
        if (dimagence.getLatitude() != null && dimagence.getLongitude() != null) {
            locationDto = LocationDto.builder()
                    .latitude(dimagence.getLatitude())
                    .longitude(dimagence.getLongitude())
                    .build();
        }

        LobbyDto lobbyDto = LobbyDto.builder()
                .hours("5")
                .build();

        DriveUpDto driveUpDto = DriveUpDto.builder()
                .hours("5")
                .build();

        LicenseDto licenseDto = LicenseDto.builder()
                .id("5")
                .name("TESOBE")
                .build();

        MetaDto metaDto = MetaDto.builder()
                .license(licenseDto)
                .build();



        BranchRoutingDto branchRoutingDto = BranchRoutingDto.builder()
//              .scheme("10")
                .address(dimagence.getAdresse())
                .build();

        return DimagenceDto.builder()
                .id(dimagence.getCodeAgence())
                .name(dimagence.getAgence())
                .address(addressDto)
                .location(locationDto)
                .lobby(lobbyDto)
                .drive_up(driveUpDto)
                .meta(metaDto)
                .branch_routing(branchRoutingDto)
                .build();
    }




    public static Dimagence toEntity(DimagenceDto dimagenceDto) {
        if (dimagenceDto == null) {
            return null;
        }

        Dimagence dimagence = new Dimagence();
        dimagence.setCodeAgence(dimagenceDto.getId());
        dimagence.setAgence(dimagenceDto.getName());

        AddressDto addressDto = dimagenceDto.getAddress();
        if (addressDto != null) {
            dimagence.setGouvernerat(addressDto.getState());
            dimagence.setCodePostal(addressDto.getPostcode());
            dimagence.setAdresse(addressDto.getLine_1() + " " + addressDto.getLine_2() + " " + addressDto.getLine_3());
        }

        LocationDto locationDto = dimagenceDto.getLocation();
        if (locationDto != null) {
            dimagence.setLatitude(locationDto.getLatitude());
            dimagence.setLongitude(locationDto.getLongitude());
        }

        // Lobby , Meta, Licence and DriveUp DTOs have 'hours' attribute, but the entity doesn't
        // You can ignore them or handle them accordingly as per your requirement



        BranchRoutingDto branchRoutingDto = dimagenceDto.getBranch_routing();
        if (branchRoutingDto != null) {

           dimagence.setAdresse(branchRoutingDto.getAddress());
        }

        return dimagence;
    }



}