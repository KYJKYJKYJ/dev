package java0919_class;

class Song {
	String title;
	String artist;
	String album;
	String[] composer;
	String year;
	String track;

	public Song(String title, String artist, String album, String composer[], String year, String track) {
		super();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
	}

	public Song() {}
	
	public void Show() {
		System.out.printf("노래 제목 : %s\n", this.title);
		System.out.printf("가수 : %s\n", this.artist);
		System.out.printf("앨범 : %s\n", this.album);
		System.out.printf("작곡가 : ");
		for(int i = 0; i < composer.length; i++) {
			System.out.printf("%s", this.composer[i]);
			if(i < composer.length-1) { System.out.printf(", "); } else { System.out.println(); }
			// char chk = i < composer.length-1 ? ',' : '\n'; System.out.printf("%s%c", composer[i], chk);
		}
		System.out.printf("년도 : %s\n", this.year);
		System.out.printf("트랙 : %s\n", this.track);
	}
}

public class Java073_class {

	public static void main(String[] args) {
		Song s = new Song("Dancing Queen", "ABBA", "Arrival", 
				new String[] { "Benney Andersson", "Bjorn Ulvaeus" }, "1977", "2");
		
		s.Show();
	}

}
