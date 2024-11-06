package example.jpademo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import example.jpademo.dto.DemoRequestDto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "demo_entity")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private Integer quantity;
    private Integer price;

    @OneToMany(mappedBy = "demoEntity", cascade = CascadeType.REMOVE)
    private List<DemoChildEntity> demoChildEntityList;

    @Builder
    public DemoEntity(String name, String address, Integer quantity, Integer price) {
        this.name = name;
        this.address = address;
        this.quantity = quantity;
        this.price = price;
        this.demoChildEntityList = new ArrayList<>();
    }

    public DemoEntity(DemoRequestDto demoRequestDto) {
        this.name = demoRequestDto.name();
        this.address = demoRequestDto.address();
        this.quantity = demoRequestDto.quantity();
        this.price = demoRequestDto.price();
    }
}
