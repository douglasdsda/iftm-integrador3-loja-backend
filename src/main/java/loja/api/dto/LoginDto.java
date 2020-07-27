package loja.api.dto;
import lombok.*;


@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    private String email;

    private String senha;
}