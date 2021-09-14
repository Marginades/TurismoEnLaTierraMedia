package parqueDeDiversiones;

public interface Comprable {

	public String getNombre();
	
	public double getCosto();

	public double getDuracion();

	public TipoDeAtraccion getTipo();
	
	public int getEntradasVendidas();
	
	
	public boolean hayCupo();

	public void comprarLugar();

	public boolean esPromocion();
}