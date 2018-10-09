package inte_proj18.game;

import java.util.ArrayList;

public class PlayMap {
	public int width;
	public int height;
	public ArrayList<PlayMapPosition> playMapArray = new ArrayList<PlayMapPosition>();
	private int mapSize;
	
	PlayMap (int width, int height){
		this.width = width;
		this.height = height;
		if(width>height) {
			mapSize= width;
		}else {
			mapSize=height;
		}
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				PlayMapPosition pmp = new PlayMapPosition(i,j);
				playMapArray.add(pmp);	
//				System.out.print("*");
			}
//			System.out.println("");
		}
		
	}

}
