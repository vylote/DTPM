package vn.edu.dtpm.patterns.structural.composite;

import java.util.List;

/**
 * Component gốc trong mẫu Composite: Đại diện cho thẻ HTML trong cây phân cấp DOM.
 */
public abstract class HtmlTag {
    public abstract String getTagName();
    public abstract void setStartTag(String tag);
    public abstract void setEndTag(String tag);

    public void setTagBody(String tagBody) {
        throw new UnsupportedOperationException("Thao tác setTagBody không được hỗ trợ trên phần tử này.");
    }

    public void addChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("Thao tác addChildTag không được hỗ trợ trên nút lá.");
    }

    public void removeChildTag(HtmlTag htmlTag) {
        throw new UnsupportedOperationException("Thao tác removeChildTag không được hỗ trợ trên nút lá.");
    }

    public List<HtmlTag> getChildren() {
        throw new UnsupportedOperationException("Thao tác getChildren không được hỗ trợ trên nút lá.");
    }

    public abstract void generateHtml();
}

