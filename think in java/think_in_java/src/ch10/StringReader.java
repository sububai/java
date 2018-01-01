package ch10;

import java.util.Vector;
import java.io.*;

public class StringReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> vec = new Vector<>();
		String s = null;
		try {
			FileReader fr = new FileReader("src/ch10/test.txt");
			/*FileReader fr = new FileReader(args[0]);*/
			BufferedReader br = new BufferedReader(fr);
			while ( (s = br.readLine()) != null) {
				vec.add(new String(s));
			}
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("src/ch10/test2.txt")));
			if (!vec.isEmpty()) {
				for (int i = vec.size()-1; i >= 0; i--) {
					System.out.println(vec.get(i).toUpperCase());
					pw.println(i + "" + vec.get(i));
				}
			}
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
