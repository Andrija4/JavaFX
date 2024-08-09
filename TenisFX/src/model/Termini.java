package model;

public class Termini {
	
	private String teren;
	private String vreme;
	private String prviTim;
	private String drugiTim;
	
	public Termini(String teren, String vreme, String prviTim, String drugiTim) {
		super();
		this.teren = teren;
		this.vreme = vreme;
		this.prviTim = prviTim;
		this.drugiTim = drugiTim;
	}
	public String getTeren() {
		return teren;
	}
	public String getVreme() {
		return vreme;
	}
	public String getPrviTim() {
		return prviTim;
	}
	public String getDrugiTim() {
		return drugiTim;
	}
	public void setPrviTim(String prviTim) {
		this.prviTim = prviTim;
	}
	public void setDrugiTim(String drugiTim) {
		this.drugiTim = drugiTim;
	}
	
	@Override
	public String toString() {
		return teren + "-" + vreme + " " + prviTim + " vs " + drugiTim;
	}
	

}
