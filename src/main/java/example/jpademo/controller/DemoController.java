package example.jpademo.controller;

import example.jpademo.dto.DemoRequestDto;
import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;
import example.jpademo.service.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
