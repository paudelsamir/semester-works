import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;

public class Lab11_FileIO {
    
    // Task a: RandomAccessFile for random accessing
    static void taskRandomAccessFile() {
        System.out.println("\nTask A: RandomAccessFile");
        try {
            RandomAccessFile raf = new RandomAccessFile("randomfile.txt", "rw");
            
            // Write data
            raf.writeBytes("Hello ");
            raf.writeBytes("World ");
            raf.writeBytes("Java ");
            
            // Navigate to different positions
            System.out.println("File pointer at: " + raf.getFilePointer());
            
            raf.seek(0);
            System.out.println("After seek(0), reading: " + raf.readLine());
            
            raf.seek(6);
            System.out.println("After seek(6), reading: " + raf.readLine());
            
            raf.close();
            System.out.println("RandomAccessFile operations completed");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Task b: Read from keyboard and write to file
    static void taskKeyboardToFile() {
        System.out.println("\nTask B: Read from keyboard and write to file");
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            FileWriter fw = new FileWriter("keyboard_input.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            
            System.out.print("Enter text (type 'exit' to finish): ");
            String line;
            while (!(line = br.readLine()).equals("exit")) {
                bw.write(line);
                bw.newLine();
            }
            
            bw.close();
            fw.close();
            System.out.println("Text written to keyboard_input.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Task c: Serialization and Deserialization
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;
        
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    
    static void taskSerialization() {
        System.out.println("\nTask C: Serialization and Deserialization");
        try {
            // Serialization
            Person p = new Person("Samir Paudel", 20);
            FileOutputStream fos = new FileOutputStream("person.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(p);
            oos.close();
            System.out.println("Object serialized: " + p);
            
            // Deserialization
            FileInputStream fis = new FileInputStream("person.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person deserializedPerson = (Person) ois.readObject();
            ois.close();
            System.out.println("Object deserialized: " + deserializedPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("--- File I/O Operations ---");
        
        taskRandomAccessFile();
        // taskKeyboardToFile();  // Uncomment to use interactive input
        taskSerialization();
        
        System.out.println("\n=============================");
        System.out.println("Lab No.: 11");
        System.out.println("Name: Samir Paudel");
        System.out.println("Roll No./Section: 114-079/D");
        System.out.println("=============================");
    }
}
