import java.awt.Color;
import java.util.Random;

/**
 * Class DrawDemo - provides some short demonstrations showing how to use the 
 * Pen class to create various drawings.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class DrawDemo
{
    private Canvas myCanvas;
    private Random random;

    /**
     * Prepare the drawing demo. Create a fresh canvas and make it visible.
     */
    public DrawDemo()
    {
        myCanvas = new Canvas("Drawing Demo", 500, 400);  
        myCanvas.erase();
        random = new Random();
    }

    /**
     * Draw a square on the screen.
     */
    public void drawSquare()
    {
        Pen pen = new Pen(320, 260, myCanvas);
        pen.setColor(Color.BLUE);

        square(pen);
    }

    /**
     * Draw a wheel made of many squares.
     */
    public void drawWheel()
    {
        Pen pen = new Pen(250, 200, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<36; i++) {
            square(pen);
            pen.turn(10);
        }
    }

    /**
     * Draw a square in the pen's color at the pen's location.
     */
    private void square(Pen pen)
    {
        for (int i=0; i<4; i++) {
            pen.move(100);
            pen.turn(90);
        }
    }

    /**
     * Draw some random squiggles on the screen, in random colors.
     */
    public void colorScribble()
    {
        Pen pen = new Pen(250, 200, myCanvas);

        for (int i=0; i<10; i++) {
            // pick a random color
            int red = random.nextInt(256);
            int green = random.nextInt(256);
            int blue = random.nextInt(256);
            pen.setColor(new Color(red, green, blue));

            pen.randomSquiggle();
        }
    }

    /**
     * Clear the screen.
     */
    public void clear()
    {
        myCanvas.erase();
    }

    /**
     * Dibuja un triangulo de color verde en las coordenadas indicadas por
     * parametro.
     * @param xPos La posicion inicial en el eje x.
     * @param yPos La posicion inicial en el eje y.
     */
    public void drawTriangle(int xPos,int yPos)
    {
        Pen pen = new Pen(xPos, yPos, myCanvas);
        pen.setColor(Color.GREEN);

        for (int i=0; i<3; i++) {
            pen.move(100);
            pen.turn(-120);
        }
    }

    /**
     * Dibuja un pentagono de color verde.
     */
    public void drawPentagon()
    {
        Pen pen = new Pen(200, 250, myCanvas);
        pen.setColor(Color.GREEN);

        for (int i=0; i<5; i++) {
            pen.move(100);
            pen.turn(-72);
        }
    }

    /**
     * Dibuja un poligono de color rojo con el numero de lados indicado por
     * parametro.
     * @param n El numero de lados del poligono.
     */
    public void drawPolygon(int n)
    {
        Pen pen = new Pen(200, 250, myCanvas);
        pen.setColor(Color.RED);

        for (int i=0; i<n; i++) {
            pen.move(30);
            pen.turn(-360/n);
        }
    }

    /**
     * Dibuja una espiral.
     */
    public void drawSpiral()
    {
        Pen pen = new Pen(100, 100, myCanvas);
        pen.setColor(Color.BLACK);
        pen.turn(90);

        int n = 200;
        while(n != 5) {
            pen.move(n);
            pen.turn(-90);
            n -= 5;
        }
    }
}
