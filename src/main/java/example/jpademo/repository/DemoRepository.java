package example.jpademo.repository;

import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface DemoRepository extends JpaRepository<DemoEntity, Long>, JpaSpecificationExecutor<DemoEntity> {

    List<DemoResponseDto> findAllByName(String name);
    List<DemoEntity> findAllByNameLike(String name);
}
