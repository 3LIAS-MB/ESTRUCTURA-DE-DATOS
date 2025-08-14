package Ejercicio5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		ArrayList<Integer> identificadores= new ArrayList<Integer>();
		SimpleLinkedList<Video> lista = new SimpleLinkedList<Video>();
		int op;
		do {
 			op=opciones();
			switch (op) {
			case 1:
				Video nuevo=crear(identificadores);
				lista.addLast(nuevo);
				break;
			case 2:
				System.out.println("1- Lista con un tema a eleccion");
				System.out.println("2- Lista con una duracion determinada");
				System.out.println("3- Lista aleatoria");
				System.out.println("4- Lista de un determinado creador de contenido");
				
				
				int eleccion=Helper.getPositiveInt_conLimitador("¿Qué lista desea generar?: ", "error", 4);
				switch (eleccion) {
				case 1:
					System.out.println("¿De qué tema desea una lista de reproducciones?: ");
					String tema=sc.nextLine();
					SimpleLinkedList<Video> generada=temaEleccion(lista,tema);
					System.out.println(generada.toString());
					break;
				case 2:
					int inferiores= Helper.getPositiveInt("no deben superar los: ");
					SimpleLinkedList<Video> resultado=segunDuracion(lista,inferiores);
					System.out.println(resultado.toString());
					
					break;
				case 3:
					SimpleLinkedList<Video>videosAleatorios=aleatorio(lista);
					System.out.println(videosAleatorios.toString());
					break;
				case 4:
					System.out.println("ingrese creador de contenido: ");
					String creador=sc.nextLine();
					SimpleLinkedList<Video> segunCreador=listaCreador(lista,creador);
					System.out.println(segunCreador.toString());
					break;
				default:
					break;
				}
				break;
				
			case 3:
				System.out.println("ingrese tema: ");
				String tema2=sc.nextLine();
				int total=totalMinutos(lista,tema2);
				System.out.println("la lista del tema "+tema2+" tiene un total de minutos de "+total);
				break;
				
			case 4:
				System.out.println(lista.toString());
				break;
			case 5:
				System.out.println("fin del programa");
				break;
			default:
				System.out.println("fin del programa");
				op=5;
				break;
			}
		} while (op!=5);
		

}
	
	public static int opciones() {
		System.out.println("1- Agregar video");
		System.out.println("2- Lista de reproducciones");
		System.out.println("3- Duracion de videos");
		System.out.println("4- Mostrar lista");
		System.out.println("5- Salir");
		int op=Helper.getPositiveInt_conLimitador("Ingrese la opcion que desea: ", "ingreso invalido", 6);
		return op;
	}
	
	public static Video crear(ArrayList<Integer> identificadores) {
		Character resp=Helper.yesOrNo("¿Desea ingresar de manera manual?: ");
		if(resp.toString().equalsIgnoreCase("s")) {
			Integer identificador=unicoIden(identificadores,resp);
			
			String titVideo= Helper.validarString("Ingrese titulo del video: ", "Titulo no valido: ");
			
			String nomCreador=Helper.validarString("Ingrese nombre de creador: ","Nombre no valido");
		    Integer duracion=Helper.getPositiveInt("Cuanto dura el video: ");
		    Video video1 = new Video(identificador,titVideo,nomCreador,duracion);
			//lista.addInOrden(video1);
		    return video1;
		}else {
			Integer identificador=unicoIden(identificadores,resp);
			String [] titulos= {"risas increíbles", "trucos increíbles", "momentos divertidos", "recetas fáciles", "trucos fáciles", "mascotas divertidas", "diy en minutos", "fitness express", "consejos utiles", "belleza express"};
			String [] nombres= {"sofía creativa", "carlos increíble", "ana divertida", "juan fácil", "marta express", "diego diy", "laura fitness", "pablo consejos", "elena belleza", "luis trucos"};
			Integer pos=(int)(Math.random()*10);
			Integer duracion=(int)(Math.random()*100+1);
			Video video2=new Video(identificador,titulos[pos],nombres[pos],duracion);
			//lista.addInOrden(video2);
			return video2;



		}
	}
	public static Integer unicoIden(ArrayList<Integer>identificadores, Character resp) {
		if(resp.toString().equalsIgnoreCase("s")) {
			String continuar="si";
			Integer indentificador=null;
			while(continuar.equalsIgnoreCase("si")) {
				indentificador=Helper.getPositiveInt_conLimitador("ingrese identificador: ", "error", 999);
				if(identificadores.size()==0) {
					identificadores.add(indentificador);
					return indentificador;
				} else {
					if(identificadores.contains(indentificador)) {
						System.out.println("ya existe identificador");
						continuar="si";
					} else {
						continuar="no";
					}
				}
			}
			identificadores.add(indentificador);
			
			return indentificador;
			
		}else {
			String continuar="si";
			Integer azar=null;
			while(continuar.equalsIgnoreCase("si")) {
				azar=(int)(Math.random()*1000);
				if(identificadores.contains(azar)) {
					continuar="si";
				}else {
					continuar="no";
				}
			}
			identificadores.add(azar);
			return azar;
			
	}
	
}
	
	public static SimpleLinkedList<Video> temaEleccion(SimpleLinkedList<Video>lista,String tema){
		SimpleLinkedList<Video> auxiliar=new SimpleLinkedList<Video>();
		SimpleLinkedList<Video> temaSeleccionado=new SimpleLinkedList<Video>();
		while(lista.size()>0) {
			Video sacar=lista.removeFirst();
			if(sacar.getTituloVideo().equalsIgnoreCase(tema) || sacar.getTituloVideo().contains(tema)) {
				temaSeleccionado.addInOrden(sacar);;
				auxiliar.addLast(sacar);
			}else {
				auxiliar.addLast(sacar);
			}
		}
		lista=devolver(auxiliar,lista);
		
		return temaSeleccionado;
	}
	public static SimpleLinkedList<Video> devolver(SimpleLinkedList<Video>auxiliar,SimpleLinkedList<Video>lista){
		while(auxiliar.size()>0) {
			Video p=auxiliar.removeFirst();
			lista.addLast(p);
		}
		return lista;
	}
	
	public static SimpleLinkedList<Video> segunDuracion(SimpleLinkedList<Video>lista,int inferiores){
		SimpleLinkedList<Video> auxiliar=new SimpleLinkedList<Video>();
		SimpleLinkedList<Video> porDuracion=new SimpleLinkedList<Video>();
		while(lista.size()>0) {
			Video sacar= lista.removeFirst();
			if(sacar.getDuracion()<=inferiores) {
				auxiliar.addLast(sacar);
				porDuracion.addLast(sacar);
			}else {
				auxiliar.addLast(sacar);
			}
		}
		lista=devolver(auxiliar,lista);
		return porDuracion;
	}
	
	public static SimpleLinkedList<Video> aleatorio(SimpleLinkedList<Video>lista){
		SimpleLinkedList<Video> auxiliar=new SimpleLinkedList<Video>();
		SimpleLinkedList<Video> videosAleatorios=new SimpleLinkedList<Video>();
		while(lista.size()>0) {
			Video sacar=lista.removeFirst();
			int azar=(int)(Math.random()*3);
			if(azar==1) {
				videosAleatorios.addLast(sacar);
				auxiliar.addLast(sacar);
			}else {
				auxiliar.addLast(sacar);
			}
			
		}
		lista=devolver(auxiliar,lista);
		return videosAleatorios;
	}
	
	public static SimpleLinkedList<Video> listaCreador(SimpleLinkedList<Video>lista,String creador){
		SimpleLinkedList<Video> auxiliar=new SimpleLinkedList<Video>();
		SimpleLinkedList<Video> devolver=new SimpleLinkedList<Video>();
		
		while(lista.size()>0) {
			Video sacar=lista.removeFirst();
			if(sacar.getCreadorContenido().equalsIgnoreCase(	creador)) {
				devolver.addLast(sacar);
				auxiliar.addLast(sacar);
			}else {
				auxiliar.addLast(sacar);
			}
		}
		lista=devolver(auxiliar,lista);
		return devolver;
	}
	
	public static int totalMinutos(SimpleLinkedList<Video> lista,String tema2) {
		SimpleLinkedList<Video> auxiliar=new SimpleLinkedList<Video>();
		int minutosTotales=0;
		while(lista.size()>0) {
			Video remover=lista.removeFirst();
			if(remover.getTituloVideo().equalsIgnoreCase(tema2) || remover.getTituloVideo().contains(tema2)) {
				minutosTotales+=remover.getDuracion();
				auxiliar.addLast(remover);
			}else {
				auxiliar.addLast(remover);
			}
		}
		lista=devolver(auxiliar,lista);
		return minutosTotales;
	}
}
