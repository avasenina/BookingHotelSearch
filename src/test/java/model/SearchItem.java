package model;

public class SearchItem {
    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    private String searchString;
    public SearchItem(String searchString) {
        this.searchString = searchString;
    }
}