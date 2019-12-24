package entity;

/**
 * Docx对象
 *
 * @author kamjin1996
 */
public class Docx {

    /**
     * DocX文档的名称
     */
    private String name;

    /**
     * DocX文档的内容
     */
    private String text;

    public Docx() {
    }

    public Docx(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
