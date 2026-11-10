package vn.edu.dtpm.patterns.structural.composite;

public class CompositeTest {
    public static void test() {
        System.out.println("==================================================");
        System.out.println("--- KIỂM THỬ COMPOSITE PATTERN: CẤU TRÚC THẺ HTML ---");
        System.out.println("==================================================");

        // 1. Thẻ gốc <html>
        HtmlTag html = new HtmlParentElement("html");
        html.setStartTag("<html>");
        html.setEndTag("</html>");

        // 2. Thẻ <body>
        HtmlTag body = new HtmlParentElement("body");
        body.setStartTag("<body>");
        body.setEndTag("</body>");
        html.addChildTag(body);

        // 3. Khối thẻ <div class='header'> chứa tiêu đề <h1>
        HtmlTag divHeader = new HtmlParentElement("div");
        divHeader.setStartTag("<div class=\"header\">");
        divHeader.setEndTag("</div>");

        HtmlTag h1 = new HtmlElement("h1");
        h1.setStartTag("<h1>");
        h1.setEndTag("</h1>");
        h1.setTagBody("Dự Án Kiến Trúc Phần Mềm DTPM - Đại Học Việt Nam");
        divHeader.addChildTag(h1);
        body.addChildTag(divHeader);

        // 4. Khối danh sách <ul> chứa các thẻ <li>
        HtmlTag ul = new HtmlParentElement("ul");
        ul.setStartTag("<ul class=\"pattern-list\">");
        ul.setEndTag("</ul>");

        HtmlTag li1 = new HtmlElement("li");
        li1.setStartTag("<li>");
        li1.setEndTag("</li>");
        li1.setTagBody("Nhóm Creational (5 Mẫu Khởi Tạo: Singleton, Factory, Builder...)");
        ul.addChildTag(li1);

        HtmlTag li2 = new HtmlElement("li");
        li2.setStartTag("<li>");
        li2.setEndTag("</li>");
        li2.setTagBody("Nhóm Structural (7 Mẫu Cấu Trúc: Adapter, Facade, Composite...)");
        ul.addChildTag(li2);

        HtmlTag li3 = new HtmlElement("li");
        li3.setStartTag("<li>");
        li3.setEndTag("</li>");
        li3.setTagBody("Nhóm Behavioral (6 Mẫu Hành Vi: Observer, Strategy, State...)");
        ul.addChildTag(li3);

        body.addChildTag(ul);

        // 5. Thẻ đoạn văn <p>
        HtmlTag p = new HtmlElement("p");
        p.setStartTag("<p>");
        p.setEndTag("</p>");
        p.setTagBody("Cây DOM được kết xuất tự động theo phân cấp đối tượng Composite.");
        body.addChildTag(p);

        // 6. Thực thi render toàn bộ cây DOM
        System.out.println("KẾT QUẢ KẾT XUẤT CÂY DOM HTML:\n");
        html.generateHtml();
    }
}

