package Q200;

public class BitShifting {
	
	public static final int BITMASK = 1;
	
	public String makeBit(int value) {
		
		char[] val = new char[32];
		for(int i=31; i>=0; i--) {
			if((value & BITMASK) == 1) {
				val[i] = '1';
			}else {
				val[i] = '0';
			}
			value >>>= 1;
		}
		return new String(val);
	}
	
	public String makeBit(int origin, int shift) {
		
		String temp = "";
		if(shift >= 0) {
			temp = makeBit(origin>>shift);
		}else {
			temp = makeBit(origin<<(-shift));
		}
		
		return temp;
	}

}
