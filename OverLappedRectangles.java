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
     *
     * Point p was clicked, move the correct rectangle to the top.
     * Note that, in order to tell which rectangle was clicked,
     * we must examine all the rectangles from lowest index to highest index
     * to find the rectangle clicked. That's because of the z-order in the 
     * linked list.
     *
     * @param p the point clicked by the mouse. Move the clicked rectangle to the top.
     
     */
    public void moveToTop( Point p ) {
        
    //** My Code Below **********************************************************************
        
        // Boolean status for if rectangle is located
        boolean rectLocated = false;
        
        // Create current RN from private RN bottom
        RectangleNode current = bottom;
        
        // Create null RectangleNodes
        RectangleNode beforeCurrent = null;        
        RectangleNode updateBeforeCurrent = null;
        RectangleNode updateCurrent = null;      
        
        // Check for a null list initially
        while (current != null) {
            ColorRectangle rectangle = current.get();
            // Check if rectLocated passes contains checks
            if (contains(p, rectangle)) {                
                updateBeforeCurrent = beforeCurrent;
                updateCurrent = current;
                rectLocated = true;
            }
            if (current.next == null) {
                break;
            }
            beforeCurrent = current;
            current = current.next;
        }
        
        current = updateCurrent;
        beforeCurrent = updateBeforeCurrent;
        if (rectLocated) {
            if (current == bottom) {
                bottom = bottom.next;
            } 
            else {
                beforeCurrent.next = current.next;
            }    
            addRect(current.get());
        }
        current = bottom;
        while (current != null) {
            current = current.next;
        }
            
    //** My Code Above **********************************************************************
    
    }
    
    //** My Code Below **********************************************************************
    
    /**
     * Determine if points are contained within the rectangle. 
     *
     * @param p the point clicked by the mouse. Move the clicked rectangle to the top.
     * @param r the colorrectangle to be checked
     * @return true if point is contained, false otherwise.
     */
    public boolean contains(Point p, ColorRectangle r) {
        if ((p.getX() >= r.getX()) 
             && (p.getX() <= r.getX() + r.getWidth()) 
             && (p.getY() >= r.getY()) 
             && (p.getY() <= r.getY() + r.getHeight())) {
            return true;
        }
        return false;
    }
    
    //** My Code Above **********************************************************************
   
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