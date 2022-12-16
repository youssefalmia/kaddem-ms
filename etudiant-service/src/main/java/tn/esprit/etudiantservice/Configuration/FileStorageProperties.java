package tn.esprit.etudiantservice.Configuration;


import org.springframework.boot.context.properties.*;
import org.springframework.stereotype.*;

/**
 * @author Jozef
 */

@ConfigurationProperties(prefix = "file")
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
