package spittr.data;

import org.springframework.stereotype.Component;

import spittr.Spitter;

@Component
public class SpitterRepoImpl implements SpitterRepository {

	@Override
	public Spitter save(Spitter spitter) {
		// TODO Auto-generated method stub
		return spitter;
	}

	@Override
	public Spitter findByUsername(String username) {
		// TODO Auto-generated method stub
		return new Spitter(username, "123", "t", "est");
	}

}
