package example.jpademo.service;

import example.jpademo.dto.DemoChildWithParentDto;
import example.jpademo.dto.DemoRequestDto;
import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface DemoService {

    DemoEntity save(DemoRequestDto demoRequestDto);

    List<DemoResponseDto> getAllDTOsByName(String name);

    List<DemoEntity> getAllEntitiesByNameLike(String name);

    List<DemoEntity> getIsNotBurgerAndAtSeoulAndLessThan(Integer maxPrice);

    List<DemoEntity> getHasChildWithOption(String option);

    List<DemoEntity> getDemoEntitiesByNamePage(String keyword, Integer priceLimit, Pageable pageable);

    List<DemoChildWithParentDto> getDemoEntitiesWithChild();

    List<Map<String, String>> getTuples();
}
