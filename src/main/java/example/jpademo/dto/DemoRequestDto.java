package example.jpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DemoRequestDto {

    private String name;
    private String address;
    private Integer quantity;
    private Integer price;
}
