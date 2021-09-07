package parqueDeDiversiones;

public interface Comprable {

	public String getNombre();
	
	public int getCosto();

	public double getDuracion();

	public TipoDeAtraccion getTipo();
	
	public int getEntradasVendidas();

	public int cupoMaximo(); 
	
	
	public boolean hayCupo();

	public void comprarLugar();


}