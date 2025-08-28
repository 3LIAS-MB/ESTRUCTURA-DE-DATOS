package Ejercicio5;

public class Video implements Comparable<Video>{
	private Integer identificador;
	private String tituloVideo;
	private String creadorContenido;
	private Integer duracion;
	
	
	public Video(Integer identificador,String tituloVideo,String creadorContenido,Integer duracion) {
		this.identificador=identificador;
		this.tituloVideo=tituloVideo;
		this.creadorContenido=creadorContenido;
		this.duracion=duracion;
	}


	public Integer getIdentificador() {
		return identificador;
	}


	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}


	public String getTituloVideo() {
		return tituloVideo;
	}


	public void setTituloVideo(String tituloVideo) {
		this.tituloVideo = tituloVideo;
	}


	public String getCreadorContenido() {
		return creadorContenido;
	}


	public void setCreadorContenido(String creadorContenido) {
		this.creadorContenido = creadorContenido;
	}


	public Integer getDuracion() {
		return duracion;
	}


	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}
	
   
	@Override
	public String toString() {
		return "Video [identificador=" + identificador + ", tituloVideo=" + tituloVideo + ", creadorContenido="
				+ creadorContenido + ", duracion=" + duracion + "]";
	}


	public int compareTo(Video otro) {
		//return this.tituloVideo.compareTo(otro.getTituloVideo());
		return this.tituloVideo.compareToIgnoreCase(otro.getTituloVideo());
	}
	
}
