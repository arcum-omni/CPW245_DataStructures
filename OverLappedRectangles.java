/*
 * File OverLappedRectangles.java
 *
 * Author Ken Meerdink
 * Author Travis Eiler
*/

import java.awt.*;
import java.util.*;

/**
 *
 * This class keeps track of the z-order of the rectangles in
 * a graphics window. The class is able to reorder the rectangles
 * as needed when one is clicked to bring it to the front.
 * It has a method to draw itself in the graphics window.
 *
 * @author Ken Meerdink
 * @version CPW 245 Winter 2017 Programming Assignment 5
 *
 * @author Travis Eiler
 * @version CPW 245 Winter 2020 Programming Assignment 5
 *
 */

public class OverLappedRectangles {
    /**
     * bottom is the lowest of all the rectangles in the graphics window.
     * It acts as the list of rectangles via linking.
     * The objects contained are rectangles, each with its own color.
     */
    private RectangleNode bottom;
   
    /**
     *
     * The default constructor is the only constructor.
     * It allocates an empty linked list.
     * Code provided for Programming Assignment 8
     *
     */
    public OverLappedRectangles() {
        bottom = null;
    }
   
    /**
     * Point p was clicked, move the correct rectangle to the top.
     * Note that, in order to tell which rectangle was clicked,
     * we must examine all the rectangles from lowest index to highest index
     * to find the rectangle clicked. That's because of the z-order in the 
     * linked list.
     *
     * @param p the point clicked by the mouse. Move the clicked rectangle to the top.
     */
    public void moveToTop( Point p ) {
            
        // Boolean status if rectangle is clicked
        boolean clickedRectangle = false;
        
        // Create current RectangleNode from private RectangleNode bottom
        RectangleNode current = bottom; // front
        
        // Create null RectangleNodes
        RectangleNode previous = null;
        RectangleNode revisedPrevious = null;
        RectangleNode revised = null;
        
        // Check for a null list initially
        while (current != null) {
            ColorRectangle rectangle = current.rect;
            
            // Check if clickedRectangle contains point p
            if (isContained(p, rectangle)) {
                revisedPrevious = previous;
                revised = current;
                clickedRectangle = true;
            }
            
            // If current.next is null, we have found the last rectangle that contained p
            else if (current.next == null) {
                break;
            }
            
            previous = current;
            current = current.next;
        }
        
        current = revised;
        previous = revisedPrevious;
        
        if (clickedRectangle) {
        
            if (current == bottom) {
                bottom = bottom.next;
            }
            
            else {
                previous.next = current.next;
            }
            addRect(current.rect);
        }
        
        current = bottom;
        
        while (current != null) {
            current = current.next;
        }
    }
    
    /**
     * Determine if point is contained within the rectangle. 
     *
     * @param p the point clicked by the mouse. Move the clicked rectangle to the top.
     * @param r the colorrectangle to be checked
     * @return true if point is contained, else false.
     */
    public boolean isContained(Point p, ColorRectangle r) {
        return (p.getX() >= r.getX()) && (p.getX() <= r.getX() + r.getWidth()) && (p.getY() >= r.getY()) && (p.getY() <= r.getY() + r.getHeight());
    }
   
    /**
     * Add r to top of z-list.
     * Code provided for Programming Assignment 8
     *
     * @param r The rectangle to be added to the z-list.
     */
    public void addRect( ColorRectangle r ) {
        if( bottom == null ) {
            bottom = new RectangleNode( r );
        }
        else {
        RectangleNode current = bottom;
            while( current.next != null ) {
                current = current.next;
            }
            current.next = new RectangleNode( r );
        }
    }
   
    /**
     * Draw the rectangles.
     * Code provided for Programming Assignment 8
     *
     * @param g The graphics object in the client code.
     */
    public void drawOn( Graphics g ) {
        RectangleNode current = bottom;
        while( current != null ) {
            g.setColor( current.get().getColor() );
            g.fillRect( current.get().getX(),  
                        current.get().getY(),
                        current.get().getWidth(),
                        current.get().getHeight() );
            g.setColor( Color.BLACK );
            g.drawRect( current.get().getX(),  
                        current.get().getY(),
                        current.get().getWidth(),
                        current.get().getHeight() );
            current = current.next;
        }
    }
    
    private class RectangleNode {
        public ColorRectangle rect;
        public RectangleNode next;
    
        public RectangleNode( ColorRectangle rect, RectangleNode next ) {
            this.rect = rect;
            this.next = next;
        }
        public RectangleNode( ColorRectangle rect ) {
            this( rect, null );
        }
        public ColorRectangle get() {
            return rect;
        }
    }
}