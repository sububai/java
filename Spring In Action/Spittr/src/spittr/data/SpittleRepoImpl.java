package spittr.data;

import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
public class SpittleRepoImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Spittle> findRecentSpittles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Spittle spittle) {
		// TODO Auto-generated method stub
		
	}

}
