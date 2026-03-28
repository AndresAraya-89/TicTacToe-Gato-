package tictactoe;

/**
 *
 * @author Andres Araya
 */
public class TicTacToe {

    private int areaJuego[][];
    private int turno;

    public TicTacToe() {
        this.areaJuego = new int[3][3];
        this.turno = 2;
    }

    public TicTacToe(int tamano) {
        this.areaJuego = new int[tamano][tamano];
        this.turno = 2;
    }

    public TicTacToe(int tamano, int turno) {
        this.areaJuego = new int[tamano][tamano];
        this.turno = turno;
    }

    public int[][] getAreaJuego() {
        return areaJuego;
    }

    public void setAreaJuego(int[][] areaJuego) {
        this.areaJuego = areaJuego;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void turno() {

        if (getTurno() == 1) {
            setTurno(2);
        } else {
            setTurno(1);
        }
    }

    public boolean gane(int x, int y) {
        boolean gane = false;

        if (ganeHorizontal(x)) {
            gane = ganeHorizontal(x);

        } else if (ganeVertical(y)) {
            gane = ganeVertical(y);

        } else if (ganeDiagonalIzquierdo()) {
            gane = ganeDiagonalIzquierdo();

        } else if (ganeDiagonalDerecho()) {
            gane = ganeDiagonalDerecho();
        }

        return gane;
    }

    public boolean ganeHorizontal(int x) {
        boolean gane = false;
        int contador = 0;

        for (int i = 0; i < areaJuego.length; i++) {
            if (areaJuego[x][i] == getTurno()) {
                contador++;

                if (contador == 3) {
                    gane = true;
                }
            }
        }
        return gane;
    }

    public boolean ganeVertical(int y) {
        boolean gane = false;
        int contador = 0;

        for (int i = 0; i < areaJuego.length; i++) {
            if (areaJuego[i][y] == getTurno()) {
                contador++;

                if (contador == 3) {
                    gane = true;
                }
            }
        }

        return gane;
    }

    public boolean ganeDiagonalIzquierdo() {
        boolean gane = false;
        int contador = 0;

        for (int i = 0; i < areaJuego.length; i++) {
            if (areaJuego[i][i] == getTurno()) {
                contador++;

                if (contador == 3) {
                    gane = true;
                }
            }
        }

        return gane;
    }

    public boolean ganeDiagonalDerecho() {
        boolean gane = false;
        int contador = 0;
        int fila = areaJuego.length - 1;

        for (int i = 0; i < areaJuego.length; i++) {
            if (areaJuego[fila][i] == getTurno()) {
                contador++;

                if (contador == 3) {
                    gane = true;
                }
            }
            fila--;
        }

        return gane;
    }

    public boolean empate() {
        boolean salida = false;

        for (int i = 0; i < areaJuego.length; i++) {
            for (int j = 0; j < areaJuego.length; j++) {

                if (areaJuego[i][j] != 0) {
                    salida = true;
                } else {
                    salida = false;
                    i = areaJuego.length;
                    j = areaJuego.length;
                }
            }
        }

        return salida;
    }

    public void detenerAreaJuego() {
        for (int i = 0; i < areaJuego.length; i++) {
            for (int j = 0; j < areaJuego.length; j++) {
                if (areaJuego[i][j] == 0) {
                    areaJuego[i][j] = 3;
                }
            }
        }
    }

    public void vaciarAreaJuego() {
        for (int i = 0; i < areaJuego.length; i++) {
            for (int j = 0; j < areaJuego.length; j++) {
                areaJuego[i][j] = 0;
            }
        }
    }

    public char jugadorInvertido() {
        char jugador = ' ';
        if (getTurno() == 1) {
            jugador = 'O';
        } else if (getTurno() == 2) {
            jugador = 'X';
        }

        return jugador;
    }

}
