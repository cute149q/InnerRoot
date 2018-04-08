package main;

public class Path {

	private int a;
	private int b;
	private int length;
	private boolean highlight;
	
	public Path(int na, int nb, int l) {
		a = na;
		b = nb;
		length = l;
		highlight = false;
	}
	
	public int getA() {
		return a;
	}
	
    public int getB() {
		return b;
	}

    public int getLength() {
		return length;
	}
    
    public void setA(int a) {
    	this.a = a;
    }
    
    public void setB(int b) {
    	this.b = b ;
    }
    
    public void setL(int length) {
    	this.length = length;
    }
    
    public boolean isHighlight() {
		return highlight;
	}
    
    @Override  
    public String toString() {  
        return a + "->" + b;  
    }  
	
}
