package mytime;

public class MyTime {
	protected int T[] = {0, 0, 0};
	private final int Max[] = {24, 60, 60};
	public MyTime(){
		this(0, 0, 0);
	}

	public MyTime(int H){
		this(H, 0, 0);
	}
	
	public MyTime(int H, int M){
		this(H, M, 0);
	}
	
	public MyTime(int H, int M, int S){
		this.T[0] = H;
		this.T[1] = M;
		this.T[2] = S;
	}

	// Construct new instance from existing instance
	public MyTime(MyTime src){
		this(src.T[0], src.T[1], src.T[2]);
	}

	public String toUniversalString(){
		String errMsg = "";
		if (this.T[0] >= this.Max[0]) errMsg += "hour must be 0-23\n";
		if (this.T[1] >= this.Max[1]) errMsg += "minute must be 0-59\n";
		if (this.T[2] >= this.Max[2]) errMsg += "second must be 0-59\n";
		if (errMsg != "") return errMsg;
		return this.toFixed(this.T[0]) + ":" + this.toFixed(this.T[1]) + ":" + this.toFixed(this.T[2]);
	}

	public String toString(){
		if (this.T[0] >= 12){
			if (this.T[0] > 12) this.T[0] = this.T[0] - 12;
			return this.toUniversalString() + " PM";
		}
		else{
			if (this.T[0] == 0) this.T[0] = 12;
			return this.toUniversalString() + " AM";
		}
	}

	private String toFixed(int x){
		if (x < 10) return "0" + x;
		return "" + x;
	}
}


