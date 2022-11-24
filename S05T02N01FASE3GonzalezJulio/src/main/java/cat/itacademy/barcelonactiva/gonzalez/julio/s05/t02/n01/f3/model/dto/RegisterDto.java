package cat.itacademy.barcelonactiva.gonzalez.julio.s05.t02.n01.f3.model.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String username;
    private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    
}