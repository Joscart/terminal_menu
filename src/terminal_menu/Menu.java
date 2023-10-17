package terminal_menu;

import java.util.*;

//Clase para imprimir un menu de opciones en terminal

public class Menu {
	
	private String titulo = "Menu de Opciones";
	private List<String> opciones = new ArrayList<String>();
	private List<String> comando = new ArrayList<String>();
	private Scanner in;
	private boolean numerado = false;

	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Menu(Scanner in) {
		super();
		this.in = in;
	}

	public Menu(Scanner in,String titulo) {
		super();
		this.in = in;
		this.titulo = titulo;
	}
	
	public void addOpcion(String opcion,String comando) {
		//Si se repite un comando no lo acepta
		if(this.comando.contains(comando))
			return;
		
		this.opciones.add(opcion);
		this.comando.add(comando);
	}
	
	public void resetOpciones() {
		this.opciones.clear();
		this.comando.clear();
	}

	public boolean isNumerado() {
		return numerado;
	}

	public void setNumerado(boolean numerado) {
		this.numerado = numerado;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public void setIn(Scanner in) {
		this.in = in;
	}

	public int print() {
		if(this.opciones.isEmpty() || this.comando.isEmpty()) {
			System.out.println("Sin opciones para imprimir");
			return -1;
		}
		
		String str;
		
		//Imprime el menu y pregunta al usuario por un comando de las opciones disponibles
		System.out.println("\n*** "+this.titulo+" ***\n");
		
		for(int i = 1; i < this.opciones.size()+1;i++) {
			System.out.println((this.isNumerado()? "*"+i : "*[" + this.comando.get(i-1) + "]")
					+"*\t"+this.opciones.get(i-1));
		}
		
		System.out.println("\nElija su opcion:\n");
		
		str = in.next();
		
		for(int i = 1; i < this.comando.size()+1;i++) {
			if(str.equals(this.comando.get(i-1)))
					return i;
		}
		
		//Si no encuentra ningun comando disponible retorna un numero fuera de la lista
		return -1;
	}
	
	public boolean desicion() {
		String str;
		do {
			System.out.println("Desea Continuar? (s/n):");
			str = in.next();
			if(str.equalsIgnoreCase("n"))
				return false;
			if(!str.equalsIgnoreCase("s"))
				System.out.println("Intente de nuevo\n");
		}while(!str.equalsIgnoreCase("s"));
		
		return true;
	}
}
