import java.io.*;

public class InputOutputStreamDemo {
    public static void main(String[] args) {

        try {
            // WRITING BYTES

            OutputStream os = new FileOutputStream("data.bin");
            BufferedOutputStream bos = new BufferedOutputStream(os);

            String message = "Hello Java Input Output Stream";
            bos.write(message.getBytes()); // convert text to bytes

            bos.close(); // closes all streams

            // READING BYTES
            InputStream is = new FileInputStream("data.bin");
            BufferedInputStream bis = new BufferedInputStream(is);

            int data;
            while ((data = bis.read()) != -1) {
                System.out.print((char) data); // byte → char
            }

            bis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
