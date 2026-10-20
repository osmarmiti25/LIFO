class Nodo {
    int dato;
    Nodo sig;
    Nodo(int dato, Nodo sig) { this.dato = dato; this.sig = sig; }
}

class Pila {
    private Nodo cima;

    void push(int x) { cima = new Nodo(x, cima); }

    int pop() {
        if (cima == null) throw new RuntimeException("Pila vacía");
        int x = cima.dato;
        cima = cima.sig;
        return x;
    }

    int peek() {
        if (cima == null) throw new RuntimeException("Pila vacía");
        return cima.dato;
    }

    boolean estaVacia() { return cima == null; }
}

public class LIFO {
    static int evaluar(String expr) {
        Pila p = new Pila();
        for (String t : expr.split(" ")) {
            if (t.matches("\\d+")) {
                p.push(Integer.parseInt(t));
            } else {
                int b = p.pop();
                int a = p.pop();
                switch (t) {
                    case "+": p.push(a + b); break;
                    case "-": p.push(a - b); break;
                    case "*": p.push(a * b); break;
                    case "/": p.push(a / b); break;
                }
            }
        }
        return p.pop();
    }

    public static void main(String[] args) {
        String[] pruebas = {
            "3 4 +", "5 2 *", "9 3 /", "8 5 -", "2 3 4 * +",
            "5 1 2 + 4 * + 3 -", "6 2 / 3 +", "7 2 3 * -",
            "4 5 + 2 *", "10 2 8 * + 3 -"
        };
        for (int i = 0; i < pruebas.length; i++) {
            System.out.println((i + 1) + ". " + pruebas[i] + " = " + evaluar(pruebas[i]));
        }
    }
}