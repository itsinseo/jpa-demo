package example.jpademo.service.impl;

import example.jpademo.dto.DemoChildWithParentDto;
import example.jpademo.dto.DemoRequestDto;
import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;
import example.jpademo.repository.DemoRepository;
import example.jpademo.repository.DemoRepositoryQuerydsl;
import example.jpademo.service.DemoService;
import example.jpademo.spec.DemoSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;
    private final DemoRepositoryQuerydsl demoRepositoryQuerydsl;

    @Override
    public DemoEntity save(DemoRequestDto demoRequestDto) {
        return demoRepository.save(new DemoEntity(demoRequestDto));
    }

    @Override
    public List<DemoResponseDto> getAllDTOsByName(String name) {
        return demoRepository.findAllByName(name);
    }

    @Override
    public List<DemoEntity> getAllEntitiesByNameLike(String name) {
        return demoRepository.findAllByNameLike(name);
    }

    @Override
    public List<DemoEntity> getIsNotBurgerAndAtSeoulAndLessThan(Integer maxPrice) {
        return demoRepository.findAll(DemoSpecs.isNotBurgerAndAtSeoulAndLessThan(maxPrice));
    }

    @Override
    public List<DemoEntity> getHasChildWithOption(String option) {
        return demoRepository.findAll(DemoSpecs.hasChildWithOption(option));
    }

    @Override
    public List<DemoEntity> getDemoEntitiesByNamePage(String keyword, Integer priceLimit, Pageable pageable) {
        return demoRepositoryQuerydsl.getDemoEntitiesByNamePage(keyword, priceLimit, pageable);
    }

    @Override
    public List<DemoChildWithParentDto> getDemoEntitiesWithChild() {
        return demoRepositoryQuerydsl.getDemoEntitiesWithChild();
    }

    @Override
    public List<Map<String, String>> getTuples() {
        return demoRepositoryQuerydsl.getTuples();
    }

}
