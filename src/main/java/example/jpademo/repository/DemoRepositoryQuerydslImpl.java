package example.jpademo.repository;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import example.jpademo.dto.DemoChildWithParentDto;
import example.jpademo.entity.DemoEntity;
import example.jpademo.entity.QDemoChildEntity;
import example.jpademo.entity.QDemoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class DemoRepositoryQuerydslImpl implements DemoRepositoryQuerydsl {

    private final JPAQueryFactory jpaQueryFactory;

    private final QDemoEntity demoEntity = QDemoEntity.demoEntity;
    private final QDemoChildEntity demoChildEntity = QDemoChildEntity.demoChildEntity;

    @Override
    public List<DemoEntity> getDemoEntitiesByNamePage(String keyword, Integer priceLimit, Pageable pageable) {

        return jpaQueryFactory.selectFrom(demoEntity)
                .where(demoEntity.name.startsWithIgnoreCase(keyword).and(demoEntity.price.lt(priceLimit)))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(demoEntity.price.asc())
                .fetch();
    }

    @Override
    public List<DemoChildWithParentDto> getDemoEntitiesWithChild() {

        return jpaQueryFactory
                .select(Projections.constructor(DemoChildWithParentDto.class, demoEntity, demoChildEntity))
                .from(demoEntity)
                .join(demoChildEntity).on(demoChildEntity.demoEntity.id.eq(demoEntity.id))
                .fetch();
    }

    @Override
    public List<Map<String, String>> getTuples() {

        List<Tuple> tuples = jpaQueryFactory
                .select(demoEntity.name, demoChildEntity.description)
                .from(demoEntity)
                .join(demoChildEntity).on(demoChildEntity.demoEntity.id.eq(demoEntity.id))
                .fetch();

        return tuples.stream().map(tuple -> Map.of(
                "name", Objects.requireNonNull(tuple.get(demoEntity.name)),
                "description", Objects.requireNonNull(tuple.get(demoChildEntity.description))
        )).toList();
    }
}
