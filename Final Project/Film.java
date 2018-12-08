import java.util.ArrayList;

public class Film {

	int mov_id;
	double score;
	String Title,Director;
	ArrayList<String> Cast;
	ArrayList<Integer> Keyword,Genres;
	public Film(int id , String Tit) {
		score = 0;
		Title = Tit;
		mov_id = id;
		Director = "";
		Cast = new ArrayList<String>();
		Keyword = new ArrayList<Integer>();
		Genres = new ArrayList<Integer>();
		
	}
}
