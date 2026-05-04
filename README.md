# TicTacToe (Gato)

Implementación clásica del juego del Gato (Tic-Tac-Toe) en **Java** con interfaz gráfica **Swing**, desarrollada como proyecto del curso de **Algoritmos y Estructura de Datos** a inicios del año 2023.

El proyecto está estructurado siguiendo una separación entre el **modelo** (lógica del juego) y la **vista** (interfaz gráfica), lo que facilita su mantenimiento y comprensión.

---

## Tecnologías

- **Lenguaje:** Java (`source/target = 1.8`)
- **GUI:** Java Swing (`JFrame`, `JPanel`, `JLabel`, `JButton`, `GridLayout`, `GroupLayout`)
- **IDE:** NetBeans (incluye `build.xml`, `manifest.mf` y carpeta `nbproject/`)
- **Look & Feel:** Nimbus

---

## Estructura del proyecto

```
TicTacToe-Gato-/
├── src/
│   └── tictactoe/
│       ├── TicTacToe.java          # Modelo: lógica del juego
│       ├── VistaTicTacToe.java     # Vista/Controlador: interfaz Swing
│       └── VistaTicTacToe.form     # Formulario generado por NetBeans
├── nbproject/                      # Configuración del proyecto NetBeans
├── build.xml                       # Script Ant
├── manifest.mf
└── README.md
```

---

## Arquitectura

### `TicTacToe.java` — Modelo

Encapsula el estado y las reglas del juego sin depender de la interfaz gráfica.

**Estado interno:**
- `int[][] areaJuego`: matriz que representa el tablero. Cada casilla guarda:
  - `0` → casilla vacía
  - `1` → ficha del Jugador 1 (`X`)
  - `2` → ficha del Jugador 2 (`O`)
  - `3` → casilla bloqueada (al finalizar la partida)
- `int turno`: jugador con el turno activo.

**Constructores sobrecargados:**
- `TicTacToe()` → tablero 3×3 por defecto.
- `TicTacToe(int tamano)` → tablero de tamaño configurable.
- `TicTacToe(int tamano, int turno)` → tamaño + jugador inicial.

**Operaciones principales:**
| Método | Descripción |
|--------|-------------|
| `turno()` | Alterna el turno entre Jugador 1 y Jugador 2. |
| `gane(x, y)` | Verifica si el último movimiento produjo victoria. |
| `ganeHorizontal(x)` | Comprueba alineación en la fila `x`. |
| `ganeVertical(y)` | Comprueba alineación en la columna `y`. |
| `ganeDiagonalIzquierdo()` | Diagonal principal (↘). |
| `ganeDiagonalDerecho()` | Diagonal secundaria (↙). |
| `empate()` | Verifica si todas las casillas están ocupadas. |
| `detenerAreaJuego()` | Marca las casillas restantes como bloqueadas tras una victoria. |
| `vaciarAreaJuego()` | Reinicia el tablero (botón *Reiniciar*). |
| `jugadorInvertido()` | Devuelve el carácter (`X` u `O`) del jugador que **acaba de jugar**, usado por el indicador de turno. |

### `VistaTicTacToe.java` — Vista / Controlador

Extiende `JFrame` e implementa `MouseListener`. Se encarga de:

- Renderizar el tablero como una cuadrícula de `JLabel` dentro de `panelFondoJuego` con `GridLayout`.
- Capturar los clics del usuario (`mouseClicked`) y traducirlos a movimientos sobre el modelo.
- Pintar la ficha (`X` / `O`) según el valor de la matriz tras cada jugada.
- Mostrar mensajes de victoria o empate mediante `JOptionPane`.
- Reiniciar la partida con el botón `btnReiniciar`.
- Mantener un indicador de turno actualizado en `jlabelIndicador` mediante un hilo (`hiloIndicador`).

---

## Compilación y ejecución

### Opción 1 — NetBeans
1. Abrir el proyecto en NetBeans.
2. Ejecutar con **Run → Run Project** (`F6`).
3. La clase principal está configurada como `tictactoe.VistaTicTacToe`.

### Opción 2 — Ant (línea de comandos)
```bash
ant clean jar
java -jar dist/TicTacToe.jar
```

### Opción 3 — javac directo
```bash
javac -d build src/tictactoe/*.java
java -cp build tictactoe.VistaTicTacToe
```

---

## Guía de uso

### 1. Pantalla de Inicio y Tablero Vacío
Al iniciar la aplicación, se presenta la ventana principal con el clásico tablero de 3x3 limpio. Por defecto, el juego está configurado para dos jugadores locales. El Jugador 1 siempre inicia la partida utilizando la ficha "X", seguido por el Jugador 2 con la ficha "O".

<img width="259" height="300" alt="image" src="https://github.com/user-attachments/assets/6364c3c5-8e36-4c8e-8b2c-879d2944e912" />

### 2. Realizando un Movimiento
Para realizar una jugada, el usuario en turno simplemente debe hacer clic en cualquiera de las casillas vacías. El sistema registrará la jugada, mostrará la ficha correspondiente y pasará automáticamente el turno al siguiente jugador. El sistema bloquea las casillas ya ocupadas para evitar movimientos inválidos.

<img width="259" height="300" alt="image" src="https://github.com/user-attachments/assets/2a2a9e32-76c8-4369-a20f-e932f11983b0" />

### 3. Condiciones de Victoria
El juego monitorea constantemente el estado del tablero. Si un jugador logra alinear tres de sus fichas de forma consecutiva (ya sea en línea horizontal, vertical o diagonal), el sistema detendrá los turnos y mostrará un mensaje declarando al ganador.

<img width="259" height="300" alt="image" src="https://github.com/user-attachments/assets/850a69fe-7ef5-47c7-9677-aa2f14641ca4" />

### 4. Empate (Tablas)
Si las nueve casillas del tablero se llenan y ningún jugador ha logrado alinear tres fichas, el sistema identificará la partida como un empate, notificando a ambos jugadores que no hay un ganador.

<img width="259" height="300" alt="image" src="https://github.com/user-attachments/assets/87e830fc-0c3e-4062-ae46-4212e8424bbc" />

### 5. Reiniciar la Partida
Una vez finalizado el juego (ya sea por victoria o empate), los jugadores pueden iniciar una nueva partida utilizando el botón **Reiniciar**. Esto limpiará el tablero y devolverá el turno inicial al Jugador 1, permitiendo jugar de nuevo sin tener que cerrar la aplicación.

<img width="259" height="300" alt="image" src="https://github.com/user-attachments/assets/e1088f45-c351-4ffa-9423-48207e036d0c" />

---

## Autor

**Andres Araya** — Proyecto académico del curso de Algoritmos y Estructura de Datos (2023).
