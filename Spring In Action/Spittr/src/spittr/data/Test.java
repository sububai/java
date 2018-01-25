package spittr.data;

import static org.junit.Assert.assertNotNull;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SimpleImpl.class)
public class Test {
	private SpittleRepository spittleRepository;
	
	@Autowired
	public Test (SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}
	
	@org.junit.Test
	public void shouldenotNull() {
		assertNotNull(spittleRepository);
	}
}
