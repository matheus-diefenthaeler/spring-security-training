package diefenathaeler.matheus.springsecuritytrain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {
    private Long id;
    private String name;
    private String publisher;
}
