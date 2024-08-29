package za.ac.cput.util;

import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import java.io.File;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class FileUtils {
    /**
     * Compresses image file data using Deflater.
     */
    public static byte[] compressImageFile(byte[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION);
        deflater.setInput(data);
        deflater.finish();

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length)) {
            byte[] buffer = new byte[4 * 1024];
            int length;
            while (!deflater.finished()) {
                length = deflater.deflate(buffer);
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error during compression", e);
        } finally {
            deflater.end();
        }
    }

    /**
     * Decompresses image file data using Inflater.
     */
    public static byte[] decompressImageFile(byte[] data) {
        if (data == null || data.length == 0) {
            throw new IllegalArgumentException("Input data cannot be null or empty");
        }

        Inflater inflater = new Inflater();
        inflater.setInput(data);

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(data.length)) {
            byte[] buffer = new byte[4 * 1024];
            int length;
            while (!inflater.finished()) {
                length = inflater.inflate(buffer);
                byteArrayOutputStream.write(buffer, 0, length);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Error during decompression", e);
        } catch (DataFormatException e) {
            throw new RuntimeException("Data format error during decompression", e);
        } finally {
            inflater.end();
        }
    }
    /**
     * Deletes an image file specified by the file path.
     * @param filePath The path of the file to be deleted.
     * @return true if the file was successfully deleted, false otherwise.
     */
    public static boolean deleteImageFile(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IllegalArgumentException("File does not exist at the specified path");
        }
        return file.delete();
    }
}
