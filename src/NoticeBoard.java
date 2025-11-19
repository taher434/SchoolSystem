class NoticeBoard {
    private String[] newsList;
    private int newsCount;
    private String inchargeName;

    public NoticeBoard() {
        this.newsList = new String[100]; 
        this.newsCount = 0;
        this.inchargeName = "Admin"; 
    }

    public void display() {
        System.out.println("Notice Board (Incharge: " + inchargeName + ")");
        if (newsCount == 0) {
            System.out.println("No news available.");
        } else {
            for (int i = 0; i < newsCount; i++) {
                System.out.println("- " + newsList[i]);
            }
        }
    }

    public void addContent(String content) {
        if (newsCount < newsList.length) {
            newsList[newsCount] = content;
            newsCount++;
            System.out.println("Content added.");
        }
    }
}

//Ibrahim Sarran -  451000513