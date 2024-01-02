package com.spotit.backend.employee.referenceData.softSkillName;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.spotit.backend.employee.abstraction.EntityMapper;

@Mapper
public interface SoftSkillNameMapper
        extends EntityMapper<SoftSkillName, SoftSkillNameReadDto, SoftSkillNameWriteDto> {

    @Override
    SoftSkillNameReadDto toReadDto(SoftSkillName softSkillName);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "custom", ignore = true)
    @Mapping(target = "softSkills", ignore = true)
    SoftSkillName fromWriteDto(SoftSkillNameWriteDto softSkillName);
}
