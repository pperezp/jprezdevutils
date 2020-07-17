package cl.prezdev.util.save;

import cl.prezdev.util.io.IO;
import cl.prezdev.util.io.Json;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import lombok.Data;

@Data
public class SaveService {

    private File saveFile;
    private SaveOption saveOption;
    private final Logger logger = Logger.getLogger("SaveService");
    
    public SaveService(File saveFile, SaveOption saveOption){
        logger.info("Save service to " + saveFile.getAbsolutePath());
        this.saveFile = saveFile;

        logger.info("Save option: " + saveOption);
        this.saveOption = saveOption;
    }
    
    public void save(Object object) throws IOException{
        logger.info("Saving...");
        boolean saved = false;

        switch(saveOption){
            case JSON:
                logger.info("to json file...");
                Json.toJsonFile(this.saveFile, object);
                saved = true;
                break;
            case COMPLETE_OBJECT:
                logger.info("to object file...");
                IO.writeObject(object, saveFile);
                saved = true;
                break;
        }

        logger.info((saved ? "saved!" : "not saved :/"));
    }
    
    public <T> T load(Class<T> _class) throws IOException, ClassNotFoundException{
        logger.info("Loading with "+ saveOption +" option...");
        switch (saveOption) {
            case JSON:
                T jsonObject = Json.toObject(saveFile, _class);
                logger.info("Loaded!");

                return jsonObject;
            case COMPLETE_OBJECT:
                T object = IO.readObject(saveFile, _class);
                logger.info("Loaded!");

                return object;
            default:
                logger.log(Level.WARNING, "Save option not compatible: "+saveOption);
                return null;
        }
        
    }
    
    public boolean existSaveFile(){
        return this.saveFile.exists();
    }
}
