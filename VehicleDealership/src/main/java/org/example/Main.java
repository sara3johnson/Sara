package org.example;

//I fixed your syntax issues so take a look at them and that should help you understand
//why your code wasn't building. The logic is there, you can read from the file and
//display information, it's just you need to hook up the UserInterface to the methods in teh
//dealership class. Also, try not to use the static keyword too much. If you make a variable static,
//then any method that uses the variable also needs to be static.
//I think syntax (curly braces, where code blocks end) is still giving you problems, but hopefully
//with time it'll iron itself out.
//All in all, not bad! You're making big strides in your coding ability!
public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();

        userInterface.display();

    }
}