package vn.edu.dtpm.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite Node: Thẻ HTML cha chứa nhiều thẻ con (div, body, html, ul, ...).
 */
public class HtmlParentElement extends HtmlTag {
    private final String tagName;
    private String startTag = "";
    private String endTag = "";
    private final List<HtmlTag> children = new ArrayList<>();

    public HtmlParentElement(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public String getTagName() {
        return tagName;
    }

    @Override
    public void setStartTag(String tag) {
        this.startTag = tag;
    }

    @Override
    public void setEndTag(String tag) {
        this.endTag = tag;
    }

    @Override
    public void addChildTag(HtmlTag htmlTag) {
        children.add(htmlTag);
    }

    @Override
    public void removeChildTag(HtmlTag htmlTag) {
        children.remove(htmlTag);
    }

    @Override
    public List<HtmlTag> getChildren() {
        return children;
    }

    @Override
    public void generateHtml() {
        System.out.println(startTag);
        for (HtmlTag child : children) {
            child.generateHtml();
        }
        System.out.println(endTag);
    }
}

