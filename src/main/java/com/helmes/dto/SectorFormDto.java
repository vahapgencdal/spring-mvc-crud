package com.helmes.dto;

import com.helmes.model.Sector;
import lombok.Data;

import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
@Data
public class SectorFormDto {
    private Long id;
    private String name;
    private List<SectorFormDto> sectors;

    public static  SectorFormDto toDto(Sector sector){
        SectorFormDto sectorFormDto = new SectorFormDto();
        sectorFormDto.setId(sector.getId());
        sectorFormDto.setName(sector.getName());
        return sectorFormDto;
    }

}
