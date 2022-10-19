package entregable.model;

public class CareerWithInscripts {
	private Carrera career;
	private Long inscripts;
	public CareerWithInscripts(Carrera career, Long inscripts) {
		super();
		this.career = career;
		this.inscripts = inscripts;
	}
	public Carrera getCareer() {
		return career;
	}
	public void setCareer(Carrera career) {
		this.career = career;
	}
	public Long getInscripts() {
		return inscripts;
	}
	public void setInscripts(Long inscripts) {
		this.inscripts = inscripts;
	}
	@Override
	public String toString() {
		return "CareerWithInscripts [career=" + career + ", inscripts=" + inscripts + "]";
	}
	
	
}
