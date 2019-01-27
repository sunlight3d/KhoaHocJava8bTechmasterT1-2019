/*
Download: https://github.com/mozilla/geckodriver/releases
export PATH=$PATH:/Users/hoangnd/Documents/geckodriver
* */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        HTTPRequest.getInstance().getFilmsFromURL("http://www.phimmoi.net/phim-le/");
    }
}
