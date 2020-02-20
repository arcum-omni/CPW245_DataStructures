import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class WindowsTester extends MouseInputAdapter {

    private Point p;
    JFrame frame;
    Graphics g;    
    OverLappedRectangles olr;
    MouseListener cl;

    public WindowsTester() {
        p = new Point();
        frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( new Dimension( 500, 550 ) );
        frame.setTitle( "Travis Eiler's Linked List Version of Overlapped Rectangles" );
        frame.setVisible( true );
        g = frame.getGraphics();
        
        olr = new OverLappedRectangles();
        
        olr.addRect( new ColorRectangle( 150, 150, 200, 300, Color.BLACK  ) );
        olr.addRect( new ColorRectangle( 40,  40,  200, 300, Color.RED    ) );
        olr.addRect( new ColorRectangle( 100, 60,  200, 300, Color.BLUE   ) );
        olr.addRect( new ColorRectangle( 25,  200, 200, 300, Color.YELLOW ) );
        olr.addRect( new ColorRectangle( 200, 100, 200, 300, Color.GREEN  ) );
        olr.addRect( new ColorRectangle( 275, 50,  200, 300, Color.GRAY   ) );
      //olr.addRect( new ColorRectangle( 300, 25,  200, 300, Color.CYAN   ) );
      //olr.addRect( new ColorRectangle( 150, 150, 200, 300, Color.BLACK  ) );
      //olr.addRect( new ColorRectangle( 75,  300, 200, 300, Color.ORANGE ) );
        
        frame.addMouseListener( this );

        olr.drawOn( g );
    }
    
    public void mousePressed( MouseEvent event ) {
        p.setX( event.getX() );
        p.setY( event.getY() );
        System.out.println( p );
        olr.moveToTop( p );
        olr.drawOn( g );
    }
    
    public static void main( String[] args ) {
        WindowsTester wt = new WindowsTester();
    }
}
