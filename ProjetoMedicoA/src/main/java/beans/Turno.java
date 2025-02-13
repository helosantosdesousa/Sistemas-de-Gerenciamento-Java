package beans;

public class Turno {
	private int id;
	private String nome;
	private double bonus;
	
	
	public Turno(int id, String nome, double bonus) {
		super();
		this.id = id;
		this.nome = nome;
		this.bonus = bonus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	

}
