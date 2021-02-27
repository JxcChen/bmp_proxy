public class Lesson {

    public String name;
    public String language;
    public String price;

    public Lesson(String name, String language, String price) {
        this.name = name;
        this.language = language;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Lesson() {
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", price=" + price +
                '}';
    }
}
