package example.jpademo.controller;

import example.jpademo.dto.DemoChildWithParentDto;
import example.jpademo.dto.DemoRequestDto;
import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;
import example.jpademo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-demo")
public class DemoController {

    private final DemoService demoService;

    @PostMapping("/entity")
    public ResponseEntity<DemoEntity> saveEntity(@RequestBody DemoRequestDto demoRequestDto) {
        DemoEntity saved = demoService.save(demoRequestDto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<DemoResponseDto>> getAllDTOsByName(@RequestParam String name) {
        List<DemoResponseDto> demoResponseDtoList = demoService.getAllDTOsByName(name);
        return ResponseEntity.ok(demoResponseDtoList);
    }

    @GetMapping("/entity")
    public ResponseEntity<List<DemoEntity>> getAllEntitiesByNameLike(@RequestParam String name) {
        List<DemoEntity> demoEntityList = demoService.getAllEntitiesByNameLike(name);
        return ResponseEntity.ok(demoEntityList);
    }

    @GetMapping("/entity/specification")
    public ResponseEntity<List<DemoEntity>> getAllEntitiesBySpecification(@RequestParam Integer maxPrice) {
        List<DemoEntity> demoEntityList = demoService.getIsNotBurgerAndAtSeoulAndLessThan(maxPrice);
        return ResponseEntity.ok(demoEntityList);
    }

    @GetMapping("/entity/specification-join")
    public ResponseEntity<List<DemoEntity>> getAllEntitiesBySpecificationJoin(@RequestParam String option) {
        List<DemoEntity> demoEntityList = demoService.getHasChildWithOption(option);
        return ResponseEntity.ok(demoEntityList);
    }

    @GetMapping("/entity/querydsl")
    public ResponseEntity<List<DemoEntity>> getDemoEntitiesByNamePage(@RequestParam String keyword,
                                                                      @RequestParam Integer priceLimit,
                                                                      Pageable pageable) {
        List<DemoEntity> demoEntitiesByNamePage = demoService.getDemoEntitiesByNamePage(keyword, priceLimit, pageable);
        return ResponseEntity.ok(demoEntitiesByNamePage);
    }

    @GetMapping("/entity-child/querydsl")
    public ResponseEntity<List<DemoChildWithParentDto>> getDemoEntitiesWithChild() {
        List<DemoChildWithParentDto> demoChildEntityList = demoService.getDemoEntitiesWithChild();
        return ResponseEntity.ok(demoChildEntityList);
    }

    @GetMapping("/tuple")
    public ResponseEntity<List<Map<String, String>>> getTuple() {
        List<Map<String, String>> tupleList = demoService.getTuples();
        return ResponseEntity.ok(tupleList);
    }

}
