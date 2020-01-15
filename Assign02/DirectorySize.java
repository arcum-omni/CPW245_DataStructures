// Travis Eiler
// CPW 245, Winter '20
// Assignment #2: Stacks
// Due: Jan 15, 2020

// The purpose of this program is to use stacks & queues to find the directory size.

import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class DirectorySize {
    public static void main( String[] args ) {
        System.out.print( "Enter a directory or file: " );
        Scanner input = new Scanner( System.in );
        File directory = new File( input.nextLine() );
        
        System.out.println( getSizeRecursive( directory )
                          + " bytes" );
        System.out.println( getSizeStack( directory )
                          + " bytes" ); 
        System.out.println( getSizeQueue( directory )
                          + " bytes" );
    }
    
    public static long getSizeRecursive( File file ) {
        long size = 0;
        
        if ( file.isDirectory() ) {
            File[] files = file.listFiles();
            for ( int i = 0; files != null && i < files.length; i++ ) {
                size += getSizeRecursive( files[ i ] );
            }
        }
        else {
            size += file.length();
        }
        
        return size;
    }
    
    public static long getSizeStack( File file ) {
        // Referred to Oracle Docs for Java File Class Methods
        // https://docs.oracle.com/javase/7/docs/api/java/io/File.html
        Stack<File> fileStack = new Stack<File>();
        long size = 0;
        fileStack.push(file);
        while(!fileStack.isEmpty()){
            File temp = fileStack.pop();
            if(temp.isFile()){
                size += temp.length();
            }
            else{
                File [] fileArr = temp.listFiles();
                for(int i=0; i<fileArr.length; i++){
                    fileStack.push(fileArr[i]);
                }
            }
        }
        return size;
    }
    
    public static long getSizeQueue( File file ) {
        Queue<File> fileQueue = new LinkedList<File>();
        long size = 0;
        fileQueue.add(file);
        while(!fileQueue.isEmpty()){
            File temp = fileQueue.remove();
            if(temp.isFile()){
                size += temp.length();
            }
            else{
                File [] fileArr = temp.listFiles();
                for(int i=0; i<fileArr.length; i++){
                    fileQueue.add(fileArr[i]);
                }
            }
        }
        return size;
    }
}