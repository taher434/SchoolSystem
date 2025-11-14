import java.util.ArrayList;

class NoticeBoard {
    private ArrayList<String> newsList;

    public NoticeBoard() {
        newsList = new ArrayList<>();
    }

    public void display() {
        if (newsList.isEmpty()) {
            System.out.println("NoticeBoard is empty.");
        } else {
            System.out.println("NoticeBoard Contents: ");
            for (String news : newsList) {
                System.out.println("- " + news);
            }
        }
    }

    public void addContent(String content) {
        newsList.add(content);
        System.out.println("Content added to NoticeBoard.");
    }
}

//Ibrahim Sarran -  451000513