package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepsitory {
	List<Spittle> findSpittles(long max, int count);
}
