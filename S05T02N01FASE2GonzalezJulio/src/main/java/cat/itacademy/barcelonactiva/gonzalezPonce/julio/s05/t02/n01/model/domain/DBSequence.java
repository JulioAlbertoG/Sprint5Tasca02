package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Document("db_sequences")
@Component
public class DBSequence {

	@Id
	private String id;
	
	private int seq;
	public DBSequence() {}
	
	
	public DBSequence(String id,int seq) {
		this.id=id;
		this.seq=seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}
	
	
}
