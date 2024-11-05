package example.jpademo.entity;

import example.jpademo.dto.DemoRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "demo_entity")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class DemoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private Integer quantity;
    private Integer price;

    public DemoEntity(DemoRequestDto demoRequestDto) {
        this.name = demoRequestDto.getName();
        this.address = demoRequestDto.getAddress();
        this.quantity = demoRequestDto.getQuantity();
        this.price = demoRequestDto.getPrice();
    }
}
