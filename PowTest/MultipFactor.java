package steven.test;

public class MultipFactor {
	private Double value;
	private Double xFactor;
	private Double nFactor;
	private MultipFactor prev;
	private MultipFactor aFactor;
	private MultipFactor bFactor;
	

	public Long size() {
		Long s = (long) 1;
		MultipFactor p = this.prev;
		do {
			p = p.prev;
			s += 1;
		} while (p != null);
		return s;
	}
	
	public MultipFactor getPrev() {
		return prev;
	}
	public void setPrev(MultipFactor prev) {
		this.prev = prev;
	}
	public Double getValue() {
		if (this.value == null) {
			return this.getaFactor().getValue() * this.getbFactor().getValue();
		}
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Double getxFactor() {
		return xFactor;
	}
	public void setxFactor(Double xFactor) {
		this.xFactor = xFactor;
	}
	public Double getnFactor() {
		return nFactor;
	}
	public void setnFactor(Double nFactor) {
		this.nFactor = nFactor;
	}
	public MultipFactor getaFactor() {
		return aFactor;
	}
	public void setaFactor(MultipFactor aFactor) {
		this.aFactor = aFactor;
	}
	public MultipFactor getbFactor() {
		return bFactor;
	}
	public void setbFactor(MultipFactor bFactor) {
		this.bFactor = bFactor;
	}

}
