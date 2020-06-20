package loja.api.dto;
import lombok.*;
import org.hibernate.annotations.Generated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;


}