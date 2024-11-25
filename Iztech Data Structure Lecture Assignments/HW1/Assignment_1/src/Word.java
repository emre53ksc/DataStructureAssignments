public class Word {
	private String content;
	@SuppressWarnings("unused")
    private int length;
	
	public Word(String chars) {
		this.content = chars;
	} 
	public String toString() {
		return this.content;
	}
	public boolean equals(Object obj) {
		if(obj.toString().equals(this.content)) {
			return true;
		}
		return false;
	}
		
}
