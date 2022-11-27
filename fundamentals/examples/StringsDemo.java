public class StringsDemo {
    public static void main(String[] args) {
        String ninja = "Coding Dojo is mids";
        int length = ninja.length();
        System.out.println( "String Length is : " + length );

        String string1 = "string1";
        String string2 = "string2";
        String string3 = string1.concat(string2);
        System.out.println(string3);

        String fart = String.format("My %s has %d %s %.2f", "fart", 4, "stinks", 69.420);
            // %s is expecting a string, %d is expecting a digit
            // And %.2f is expecting a float data type. The value 2 will just place two values to right of the decimal point.
        System.out.println(fart);

        String ninja = "Welcome to Coding Dojo!";
        int a = ninja.indexOf("Coding"); // a is 11
        int b = ninja.indexOf("co"); // b is 3
        int c = ninja.indexOf("pizza"); // c is -1, "pizza" is not found

        String sentence = "   spaces everywhere!   ";
        System.out.println(sentence.trim());
        //trim removes trailing or leading whitespaces from a string

        String a = "HELLO";
        String b = "world";
        System.out.println(a.toLowerCase()); // hello
        System.out.println(b.toUpperCase()); // WORLD

        // Normal string assignment
        String a = "same string";
        String b = "same string";
        System.out.println(a == b); // true
        // Creating new strings as separate objects (another way to create a String)
        a = new String("same letters");
        b = new String("same letters");
        System.out.println(a == b); // false. Not the same object in memory.
        System.out.println(a.equals(b)); // true. same exact characters.

        String a = new String( "Dojo" );
        System.out.println( a == "Dojo" );
        // surprisingly this will print out `false`
        // this is because the `new` keyword creates a new object in memory
        // and the `==` operator checks to see if the two objects are the same
        // object in memory
        System.out.println( a.equals( "Dojo" ) );
        // this will print out `true`
        // the `equals` method checks to see if the two objects have the same
        // value, not if they are the same object in memory

    }
}