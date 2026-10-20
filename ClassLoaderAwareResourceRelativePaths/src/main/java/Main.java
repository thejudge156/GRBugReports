import java.net.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    public static void main(String[] a) throws Exception {
      URL u = Main.class.getResource("/data/.mcassetsroot");
      System.out.println("url=" + u);
      URI uri = u.toURI();
      Path p;
      try {
        p = Paths.get(uri);
      } catch (FileSystemNotFoundException e) {
        try {
          FileSystems.newFileSystem(uri, Map.of());
        } catch (FileSystemAlreadyExistsException ig) {
        }
        p = Paths.get(uri);
      }
      Path dp = p.getParent();
      System.out.println("dp=" + dp + " isDir=" + Files.isDirectory(dp));
      try (DirectoryStream<Path> ds = Files.newDirectoryStream(dp)) {
        for (Path c : ds) System.out.println("  pack " + c.getFileName());
      }
    }
}