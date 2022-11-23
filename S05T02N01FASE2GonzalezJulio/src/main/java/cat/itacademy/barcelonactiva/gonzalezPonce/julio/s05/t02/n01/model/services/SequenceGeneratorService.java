package cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.services;

import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.gonzalezPonce.julio.s05.t02.n01.model.domain.DBSequence;

@Service
public class SequenceGeneratorService {

	@Autowired
	private MongoOperations mongoOperations;

	public int generateSequence(String seqName) {
		DBSequence counterDbSequence = mongoOperations.findAndModify(
				query(where("id").is(seqName)), 
				new Update().inc("seq",1), 
				options().returnNew(true).upsert(true),
				DBSequence.class);
		
		return counterDbSequence.getSeq();
	}
}
