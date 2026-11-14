package xmlparser;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

import java.awt.*;
import java.io.File;

public class Main extends JFrame {

    private JTree tree;
    private DefaultMutableTreeNode root;

    public Main() {

        setTitle("XML-парсер");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Создание корневого узла
        root = new DefaultMutableTreeNode("XML-документ");

        // Создание дерева
        tree = new JTree(root);

        JScrollPane scrollPane = new JScrollPane(tree);

        add(scrollPane, BorderLayout.CENTER);

        // Кнопка открытия файла
        JButton openButton = new JButton("Открыть XML-файл");

        openButton.addActionListener(e -> openFile());

        add(openButton, BorderLayout.NORTH);

        setVisible(true);
    }

    // Открытие XML-файла
    private void openFile() {

        JFileChooser chooser = new JFileChooser();

        chooser.setFileFilter(
                new javax.swing.filechooser.FileNameExtensionFilter(
                        "XML-файлы", "xml"
                )
        );

        int result = chooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            File file = chooser.getSelectedFile();

            try {

                parseXML(file);

                JOptionPane.showMessageDialog(
                        this,
                        "XML-файл успешно загружен!"
                );

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        this,
                        "Ошибка при чтении XML-файла:\n"
                                + e.getMessage(),
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    // Разбор XML-файла
    private void parseXML(File file) throws Exception {

        DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();

        // Запрет внешних сущностей XML
        factory.setFeature(
                "http://apache.org/xml/features/disallow-doctype-decl",
                true
        );

        factory.setFeature(
                "http://xml.org/sax/features/external-general-entities",
                false
        );

        factory.setFeature(
                "http://xml.org/sax/features/external-parameter-entities",
                false
        );

        DocumentBuilder builder =
                factory.newDocumentBuilder();

        Document document = builder.parse(file);

        // Получение корневого элемента
        Element element = document.getDocumentElement();

        // Очистка старого дерева
        root.removeAllChildren();

        // Создание дерева XML
        DefaultMutableTreeNode xmlRoot =
                createTree(element);

        root.add(xmlRoot);

        // Обновление отображения
        tree.setModel(
                new javax.swing.tree.DefaultTreeModel(root)
        );

        tree.expandRow(0);
    }

    // Рекурсивное создание узлов дерева
    private DefaultMutableTreeNode createTree(Element element) {

        DefaultMutableTreeNode node =
                new DefaultMutableTreeNode(element.getTagName());

        NodeList children = element.getChildNodes();

        boolean hasElements = false;

        for (int i = 0; i < children.getLength(); i++) {

            Node child = children.item(i);

            if (child.getNodeType() == Node.ELEMENT_NODE) {

                hasElements = true;

                node.add(createTree((Element) child));
            }
        }

        // Получение текстового содержимого
        if (!hasElements) {

            String text = element.getTextContent().trim();

            if (!text.isEmpty()) {
                node.setUserObject(
                        element.getTagName() + ": " + text
                );
            }
        }

        return node;
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Main();
        });
    }
}