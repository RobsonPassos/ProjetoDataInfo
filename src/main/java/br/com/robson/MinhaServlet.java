package br.com.robson;


import br.com.robson.bean.MeuEJB;
import br.com.robson.entity.SalvadadosxmlEntity;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/minhaServlet")
@MultipartConfig
@Named
public class MinhaServlet extends HttpServlet {


    @EJB
    private MeuEJB meuEJB;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chegou aqui doPost");
        try {
            Part filePart = req.getPart("xmlFile");
            if (filePart != null) {
                InputStream xmlInputStream = filePart.getInputStream();
                List<String> tagContents = extractTagContents(xmlInputStream);
                meuEJB.salvarTagsXML(tagContents);


                List<SalvadadosxmlEntity> listaDados = meuEJB.listarDados();
                req.setAttribute("listaDados", listaDados);

                // Encaminhe para a página JSP que exibirá a lista
                RequestDispatcher dispatcher = req.getRequestDispatcher("/listaRegistros.jsp");
                dispatcher.forward(req, resp);

//                resp.sendRedirect(req.getContextPath() + "/listaRegistros.jsp");
            } else {
                System.out.println("Nenhum arquivo enviado.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Chegou aqui doGet");
    }

    @Override
    public void destroy() {
        System.out.println("Chegou aqui destroy");
    }


    public List<String> extractTagContents(InputStream xmlInputStream) {
        List<String> tagContents = new ArrayList<>();

        try {
            // Configuração do parser DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Analisa o arquivo XML
            Document document = builder.parse(xmlInputStream);

            // Obtém a raiz do documento
            Element root = document.getDocumentElement();

            // Chama o método para imprimir o conteúdo das tags
            extractTagContent(root, tagContents);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao processar o arquivo XML.");
        }

        return tagContents;
    }

    private static void extractTagContent(Element element, List<String> tagContents) {
        String content = element.getTextContent().trim();
        tagContents.add(content);

        // Recupera os filhos do elemento
        NodeList childNodes = element.getChildNodes();

        // Itera sobre os filhos
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                // Chama o método recursivamente para extrair os filhos
                extractTagContent((Element) childNodes.item(i), tagContents);
            }
        }
    }

    public void printAllTagsContent(InputStream xmlInputStream) {
        try {
            // Configuração do parser DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Analisa o arquivo XML
            Document document = builder.parse(xmlInputStream);

            // Obtém a raiz do documento
            Element root = document.getDocumentElement();

            // Chama o método para imprimir o conteúdo das tags
            printTagContent(root);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao processar o arquivo XML.");
        }
    }

    private static void printTagContent(Element element) {
        System.out.println(element.getTagName() + ": " + element.getTextContent().trim());

        // Recupera os filhos do elemento
        NodeList childNodes = element.getChildNodes();

        // Itera sobre os filhos
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                // Chama o método recursivamente para imprimir os filhos
                printTagContent((Element) childNodes.item(i));
            }
        }
    }
}