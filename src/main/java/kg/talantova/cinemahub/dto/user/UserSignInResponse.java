package kg.talantova.cinemahub.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserSignInResponse {
    @JsonProperty("access_token")
    String accessToken;
}
