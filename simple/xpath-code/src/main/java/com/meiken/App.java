package com.meiken;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        DocumentBuilderFactory documentBuilderFactory  = DocumentBuilderFactory.newInstance();

        // 开启验证
        documentBuilderFactory.setValidating(true);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setIgnoringElementContentWhitespace(false);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);

        // 创建 DocumentBuilder
        DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
        // 设置异常处理对象
        builder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {
                System.out.println("WARING:");
            }
            @Override
            public void error(SAXParseException exception) throws SAXException {
                System.out.println("ERROR:");
            }
            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                System.out.println("FATAL:");
            }
        });

        // 文档加载到一个 Document 对象中
        Document doc = builder.parse("template.xml");

        // 创建 XPathFactory
        XPathFactory factory = XPathFactory.newInstance();
        // 创建 XPath 对象
        XPath xPath = factory.newXPath();
        // 编译 XPath
        XPathExpression expr = xPath.compile("//book[author='Neal Stephenson']/title/text()");
        // 通过 XPath 表达式得到结果，第一个参数制定了XPath 表达式进行查询的上下文节点,也就是在指定节点下查找符合XPath的节点。
        // 本列中的上下文节点是整个文档；第二个参数制定了XPath表达式的返回类型
        Object result = expr.evaluate(doc, XPathConstants.NODESET);
        System.out.println(" Search Books whats Author Is Neal Stephenson");
        NodeList nodes = (NodeList) result; // 类型转换
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("Search Title that after 1997");
        nodes = (NodeList) xPath.evaluate("//book[@year>1997]/title/text()", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }

        System.out.println("Search Title and Attrs After 1997");
        nodes = (NodeList) xPath.evaluate("//book[@year>1997]/@*|//book[@year>1997]/title/text()", doc, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            System.out.println(nodes.item(i).getNodeValue());
        }
    }
}
