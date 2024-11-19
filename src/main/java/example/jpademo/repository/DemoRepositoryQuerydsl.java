package example.jpademo.repository;

import example.jpademo.dto.DemoChildWithParentDto;
import example.jpademo.entity.DemoEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface DemoRepositoryQuerydsl {

    List<DemoEntity> getDemoEntitiesByNamePage(String keyword, Integer priceLimit, Pageable pageable);

    List<DemoChildWithParentDto> getDemoEntitiesWithChild();

    List<Map<String, String>> getTuples();
}
