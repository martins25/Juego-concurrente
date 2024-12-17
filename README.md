# Juego Concurrente

Este repositorio contiene una implementación en Java de un juego concurrente donde varios jugadores compiten para adivinar un número secreto generado por el árbitro. El proyecto utiliza conceptos avanzados de concurrencia en Java como hilos, barreras cíclicas (`CyclicBarrier`) y sincronización con monitores.

## Descripción General

El juego sigue las siguientes reglas:
- El árbitro genera un número aleatorio entre 1 y 50 al inicio del juego.
- Cada jugador toma turnos para intentar adivinar el número.
- Los jugadores no pueden repetir números ya jugados.
- El juego termina cuando un jugador adivina el número correcto.

### Clases Principales

1. **`Principal`**
   - Punto de entrada del programa.
   - Inicializa los jugadores y el árbitro.
   - Gestiona la ejecución concurrente del juego.

2. **`Arbitro`**
   - Supervisa el juego.
   - Genera el número aleatorio y controla los turnos.
   - Coordina las rondas utilizando una barrera cíclica.

3. **`Jugador`**
   - Cada jugador es un hilo independiente que realiza intentos de adivinar el número.
   - Genera números aleatorios y los envía al árbitro mediante la clase `Cola`.

4. **`Cola`**
   - Implementa una cola sincronizada para la comunicación entre los jugadores y el árbitro.
   - Garantiza que solo un valor esté disponible a la vez.

---

## Diagrama de Flujo

1. El programa inicia con la clase `Principal`, que crea los objetos necesarios.
2. Los jugadores y el árbitro comienzan a ejecutar sus hilos.
3. Los jugadores toman turnos para realizar jugadas mientras el árbitro valida los números.
4. Si un jugador adivina el número, el juego finaliza y se declara al ganador.

---

## Tecnologías Usadas
- **Lenguaje:** Java
- **Concurrencia:**
  - Hilos (`Thread`)
  - Barreras cíclicas (`CyclicBarrier`)
  - Sincronización con monitores (`synchronized`, `wait`, `notifyAll`)

---

## Ejecución del Proyecto

### Requisitos

- **Java:** Versión 8 o superior.
- **IDE recomendado:** IntelliJ IDEA, Eclipse o cualquier editor de texto con soporte para Java.

### Instrucciones

1. Clona el repositorio:
   ```bash
   git clone https://github.com/martins25/Juego-concurrente
   cd Juego-concurrente
   ```

2. Compila las clases:
   ```bash
   javac *.java
   ```

3. Ejecuta el programa:
   ```bash
   java Principal
   ```

---

## Detalles de las Clases

### **Principal**
- Inicializa la cola y los jugadores.
- Inicia los hilos para el árbitro y los jugadores.

### **Arbitro**
- Genera un número aleatorio.
- Coordina turnos y rondas.
- Declara al ganador cuando un jugador adivina el número.

### **Jugador**
- Genera números aleatorios.
- Envia su jugada a la cola compartida.
- Espera su turno utilizando la barrera cíclica.

### **Cola**
- Sincroniza el acceso entre los jugadores y el árbitro.
- Solo permite almacenar y recuperar un número a la vez.

---

## Ejemplo de Salida

```plaintext
EL ARBITRO A ESCOGIDO EL Nº 5

RONDA 1 - TURNO 1
-------
   Nº jugador 1 apuesta al número 28
   Nº jugador 5 No es su turno
   Nº jugador 3 No es su turno
   Nº jugador 4 No es su turno
   Nº jugador 2 No es su turno

RONDA 1 - TURNO 2
-------
   Nº jugador 2 apuesta al número 48
   Nº jugador 3 No es su turno
   Nº jugador 4 No es su turno
   Nº jugador 5 No es su turno
   Nº jugador 1 No es su turno

RONDA 1 - TURNO 3
-------
   Nº jugador 1 No es su turno
   Nº jugador 2 No es su turno
   Nº jugador 4 No es su turno
   Nº jugador 3 apuesta al número 24
   Nº jugador 5 No es su turno

RONDA 1 - TURNO 4
-------
   Nº jugador 5 No es su turno
   Nº jugador 2 No es su turno
   Nº jugador 1 No es su turno
   Nº jugador 4 apuesta al número 36
   Nº jugador 3 No es su turno

RONDA 1 - TURNO 5
-------
   Nº jugador 3 No es su turno
   Nº jugador 4 No es su turno
   Nº jugador 5 No es su turno
   Nº jugador 2 No es su turno
   Nº jugador 1 apuesta al número 40

RONDA 2 - TURNO 2
-------
   Nº jugador 1 No es su turno
   Nº jugador 3 No es su turno
   Nº jugador 4 No es su turno
   Nº jugador 5 No es su turno
   Nº jugador 2 apuesta al número 5
GANADOR!!! el jugador 2

```

---

## Contribución
Si deseas mejorar este proyecto o reportar algún problema, puedes abrir un issue o enviar un pull request.

---

### Autor
Proyecto desarrollado como ejercicio de aprendizaje en concurrencia utilizando Java.

