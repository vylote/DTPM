package vn.edu.dtpm.patterns.structural.composite;

/**
 * Leaf Node: Thẻ HTML lá chỉ chứa nội dung văn bản (p, h1, li, span, ...), không có thẻ con.
 */
public class HtmlElement extends HtmlTag {
    private final String tagName;
    private String startTag = "";
    private String endTag = "";
    private String tagBody = "";

    public HtmlElement(String tagName) {
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
    public void setTagBody(String tagBody) {
        this.tagBody = tagBody;
    }

    @Override
    public void generateHtml() {
        System.out.println("  " + startTag + tagBody + endTag);
    }
}

