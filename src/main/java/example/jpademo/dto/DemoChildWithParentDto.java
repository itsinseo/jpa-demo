package example.jpademo.dto;

import example.jpademo.entity.DemoChildEntity;
import example.jpademo.entity.DemoEntity;

public record DemoChildWithParentDto(DemoEntity demoEntity, DemoChildEntity demoChildEntity) {
}
