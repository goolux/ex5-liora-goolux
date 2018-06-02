package DirectoryProcessor;
import java.io.File;
import java.io.FileFilter;

/**
 * an abstract class whice is a facade of java.io.File.
 */
public class FileFacade  {

    private File file;

    protected FileFacade(String s) {
        file=new File(s);
    }
    private FileFacade(File file){
        this.file=file;
    }
    public boolean canWrite() {
        return file.canWrite();
    }

    public boolean isHidden() {
        return file.isHidden();
    }

    public String getName() {
        return file.getName();
    }

    public long length() {
        return file.length();
    }

    public boolean isFile() {
        return file.isFile();
    }
    public FileFacade[] listFiles(FileFilter fileFilter){
        File[] listFiles=file.listFiles(fileFilter);
        FileFacade[] listFilesFacade;
        if (listFiles==null){//if this abstract pathname does not denote a directory, or if an I/O error occurs.
            return null;
        }
        listFilesFacade=new FileFacade[listFiles.length];
        for (int i = 0; i <listFiles.length ; i++) {
            listFilesFacade[i]=new FileFacade(listFiles[i]);
            }
        return listFilesFacade;
    }
    public boolean canExecute(){
        return file.canExecute();
    }


}