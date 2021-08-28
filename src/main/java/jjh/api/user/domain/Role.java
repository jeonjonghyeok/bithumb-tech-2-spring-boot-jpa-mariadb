package jjh.api.user.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Role implements GrantedAuthority {
    //front 단에서 code 를 넘겨야 함.
    ADMIN("ROLE_ADMIN","관리자 권한"),
    USER("ROLE_USER","사용자 권한"),
    UNKNOWN_USER("ROLE_UNKNOWN_USER","알수없는 사용자");
    private final String code;
    private final String description;

    public static Role of(String code){
        return Arrays.stream(Role.values())
                .filter(i -> i.getCode().equals(code))
                .findAny()
                .orElse(UNKNOWN_USER);
    }

    public String getAuthority() {
        return name();
    }
}
