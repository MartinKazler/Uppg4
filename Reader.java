package parseinfo;

import java.util.List;

public class Reader {
	String Time;
	String namn;
	String namnb;

	String jobb;
	public Reader(List<String> Reader) {

		Time = Reader.get(0);
		namn = Reader.get(1);
		namnb = Reader.get(2);
		jobb = Reader.get(6);
	}
	
}