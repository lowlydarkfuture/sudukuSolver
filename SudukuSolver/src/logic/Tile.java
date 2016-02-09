package logic;

public class Tile {
	private int value = 0;
	private boolean solved = false;
	private int[] possibles = new int[9];
	private boolean troubleshoot = false;
	
	public Tile (int value, boolean solved){
		this.value = value;
		this.solved = solved;
	}
	
	public boolean setValue(int possible){
		if ( possible > 9 || possible < 0 || solved == true ){
			return false;
		}
		if ( possible == 0 ){
			value = possible;
			return true;
		}
		value = possible;
		return true;
	}
	
	public int getValue(){
		return value;
	}
	
	public void setSolved(boolean value){
		solved = value;
	}
	
	public boolean getSolved(){
		return solved;
	}
	
	public void setPossible(int toTry){
		//System.out.println("toTry is: " + toTry);
		switch(toTry){
			case 0:
				if (troubleshoot)
					System.out.println("There was an attempt to set a possible value as zero, which is invalid.");
				break;
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				possibles[toTry - 1] = toTry;
				break;
			case -1:
			case -2:
			case -3:
			case -4:
			case -5:
			case -6:
			case -7:
			case -8:
			case -9:
				possibles[(toTry+1)*-1] = 0;
				break;
			default:
				System.out.println("The value " + toTry + " was attempted to be removed from a tile's possible values." +
					" The accepted values are -9 thru 9. NOTE: negative numbers are used to remove numbers from the possibilities.");
		}	
	}
	
	public int[] returnPossibles(){
		return possibles;
	}
	
	//This method returns true if there was only one option and it was able to set it, otherwise it returns false.
	public boolean setToOnlyOption(){
		if ( onlyOneOption() ){
			for ( int i = 0; i < 9; i++ ){
				if ( possibles[i] == i+1){
					setValue(i+1);
					solved = true;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean onlyOneOption(){
		boolean foundOne = false;
		for ( int i = 0; i < 9; i++){
			if ( possibles[i] == i+1 ){
				//System.out.println("This is in Tile->onlyOption. Tile sees " + (i + 1) + " as a possible option.");
				if ( foundOne == true )
					return false;
				foundOne = true;
			}
		}
		return true;
	}
}
