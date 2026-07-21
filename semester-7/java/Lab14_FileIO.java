import java.io.*;
import java.util.Scanner;

public class Lab14_FileIO {

    // Task a: FileInputStream read
    static void taskFileInputStream() {
        System.out.println("\n--- Task A: FileInputStream Read ---");
        try {
            File f = new File("lab14_test.txt");
            if (!f.exists()) {
                try (FileWriter fw = new FileWriter(f)) {
                    fw.write("Hello from FileInputStream!\nLine 2\nLine 3");
                }
            }
            FileInputStream fis = new FileInputStream(f);
            int ch;
            System.out.print("File content: ");
            while ((ch = fis.read()) != -1) {
                System.out.print((char) ch);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task b: FileOutputStream write
    static void taskFileOutputStream() {
        System.out.println("\n--- Task B: FileOutputStream Write ---");
        try {
            String data = "Written via FileOutputStream.\n";
            FileOutputStream fos = new FileOutputStream("lab14_fos_output.txt");
            fos.write(data.getBytes());
            fos.close();
            System.out.println("Data written to lab14_fos_output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task c: Read image file, write to another
    static void taskImageCopy() {
        System.out.println("\n--- Task C: Copy Image File ---");
        String src = "lab14_input.jpg";
        String dst = "lab14_output.jpg";
        try {
            // Create a minimal dummy file for demo if it doesn't exist
            File srcFile = new File(src);
            if (!srcFile.exists()) {
                try (FileOutputStream fos = new FileOutputStream(srcFile)) {
                    fos.write(new byte[]{ (byte) 0xFF, (byte) 0xD8, (byte) 0xFF, (byte) 0xE0 });
                }
                System.out.println("Created dummy source image: " + src);
            }
            FileInputStream fis = new FileInputStream(src);
            FileOutputStream fos = new FileOutputStream(dst);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fis.close();
            fos.close();
            System.out.println("Image copied: " + src + " -> " + dst);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task d: DataInputStream and DataOutputStream
    static void taskDataStreams() {
        System.out.println("\n--- Task D: DataInputStream / DataOutputStream ---");
        String file = "lab14_data.dat";
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            dos.writeInt(42);
            dos.writeDouble(3.14);
            dos.writeUTF("Java I/O");
            dos.close();

            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            System.out.println("Read int: " + dis.readInt());
            System.out.println("Read double: " + dis.readDouble());
            System.out.println("Read UTF: " + dis.readUTF());
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task e: RandomAccessFile
    static void taskRandomAccessFile() {
        System.out.println("\n--- Task E: RandomAccessFile ---");
        try {
            RandomAccessFile raf = new RandomAccessFile("lab14_raf.txt", "rw");
            raf.writeBytes("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
            System.out.println("File pointer at: " + raf.getFilePointer());
            raf.seek(5);
            System.out.println("Char at position 5: " + (char) raf.readByte());
            raf.seek(0);
            String first10 = raf.readLine().substring(0, 10);
            System.out.println("First 10 chars: " + first10);
            raf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task f: FileReader
    static void taskFileReader() {
        System.out.println("\n--- Task F: FileReader ---");
        try {
            File f = new File("lab14_reader_test.txt");
            if (!f.exists()) {
                try (FileWriter fw = new FileWriter(f)) {
                    fw.write("FileReader test content.");
                }
            }
            FileReader fr = new FileReader(f);
            int ch;
            System.out.print("FileReader content: ");
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task g: FileWriter
    static void taskFileWriter() {
        System.out.println("\n--- Task G: FileWriter ---");
        try {
            FileWriter fw = new FileWriter("lab14_fw_output.txt");
            fw.write("Written via FileWriter.\nSecond line.\n");
            fw.close();
            System.out.println("Data written to lab14_fw_output.txt via FileWriter");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task h: Keyboard to file
    static void taskKeyboardToFile() {
        System.out.println("\n--- Task H: Keyboard to File ---");
        try {
            Scanner sc = new Scanner(System.in);
            FileWriter fw = new FileWriter("lab14_keyboard.txt");
            System.out.println("Enter text (type 'exit' on a new line to finish):");
            while (true) {
                String line = sc.nextLine();
                if (line.equals("exit")) break;
                fw.write(line + "\n");
            }
            sc.close();
            fw.close();
            System.out.println("Input saved to lab14_keyboard.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Task i: Serialization and Deserialization
    static class Person implements Serializable {
        private static final long serialVersionUID = 1L;
        String name;
        int age;
        Person(String name, int age) { this.name = name; this.age = age; }
        public String toString() { return "Person{name='" + name + "', age=" + age + "}"; }
    }

    static void taskSerialization() {
        System.out.println("\n--- Task I: Serialization & Deserialization ---");
        String file = "lab14_person.ser";
        try {
            Person p = new Person("Shishir Pandey", 22);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(p);
            oos.close();
            System.out.println("Serialized: " + p);

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            Person restored = (Person) ois.readObject();
            ois.close();
            System.out.println("Deserialized: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println("--- File I/O Demonstration (9 Tasks) ---");

        taskFileInputStream();
        taskFileOutputStream();
        taskImageCopy();
        taskDataStreams();
        taskRandomAccessFile();
        taskFileReader();
        taskFileWriter();
        // taskKeyboardToFile();  // Uncomment to use interactive keyboard input
        taskSerialization();

        System.out.println("\nLab No.: 14");
        System.out.println("Name: Shishir Pandey");
        System.out.println("Roll No./Section: 15/079, Section: A");
    }
}
