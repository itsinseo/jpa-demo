package example.jpademo.service;

import example.jpademo.dto.DemoRequestDto;
import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;

import java.util.List;

public interface DemoService {

    DemoEntity save(DemoRequestDto demoRequestDto);

    List<DemoResponseDto> getAllDTOsByName(String name);

    List<DemoEntity> getAllEntitiesByNameLike(String name);

    List<DemoEntity> getIsNotBurgerAndAtSeoulAndLessThan(Integer maxPrice);
}
