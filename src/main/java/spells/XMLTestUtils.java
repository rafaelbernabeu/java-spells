package br.bernabeu;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class XMLTestUtils {

    public void addRandomNode(Document document) {
        String tagName = String.valueOf(getPositiveRandomIndex());
        Element element = document.createElement(tagName);
        element.setNodeValue(tagName);
        this.getRandomNode(document).appendChild(element);
    }

    public void removeRandomNode(Document document) {
        NodeList childNodes = document.getChildNodes();
        document.removeChild(getRandomNode(childNodes));
    }

    public void changeRandomNode(Document document) {
        getRandomNode(document.getChildNodes()).setNodeValue(String.valueOf(getPositiveRandomIndex()));
    }

    private Node getRandomNode(Document document) {
        List<Node> allNodes = getAllNodes(document.getChildNodes());
        return allNodes.get(getRandomIndex(allNodes.size()));
    }

    private Node getRandomNode(NodeList nodeList) {
        return nodeList.item(getRandomIndex(nodeList.getLength()));
    }

    private int getRandomIndex(int limit) {
        return new Random().nextInt(limit);
    }

    private int getPositiveRandomIndex() {
        return getRandomIndex(Integer.MAX_VALUE);
    }

    private List<Node> getAllNodes(NodeList nodeList) {
        List<Node> allNodesList = new ArrayList<>();
        int childNodesLength = nodeList.getLength();
        if (childNodesLength == 0) { return allNodesList; }
        for (int i = 0; i < childNodesLength; i++) {
            Node item = nodeList.item(i);
            allNodesList.add(item);
            allNodesList.addAll(getAllNodes(item.getChildNodes()));
        }
        return allNodesList;
    }
}
