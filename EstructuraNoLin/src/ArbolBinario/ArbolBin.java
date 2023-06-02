package ArbolBinario;

import EntradaSalida.Tools;
import javax.swing.JOptionPane;

public class ArbolBin<T extends Comparable<T>> {

	private Nodito<T> raiz;

	public ArbolBin() {
		raiz = null;
	}

	public Nodito<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodito<T> raiz) {
		this.raiz = raiz;
	}

	public boolean arbolVacio() {
		return raiz == null;
	}

	public void vaciarArbol() {
		raiz = null;
	}

	public void insertarArbol(T info) {
		Nodito<T> p = new Nodito(info);
		if (arbolVacio()) {
			raiz = p;
		} else {
			Nodito<T> padre = buscaPadre(raiz, p);
			if (p.getInfo().compareTo(padre.getInfo()) >= 0) {
				padre.setDer(p);
			} else {
				padre.setIzq(p);
			}
		}
	}

	public Nodito<T> buscaPadre(Nodito<T> actual, Nodito<T> p) {
		Nodito<T> padre = null;

		while (actual != null) {
			padre = actual;
			if (p.getInfo().compareTo(padre.getInfo()) >= 0) {
				actual = padre.getDer();
			} else {
				actual = padre.getIzq();
			}
		}

		return padre;
	}

	public String preOrden(Nodito<T> r) {
		if (r != null) {
			return r.getInfo() + "-" + preOrden(r.getIzq()) + "-" + preOrden(r.getDer());
		} else {
			return "";
		}
	}

	public String inOrden1(Nodito<T> r) {
		if (r != null) {
			return inOrden1(r.getIzq()) + "-" + r.getInfo() + "-" + inOrden1(r.getDer());
		} else {
			return "";
		}
	}

	public String inOrden2(Nodito<T> r) {
		if (r != null) {
			return inOrden2(r.getDer()) + "-" + r.getInfo() + "-" + inOrden2(r.getIzq());
		} else {
			return "";
		}
	}

	public String posOrden(Nodito<T> r) {
		if (r != null) {
			return posOrden(r.getIzq()) + "-" + posOrden(r.getDer()) + "-" + r.getInfo();
		} else {
			return "";
		}
	}

	public static boolean buscaDato(Nodito<Integer> nodo, int dato) {
		if (nodo == null) {
			return false;
		}
		if (dato == nodo.getInfo()) {
			return true;
		} else if (dato > nodo.getInfo()) {
			return buscaDato(nodo.getDer(), dato);
		} else {
			return buscaDato(nodo.getIzq(), dato);
		}
	}

	public String imprimeNodosF(Nodito<T> nodo) {
		String cadena = "";
		if (nodo != null) {
			if (nodo.getIzq() == null && nodo.getDer() == null) {
				cadena += nodo.getInfo().toString() + ", ";
			} else {
				cadena += imprimeNodosF(nodo.getIzq());
				cadena += imprimeNodosF(nodo.getDer());
			}
		}
		return cadena;
	}

	public int alturaArbol(Nodito<T> nodo) {
		if (nodo == null) {
			return 0;
		} else {
			int alturaIzq = alturaArbol(nodo.getIzq());
			int alturaDer = alturaArbol(nodo.getDer());

			return Math.max(alturaIzq, alturaDer) + 1;
		}
	}

	public String buscInteriores(Nodito<T> nodo) {
		String cadena = "";
		if (nodo != null) {
			if (nodo != raiz && (nodo.getIzq() != null || nodo.getDer() != null)) {
				cadena += nodo.getInfo().toString() + ", ";
			}
			cadena += buscInteriores(nodo.getIzq());
			cadena += buscInteriores(nodo.getDer());
		}
		return cadena;
	}

	public void dibujarArbol() {
		if (arbolVacio()) {
			Tools.ImprimeMensaje("El árbol está vacío.");
			return;
		}
		StringBuilder sb = new StringBuilder();
		dibujarNodo(getRaiz(), sb, "", true);
		Tools.ImprimeMensaje(sb.toString() + "Binario" + JOptionPane.INFORMATION_MESSAGE);
	}

	private void dibujarNodo(Nodito<T> nodo, StringBuilder sb, String prefijo, boolean esIzquierdo) {
		if (nodo != null) {
			sb.append(prefijo).append(esIzquierdo ? "├── " : "└── ").append(nodo.getInfo().toString()).append("\n");
			dibujarNodo(nodo.getDer(), sb, prefijo + (esIzquierdo ? "│   " : "    "), false);
			dibujarNodo(nodo.getIzq(), sb, prefijo + (esIzquierdo ? "│   " : "    "), true);
		}
	}
}
