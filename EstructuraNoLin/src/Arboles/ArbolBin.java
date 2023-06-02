package Arboles;

public class ArbolBin <T> {
	private Nodito <T> raiz;
	
	public ArbolBin() {
		raiz = null;
	}
	
	public Nodito <T> getRaiz() {
		return raiz;
	}
	
	public void setRaiz(Nodito <T> raiz) {
		this.raiz = raiz;
	}
	
	public boolean arbolVacio() {
		return raiz == null;
	}
	
	public void vaciarArbol() {
		raiz = null;
	}
	
	public void insetarArbol(T info) {
		Nodito <T> p = new Nodito <T> (info);
		if(arbolVacio()) {
			raiz=p;
		}
		else {
			Nodito <T> padre = buscaPadre(raiz,p);
			if(p.hashCode()>=padre.hashCode()) 
				padre.der=p;
			else
				padre.izq=p;
		}
	}
	
	public Nodito <T> buscaPadre(Nodito <T> actual, Nodito <T> p) {
		Nodito <T> padre = null;
		while(actual!=null) {
			padre=actual;
			if(p.hashCode()>=padre.hashCode())
				actual=padre.der;
			else
				actual=padre.izq;
		}
		return padre;
	}
	
	public String preorden (Nodito <T> r) {
		if(r!=null) {
			return r.getInfo()+"-"+preorden(r.izq)+"-"+preorden(r.der);
		}
		else return "";
	}
	
}
