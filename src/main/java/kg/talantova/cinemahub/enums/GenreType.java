package kg.talantova.cinemahub.enums;

public enum GenreType {
    ACTION("Боевик", "Action"),
    COMEDY("Комедия", "Comedy"),
    DRAMA("Драма", "Drama"),
    HORROR("Ужасы", "Horror"),
    THRILLER("Триллер", "Thriller"),
    SCIENCE_FICTION("Научная фантастика", "Science Fiction");

    private final String descriptionRu;
    private final String descriptionEn;

    GenreType(String descriptionRu, String descriptionEn) {
        this.descriptionRu = descriptionRu;
        this.descriptionEn = descriptionEn;
    }

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public String getDescriptionEn() {
        return descriptionEn;
    }

}
