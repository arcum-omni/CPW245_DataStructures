// This program uses the SearchTree class to construct a binary
// search tree of strings and a binary search tree of integers
// and printing out each.

import java.util.*;

public class SearchTreeClient {
    public static void main(String[] args) {
        String[] bandNames = { "The Beatles",
                               "Gorillaz",
                               "Bubble Puppy",
                               "A Flock of Seagulls",
                               "Buffalo Springfield",
                               "Iron Butterfly", 
                               "The Animals",
                               "Steppenwolf",
                               "The Turtles",
                               "The Byrds",
                               "The Lemon Pipers",
                               "The Eagles",
                               "The Flamingos",
                               "The Monkees",
                               "The Zombies",
                               "Three Dog Night" 
                               };
        SearchTree<String> bandTree = new SearchTree<String>();
        for ( int i = 0; i < bandNames.length; i++ ) {
            bandTree.add( bandNames[i] );
        }

        System.out.println();
        System.out.println("Alphabetized list:");
        bandTree.printInOrder();
        
        System.out.println("Tree printed sideways:" );
        bandTree.printSideways();
        
        LinkedList<String> leaves = bandTree.getLeaves();
        System.out.println( "leaves:" );
        System.out.println( leaves );
        
    }
}
