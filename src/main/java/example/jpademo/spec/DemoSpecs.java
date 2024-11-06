package example.jpademo.spec;

import example.jpademo.entity.DemoEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public class DemoSpecs {

    public static Specification<DemoEntity> isNotBurgerAndAtSeoulAndLessThan(Integer maxPrice) {
        return (root, query, builder) -> {

            Predicate notBurger = builder.notEqual(root.get("name"), "Burger");
            Predicate atSeoul = builder.equal(root.get("address"), "Seoul");
            Predicate lessThan = builder.lessThan(root.get("price"), maxPrice);

            return builder.and(notBurger, atSeoul, lessThan);
        };
    }
}
