package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
public class SpittleRepoImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		List<Spittle> list = new ArrayList<Spittle>();
		list.add(new Spittle(1L, "test", new Date(123), 1.0, 1.0));
		return list;
	}

	@Override
	public List<Spittle> findRecentSpittles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Spittle findOne(long id) {
		// TODO Auto-generated method stub
		return new Spittle("Hello world! The fist ever spittle", new Date());
	}

	@Override
	public void save(Spittle spittle) {
		// TODO Auto-generated method stub
		
	}

}
