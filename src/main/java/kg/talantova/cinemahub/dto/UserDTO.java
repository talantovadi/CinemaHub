package kg.talantova.cinemahub.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String nickname;
    private String email;
}
