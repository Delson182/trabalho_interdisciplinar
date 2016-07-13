package bean;
 
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.event.FileUploadEvent;

 
@ManagedBean
public class UploadArquivo {
 
    public void handleFileUpload(FileUploadEvent event) {
    	
    	Path folder = Paths.get("B:/Teste");
    	String filename = FilenameUtils.getBaseName(event.getFile().getFileName()); 
    	String extension = FilenameUtils.getExtension(event.getFile().getFileName());
    	try {
    		InputStream input = event.getFile().getInputstream();
			Path file = Files.createTempFile(folder, filename + "-", "." + extension);
			Files.copy(input, file, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Uploaded file successfully saved in " + file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}