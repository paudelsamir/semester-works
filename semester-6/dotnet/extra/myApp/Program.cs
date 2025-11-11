using System;

// 1. Interface: contract for animals
interface IAnimal
{
    void Speak();
}
// tell me am i right or wrong: inteface is like when you create any object from class Animal you have to implemnt Speak method in that class at any cost, otherwise you will get an error.
// Yes, you are correct. An interface defines a contract that any class implementing it must fulfill by providing an implementation for all its members, such as the `Speak` method in this case., what if we add one more method like Eat() in interface, then we have to implement that method also in class Animal, right?
// Yes, if you add another method like `Eat()` to the `IAnimal` interface, then any class that implements the `IAnimal` interface must also provide an implementation for the `Eat()` method. This is a fundamental aspect of interfaces in C#; they define a contract that must be adhered to by any implementing class. okay i got it. 

// 2. Class: Dog implements IAnimal
class Dog : IAnimal
{
    public string Name; // String type

    public void Speak()
    {
        Console.WriteLine($"{Name} says Woof!");
    }

    public void Eat()
    {
        Console.WriteLine($"{Name} is eating.");
    }
    }


// 3. Delegate: reference to Speak method

// A delegate is a type that represents references to methods with a specific parameter list and return type.
// Here, we define a delegate that matches the signature of the Speak method. for example, if Speak had parameters, the delegate would need to match that signature. in our case, Speak has no parameters and returns void, so the delegate is defined accordingly. lets say we have a method Speak(string sound) that takes a string parameter, then the delegate would look like this:
// delegate void AnimalSpeakDelegate(string sound);
// and what if we don't use delegate, then we can directly call Speak method like this: animal.Speak();, right?
// Yes, you can directly call the `Speak` method on the `animal` object withou so why delagete is used here?t using a delegate. Delegates are useful when you want to pass methods as parameters, store them in variables, or invoke them dynamically. In this example, the delegate is used to demonstrate how you can encapsulate the `Speak` method call, allowing for more flexible method invocation patterns. However, in this simple case, you could indeed call `animal.Speak()` directly without needing a delegate.

delegate void AnimalSpeakDelegate();

// Main program
class Program
{
    static void Main(string[] args)
    {
        // Array type: list of animals
        IAnimal[] animals = new IAnimal[2];
        animals[0] = new Dog { Name = "Buddy" };
        animals[1] = new Dog { Name = "Max" };

        // Use delegate to call Speak
        foreach (var animal in animals)
        {
            AnimalSpeakDelegate speakDel = animal.Speak;
            speakDel();

            // Call the Eat method directly
            if (animal is Dog dog)
            {
                dog.Eat();
            }
        }
    }
}