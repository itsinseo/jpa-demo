package example.jpademo.service.impl;

import example.jpademo.dto.DemoRequestDto;
import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;
import example.jpademo.repository.DemoRepository;
import example.jpademo.service.DemoService;
import example.jpademo.spec.DemoSpecs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemoServiceImpl implements DemoService {

    private final DemoRepository demoRepository;

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
}
