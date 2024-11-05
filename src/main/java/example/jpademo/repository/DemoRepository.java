package example.jpademo.repository;

import example.jpademo.dto.DemoResponseDto;
import example.jpademo.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoRepository extends JpaRepository<DemoEntity, Long> {

    List<DemoResponseDto> findAllByName(String name);
    List<DemoEntity> findAllByNameLike(String name);

}
