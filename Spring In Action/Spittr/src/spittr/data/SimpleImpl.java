package spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
public class SimpleImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		// TODO Auto-generated method stub
		return new ArrayList<Spittle>();
	}

}
