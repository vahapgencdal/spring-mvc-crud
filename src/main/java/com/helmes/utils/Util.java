package com.helmes.utils;

import com.helmes.dto.SectorFormDto;
import com.helmes.model.Sector;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vahap Gencdal
 * @email avahap19@gmail.com
 */
public class Util {

    public static final String SPACE = "&nbsp;&nbsp;&nbsp;&nbsp;";



    public static String leftPad(final String str, final int size) {
            StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <size; i++) {
            stringBuilder.append(SPACE);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    public static void mapSectorToForm(List<Sector> sectors, final List<SectorFormDto> sortedList){
        sectors.stream().forEach(sector -> {
            SectorFormDto sectorFormDto = new SectorFormDto();
            StringBuilder tempStr = new StringBuilder();
            Sector temp= sector.getParent();
            while (temp!=null){
                tempStr.append(Util.SPACE);
                temp = temp.getParent();
            }
            tempStr.append(sector.getName());
            sectorFormDto.setName(tempStr.toString());
            sectorFormDto.setId(sector.getId());
            sortedList.add(sectorFormDto);
            mapSectorToForm(new ArrayList<>(sector.getSectors()), sortedList);
        });
    }
}
