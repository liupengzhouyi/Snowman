package ServletPackage.FlieUpToNetwork;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "FileUploadServlet")
public class FileUploadServlet extends HttpServlet {

    public FileUploadServlet() {
            super();
    }

    public void destroy() {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //setting code
        response.setContentType("text/html; charset=UTF-8");
        //get printWriter
        PrintWriter out = response.getWriter();
        // setting flie upload dir
        String uploadDir = "\\Users\\liupeng\\Documents\\DirForJavaWeb";
        out.println("file up load dir:" + uploadDir);
        // create save dir
        File fUploadDir = new File(uploadDir);
        if (!fUploadDir.exists()) {
            if (!fUploadDir.mkdir()) {
                out.println("Can't create file save dir");
                return;
            }
        }
        if(!DiskFileUpload.isMultipartContent(request)) {
            out.println("Only do multipart/form-data type data!");
            return;
        }

        DiskFileUpload diskFileUpload = new DiskFileUpload();
        //setting biggest file size 200M
        diskFileUpload.setSizeMax(1024*1024*200);
        //setting temp save if big than 1 M
        diskFileUpload.setSizeThreshold(1024*1024);
        //setting temp save dir
        //diskFileUpload.setRepositoryPath("");
        //setting upload file name encoding
        diskFileUpload.setHeaderEncoding("UTF-8");
        //create file list
        List fileItems = null;
        try {
            fileItems = diskFileUpload.parseRequest(request);
        } catch (FileUploadException e) {
            out.println("find thous porblom!");
            e.printStackTrace(out);
            return;
        }
        //get file from list, and save to server
        // create
        Iterator iterator = fileItems.iterator();
        while(iterator.hasNext()) {
            //get file and save temp file
            FileItem fileItem = (FileItem) iterator.next();
            if (!fileItem.isFormField()) {
                try {
                    String fileDirName = fileItem.getName();
                    if (fileDirName.trim().equals("")) {
                        continue;
                    }
                    int start = fileDirName.lastIndexOf('\\');

                    String fileName = fileDirName.substring(start + 1);
                    //create save file's file object
                    File pathDest = new File(uploadDir, fileName);
                    // save file to server
                    fileItem.write(pathDest);
                } catch (Exception e) {
                    e.printStackTrace();
                    //
                    out.println("find the porblom!");
                    return;
                }
                finally {
                    //delete temp file
                    fileItem.delete();
                }
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void init() throws ServletException {

    }
}
