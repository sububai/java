package chapter11;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Foo extends AbstractFoo implements Serializable {
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		
		//手动反序列化，初始化超类
		int x = s.readInt();
		int y = s.readInt();
		initialize(x, y);
	}
	private void writeObject(ObjectOutputStream s) throws IOException {
		((ObjectOutputStream) s).defaultWriteObject();
		
		//手动序列化超类的状态
		s.writeInt(getX());
		s.writeInt(getY());
	}
	
	public Foo(int x, int y) { super(x, y); }
	private static final long serialVersionUID = 1856835860954L;
}
