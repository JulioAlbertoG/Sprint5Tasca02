package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.dto;


import lombok.Data;

@Data
public class AuthResponseDTO {
    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthResponseDTO(String accessToken) {
        this.accessToken = accessToken;
    }
}
