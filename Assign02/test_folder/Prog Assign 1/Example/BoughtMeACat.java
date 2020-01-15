// Your Name Here
// date submitterd here
// CPW 142
// Assignment #1 Example code
//
// Assignment: Write a program that prints the lyrics to "Bought Me A Cat"
// This Programming Project 6 of Chapter 1 of Building Java Programs.
public class BoughtMeACat {

    // sing all the verses.
    public static void main( String[] args ) {
    
        singCatVerse();
         
        singHenVerse();
         
        singDuckVerse();

        singGooseVerse();

        singSheepVerse();
    }

    // prints the cat verse.
    public static void singCatVerse() {
        System.out.println( "Bought me a cat and the cat pleased me," );
        System.out.println( "I fed my cat under yonder tree." );
        catGoes();
    }

    // prints the hen verse.
    public static void singHenVerse() {
        System.out.println( "Bought me a hen and the hen pleased me," );
        System.out.println( "I fed my hen under yonder tree." );
        henGoes();
        catGoes();
    }
    
    // prints the duck verse.
    public static void singDuckVerse() {
        System.out.println( "Bought me a duck and the duck pleased me," );
        System.out.println( "I fed my duck under yonder tree." );
        duckGoes();
        henGoes();
        catGoes();
    }

    // prints the goose verse.
    public static void singGooseVerse() {
        System.out.println( "Bought me a goose and the goose pleased me," );
        System.out.println( "I fed my goose under yonder tree." );
        gooseGoes();
        duckGoes();
        henGoes();
        catGoes();
    }

    // prints the sheep verse.
    public static void singSheepVerse() {
        System.out.println( "Bought me a sheep and the sheep pleased me," );
        System.out.println( "I fed my sheep under yonder tree." );
        sheepGoes();
        gooseGoes();
        duckGoes();
        henGoes();
        catGoes();
    }

    // prints the cat sound.
    public static void catGoes() {
        System.out.println( "Cat goes fiddle-i-fee." );
        System.out.println();
    }
    
    // prints the hen sound.
    public static void henGoes() {
        System.out.println( "Hen goes chimmy-chuck, chimmy-chuck," );
    }

    // prints the duck sound.
    public static void duckGoes() {
        System.out.println( "Duck goes quack, quack," );
    }

    // prints the goose sound.
    public static void gooseGoes() {
        System.out.println( "Goose goes hissy, hissy," );
    }

    // prints the sheep sound.
    public static void sheepGoes() {
        System.out.println( "Sheep goes baa, baa," );
    }
}