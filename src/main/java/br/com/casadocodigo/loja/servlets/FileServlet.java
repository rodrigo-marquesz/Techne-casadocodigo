package br.com.casadocodigo.loja.servlets;

import br.com.casadocodigo.loja.infra.FileSaver;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebServlet("/file/*")
public class FileServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

        String path = req.getRequestURI().split("/file")[1];

        Path source = Paths.get(FileSaver.SERVER_PATH + path);

        FileNameMap fileNameMap = URLConnection.getFileNameMap();

        String contentType = fileNameMap.getContentTypeFor("file:"+source);

        res.setContentType(contentType);
        res.setHeader("Content-Lenght", String.valueOf(Files.size(source)));
        res.setHeader("Content-Disposition", "filename=\""+source.getFileName().toString() + "\"");
        FileSaver.transfer(source, res.getOutputStream());
        res.reset();

    }
}
