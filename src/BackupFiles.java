import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class BackupFiles {

  public static void backupFiles(final Path sourceDirectory, final Path destinationDirectory) throws IOException {
   
    Files.walk(sourceDirectory)
        .forEach(filePath -> {
          final Path destinationFilePath = destinationDirectory.resolve(sourceDirectory.relativize(filePath));

          try {
            Files.copy(filePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
          } catch (final IOException e) {
            e.printStackTrace();
          }
        });
  }
  
}
